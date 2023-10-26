package net.ironf.alchemind.blocks.arcanaHolders.essenceMixer;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.fluids.drain.ItemDrainBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.fluid.SmartFluidTank;
import net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.IArcanaReader;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;

import static net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity.findAcceleratorSpeed;

public class EssenceMixerBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation, IArcanaReader, IAcceleratorReaderBlockEntity {



    //Traditional Arcana Stuff
    public EssenceMixerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ESSENCE_MIXER.get(), pos, state);

    }
    //private static final Logger LOGGER = LogUtils.getLogger();

    public Integer arcanaRef;

    public Integer processingTicks = 0;

    public static List<EssenceMixerRecipe> recipeList;


    static HashMap<ResourceLocation[], ResourceLocation> validRecipes = new HashMap<>();

    @Override
    public void tick(){
        super.tick();
        if (level.isClientSide){
            return;
        }
        BlockPos pos = this.getBlockPos();
        this.arcanaRef = IArcanaReader.getOnArcanaMap(pos);

        if (this.processingTicks != (100 - Math.round(findAcceleratorSpeed(this)/20))){
            this.processingTicks++;
        }
        if (this.arcanaRef >= 500 && this.tank.getPrimaryHandler().isEmpty() && processingReady() && isValidMix()) {
            mixFluids();
        } else {
            EssenceMixer.ArcanaTick(level, pos, 500, 10, 0, false,true);

        }
    }

    public boolean processingReady(){
        float acSpeed = findAcceleratorSpeed(this);
        if ((100 - Math.round(acSpeed/20)) != 100 && this.processingTicks >= (100 - Math.round(acSpeed/20))){
            return true;
        }
        return false;
    }

    public List<EssenceMixerRecipe> createRecipeCollection(EssenceMixerBlockEntity pEntity){
        Level level = pEntity.getLevel();
        assert level != null;
        return level.getRecipeManager().getAllRecipesFor(EssenceMixerRecipe.Type.INSTANCE);
    }
    public static Fluid getFluidFromID(ResourceLocation id){
        return (Fluid)ForgeRegistries.FLUIDS.getValue(id);
    }

    EssenceMixerBlockEntity selfReference = this;

    ResourceManagerReloadListener listener = new ResourceManagerReloadListener() {
        @Override
        public void onResourceManagerReload(ResourceManager resourceManager) {

            //validRecipes = createMixingGuide(selfReference);
            recipeList = createRecipeCollection(selfReference);
        }
    };
    public boolean isValidMix(){
        //LOGGER.info("testing for valid mix");
        Optional<ItemDrainBlockEntity> Drain1 = getDrain(1);
        Optional<ItemDrainBlockEntity> Drain2 = getDrain(2);
        Optional<ItemDrainBlockEntity> Drain3 = getDrain(3);
        if (Drain1.isEmpty() || Drain2.isEmpty() || Drain3.isEmpty()){
            //LOGGER.info("Invalid due to missing drains");
            return false;
        }

        FluidStack[] fluidInputs = {(getTankFromDrain(Drain1.get()).getPrimaryHandler().getFluid()),(getTankFromDrain(Drain2.get()).getPrimaryHandler().getFluid()),(getTankFromDrain(Drain3.get()).getPrimaryHandler().getFluid())};
        for (EssenceMixerRecipe r : recipeList){
            if (r.tester(fluidInputs)){
                return true;
            }
        }
        //LOGGER.info("Invalid due to no recipe found");
        return false;
    }

    public static SmartFluidTankBehaviour getTankFromDrain(ItemDrainBlockEntity drain){
        Collection<BlockEntityBehaviour> all = drain.getAllBehaviours();
        for (BlockEntityBehaviour b : all){
            if (Objects.equals(b.getType(), SmartFluidTankBehaviour.TYPE)){
                return (SmartFluidTankBehaviour) b;
            }
        }
        return null;
    }
    public void mixFluids(){
        //LOGGER.info("Mixing Fluids");
        Optional<ItemDrainBlockEntity> Drain1 = getDrain(1);
        Optional<ItemDrainBlockEntity> Drain2 = getDrain(2);
        Optional<ItemDrainBlockEntity> Drain3 = getDrain(3);
        if (Drain1.isEmpty() || Drain2.isEmpty() || Drain3.isEmpty()){
            return;
        }
        SmartFluidTank drainTank1 = getTankFromDrain(Drain1.get()).getPrimaryHandler();
        SmartFluidTank drainTank2 = getTankFromDrain(Drain2.get()).getPrimaryHandler();
        SmartFluidTank drainTank3 = getTankFromDrain(Drain3.get()).getPrimaryHandler();


        FluidStack[] fluidIngredients = {(drainTank1.getFluid()),(drainTank2.getFluid()),(drainTank3.getFluid())};
        for (EssenceMixerRecipe r : recipeList){
            if (r.tester(fluidIngredients)){
                this.tank.getPrimaryHandler().fill(r.getResultFluid(),IFluidHandler.FluidAction.EXECUTE);
                getTankFromDrain(Drain1.get()).getPrimaryHandler().drain(r.getIngredientsFR().get(0).getRequiredAmount(), IFluidHandler.FluidAction.EXECUTE);
                getTankFromDrain(Drain2.get()).getPrimaryHandler().drain(r.getIngredientsFR().get(1).getRequiredAmount(), IFluidHandler.FluidAction.EXECUTE);
                getTankFromDrain(Drain3.get()).getPrimaryHandler().drain(r.getIngredientsFR().get(2).getRequiredAmount(), IFluidHandler.FluidAction.EXECUTE);
                EssenceMixer.ArcanaTick(this.getLevel(), this.getBlockPos(), 500, 10, -r.getArcanaNeeded(), false,true);
            }
        }

    }

    public Optional<ItemDrainBlockEntity> getDrain (int n){
        BlockEntity preTank = this.level.getBlockEntity(this.getBlockPos().below(n));

        if (preTank != null && preTank.getType() == AllBlockEntityTypes.ITEM_DRAIN.get()){
            ItemDrainBlockEntity tank = (ItemDrainBlockEntity) preTank;
            return Optional.of(tank);
        } else {
            return Optional.empty();
        }
    }

    public HashMap<ResourceLocation[], ResourceLocation> getValidRecipes(){
        return validRecipes;
    }




    //Fluid Handling


    public LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();




    public SmartFluidTankBehaviour tank;



    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        tank = SmartFluidTankBehaviour.single(this, 1000).forbidInsertion().allowExtraction();
        behaviours.add(tank);
    }

    @Override
    public void onLoad() {

        lazyFluidHandler = LazyOptional.of(() -> tank.getPrimaryHandler());

        //validRecipes = createMixingGuide(this);

        recipeList = createRecipeCollection(this);


        this.arcanaRef = IArcanaReader.getOnArcanaMap(this.getBlockPos());

        super.onLoad();
    }


    @Override
    protected void read(CompoundTag tag, boolean clientPacket) {
        tag.putInt("processing_ticks",this.processingTicks);
        super.read(tag, clientPacket);
    }

    @Override
    protected void write(CompoundTag tag, boolean clientPacket) {
        this.processingTicks = tag.getInt("processing_ticks");
        super.write(tag, clientPacket);

    }
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.FLUID_HANDLER) {
            return lazyFluidHandler.cast();
        }
        return super.getCapability(cap, side);
    }



    public void setFluidA(FluidStack stack) {
        tank.getPrimaryHandler().setFluid(stack);
    }

    public FluidStack getFluidStackA() {
        return tank.getPrimaryHandler().getFluid();
    }

    public SmartFluidTank getFluidTankA() {
        return tank.getPrimaryHandler();
    }


    //Goggle Business

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(componentSpacing.plainCopy().append(Component.translatable("alchemind.arcana_within")).append(IArcanaReader.getOnArcanaMap(this.getBlockPos()) + "/500"));
        containedFluidTooltip(tooltip,isPlayerSneaking,lazyFluidHandler);
        return true;
    }



}
