package net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser;

import com.mojang.logging.LogUtils;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.ironf.alchemind.BlockDimPos;
import net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.slf4j.Logger;

import java.util.*;

import static net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity.findAcceleratorSpeed;

public class arcanaInfuserBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {
    private static final Logger LOGGER = LogUtils.getLogger();

    public arcanaInfuserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANA_INFUSER.get(), pos, state);
    }
    public Integer processingTicks = 0;

    public Integer arcanaRef;

    public static void tick(Level level, BlockPos pos, BlockState blockState, arcanaInfuserBlockEntity pEntity) {
        if (level.isClientSide){
            return;
        }

        pEntity.arcanaRef = arcana_maps.ArcanaMap.get(new BlockDimPos(pos,level));

        arcanaInfuser.ArcanaTick(level, pos, 8000, 10, 0, false, true);
        if (pEntity.processingTicks < processingSpeed(pEntity)){
            pEntity.processingTicks++;
        }

    }


    public static boolean processingReady(arcanaInfuserBlockEntity pEntity){
        float pSpeed = processingSpeed(pEntity);
        return pSpeed != 80 && pEntity.processingTicks >= pSpeed;
    }

    public static float processingSpeed(arcanaInfuserBlockEntity pEntity){
        return (80 - Math.round(findAcceleratorSpeed(pEntity)/16));
    }

    public float getRenderedHeadOffset(float partialTicks) {
        if (findAcceleratorSpeed(this) == 0)
            return 0;
        int runningTicks = Math.abs(processingTicks);
        float pSpeed = processingSpeed(this);
        float ticks = Mth.lerp(partialTicks, pSpeed , runningTicks);
        return Mth.clamp((pSpeed - ticks) / pSpeed * 3, 0, 1);
    }


    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(componentSpacing.plainCopy().append("Arcana Within: " + arcana_maps.ArcanaMap.get(new BlockDimPos(this.getBlockPos(), this.level)) + "/8000"));
        return true;
    }

    @Override
    public void onLoad() {
        this.arcanaRef = arcana_maps.ArcanaMap.get(new BlockDimPos(this.getBlockPos(),this.getLevel()));
        super.onLoad();
    }

    protected BeltProcessingBehaviour beltProcessing;

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        beltProcessing = new BeltProcessingBehaviour(this).whenItemEnters(this::onItemReceived).whileItemHeld(this::whenItemHeld);
        behaviours.add(beltProcessing);
    }



    private static final RecipeWrapper WRAPPER = new RecipeWrapper(new ItemStackHandler(1));

    public static Optional<ArcanaInfuserRecipe> grabRecipe(Level level, ItemStack stack){
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, stack);
        Optional<ArcanaInfuserRecipe> recipe = level.getRecipeManager().getRecipeFor(ArcanaInfuserRecipe.Type.INSTANCE,inventory, level);
        return recipe;


    }
    public static ItemStack getInfusionResult(Level level, ItemStack stack){
        return grabRecipe(level, stack).map(ArcanaInfuserRecipe::getResultItem).orElse(ItemStack.EMPTY);
    }
    protected BeltProcessingBehaviour.ProcessingResult onItemReceived(TransportedItemStack transported, TransportedItemStackHandlerBehaviour handler) {
        if (handler.blockEntity.isVirtual()){
            return BeltProcessingBehaviour.ProcessingResult.PASS;
        }

        if (getInfusionResult(level, transported.stack) == ItemStack.EMPTY){
            return BeltProcessingBehaviour.ProcessingResult.PASS;
        }


        return BeltProcessingBehaviour.ProcessingResult.HOLD;
    }

    protected BeltProcessingBehaviour.ProcessingResult whenItemHeld(TransportedItemStack transported, TransportedItemStackHandlerBehaviour handler) {
        if (!processingReady(this)){
            return BeltProcessingBehaviour.ProcessingResult.HOLD;
        }

        if (getInfusionResult(level, transported.stack) == ItemStack.EMPTY){
            return BeltProcessingBehaviour.ProcessingResult.PASS;
        }



        if(arcanaRef.floatValue() < grabRecipe(level,transported.stack).get().getArcanaRequired()) {
            return BeltProcessingBehaviour.ProcessingResult.HOLD;
        }


        //Time to Craft
        ItemStack out = grabRecipe(level,transported.stack).get().getResultItem();
        if (!out.isEmpty()) {
            List<TransportedItemStack> outList = new ArrayList<>();

            TransportedItemStack held = null;

            TransportedItemStack result = transported.copy();
            result.stack = out;

            createEffect(this);
            if (!transported.stack.isEmpty()) {
                held = new TransportedItemStack(new ItemStack(transported.stack.getItem().asItem(),transported.stack.getCount() - 1));
            }
            outList.add(result);
            handler.handleProcessingOnItem(transported, TransportedItemStackHandlerBehaviour.TransportedResult.convertToAndLeaveHeld(outList, held));
            arcana_maps.ArcanaMap.put(new BlockDimPos(this.getBlockPos(),level),(int) (arcanaRef.floatValue() - grabRecipe(level,transported.stack).get().getArcanaRequired()));
        }


        return BeltProcessingBehaviour.ProcessingResult.HOLD;
    }

    private static void createEffect(arcanaInfuserBlockEntity pEntity){
        Level level = pEntity.getLevel();
        assert level != null;
        level.addParticle(ParticleTypes.ELECTRIC_SPARK, pEntity.getBlockPos().getX(),pEntity.getBlockPos().getY()-0.9,pEntity.getBlockPos().getZ(),0,0.45,3);
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


}
