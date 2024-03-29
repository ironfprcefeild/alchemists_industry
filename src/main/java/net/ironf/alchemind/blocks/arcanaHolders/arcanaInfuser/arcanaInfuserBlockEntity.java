package net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser;

import com.mojang.logging.LogUtils;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.ironf.alchemind.SmartBlockPos;
import net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.IArcanaReader;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

import java.util.*;

import static net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity.findAcceleratorSpeed;

public class arcanaInfuserBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation, IArcanaReader, IAcceleratorReaderBlockEntity {
    private static final Logger LOGGER = LogUtils.getLogger();

    public arcanaInfuserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANA_INFUSER.get(), pos, state);
    }
    public Integer processingTicks = 0;

    public Integer arcanaRef;

    @Override
    public void tick() {
        if (this.level.isClientSide){
            return;
        }

        BlockPos pos = this.getBlockPos();
        this.arcanaRef = IArcanaReader.getOnArcanaMap(pos);

        arcanaInfuser.ArcanaTick(level, pos, 8000, 10, 0, false, true);
        if (this.processingTicks < processingSpeed()){
            this.processingTicks++;
        }

    }


    public boolean processingReady(){
        float pSpeed = processingSpeed();
        return pSpeed != 160 && this.processingTicks >= pSpeed;
    }

    public float processingSpeed(){
        return (160 - Math.round(findAcceleratorSpeed(this)/16));
    }


    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(componentSpacing.plainCopy().append(Component.translatable("alchemind.arcana_within")).append(IArcanaReader.getOnArcanaMap(this.getBlockPos()) + "/8000"));
        return true;
    }

    @Override
    public void onLoad() {
        this.arcanaRef = IArcanaReader.getOnArcanaMap(this.getBlockPos());
        super.onLoad();
    }

    protected BeltProcessingBehaviour beltProcessing;

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        beltProcessing = new BeltProcessingBehaviour(this).whenItemEnters(this::onItemReceived).whileItemHeld(this::whenItemHeld);
        behaviours.add(beltProcessing);
    }



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
        if (!processingReady()){
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

            createEffect();
            if (!transported.stack.isEmpty()) {
                held = new TransportedItemStack(new ItemStack(transported.stack.getItem().asItem(),transported.stack.getCount() - 1));
            }
            outList.add(result);
            handler.handleProcessingOnItem(transported, TransportedItemStackHandlerBehaviour.TransportedResult.convertToAndLeaveHeld(outList, held));
            arcana_maps.ArcanaMap.put(new SmartBlockPos(this.getBlockPos()),(int) (arcanaRef.floatValue() - grabRecipe(level,transported.stack).get().getArcanaRequired()));
        }


        return BeltProcessingBehaviour.ProcessingResult.HOLD;
    }

    private void createEffect(){
        Level level = this.getLevel();
        assert level != null;
        level.addParticle(ParticleTypes.DRAGON_BREATH, this.getBlockPos().getX(),this.getBlockPos().getY()-0.9,this.getBlockPos().getZ(),0,0.45,0);
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
