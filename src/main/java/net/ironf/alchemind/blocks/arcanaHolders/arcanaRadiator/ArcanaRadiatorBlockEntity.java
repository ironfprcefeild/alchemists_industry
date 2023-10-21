package net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.fluid.SmartFluidTank;
import net.ironf.alchemind.SmartBlockPos;
import net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.IArcanaReader;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

import static net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity.findAcceleratorSpeed;

public class ArcanaRadiatorBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation, IAcceleratorReaderBlockEntity, IArcanaReader {

    //Traditional Arcana Stuff
    public ArcanaRadiatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANA_RADIATOR.get(), pos, state);
    }

    public static void tick(Level level, BlockPos prePos, BlockState blockState, ArcanaRadiatorBlockEntity pEntity) {
        if (level.isClientSide) {
            return;
        }
        SmartBlockPos pos = new SmartBlockPos(prePos);
        SmartFluidTank FluidTank = pEntity.tank.getPrimaryHandler();
        FluidStack fluidStack = FluidTank.getFluid();
        Fluid fluid = fluidStack.getFluid();
        pEntity.arcanaRef = IArcanaReader.getOnArcanaMap(pos);
        int arcanaPerMB = EssenceRadiationHandler.radiationHandler.getOrDefault(fluid, 0);


        if (arcanaPerMB != 0 && fluidStack.getAmount() > 0 && pEntity.arcanaRef < 500){
            int mbEssenceUsed = findGenerationValue(pEntity);
            FluidTank.drain(mbEssenceUsed, IFluidHandler.FluidAction.EXECUTE);

            ArcanaRadiator.ArcanaTick(level, pos, 0, findTransferValue(pEntity), arcanaPerMB * mbEssenceUsed, true, false);
        } else{
            ArcanaRadiator.ArcanaTick(level, pos, 0, findTransferValue(pEntity), 0, true, false);
        }
    }

    int arcanaQueue = 0;

    @Override
    protected void read(CompoundTag tag, boolean clientPacket) {
        super.read(tag, clientPacket);
        this.arcanaQueue = tag.getInt("queue");
    }

    @Override
    protected void write(CompoundTag tag, boolean clientPacket) {
        super.write(tag, clientPacket);
        tag.putInt("queue",this.arcanaQueue);
    }

    //Values
    public static int findGenerationValue(ArcanaRadiatorBlockEntity pEntity){
        return switch (findHeating(pEntity)) {
            case KINDLED -> (int) Math.floor(findAcceleratorSpeed(pEntity) / 2);
            case SEETHING -> (int) findAcceleratorSpeed(pEntity);
            default -> (int) Math.floor(findAcceleratorSpeed(pEntity) / 4 );
        };
    }

    public static int findTransferValue(ArcanaRadiatorBlockEntity pEntity){
        return switch (findHeating(pEntity)) {
            case KINDLED -> (int) Math.floor(findAcceleratorSpeed(pEntity) / 4);
            case SEETHING -> (int) Math.floor(findAcceleratorSpeed(pEntity) / 2);
            default -> (int) Math.floor(findAcceleratorSpeed(pEntity) / 8);
        };
    }

    public static BlazeBurnerBlock.HeatLevel findHeating(ArcanaRadiatorBlockEntity pEntity){
        BlockEntity burner = pEntity.level.getBlockEntity(pEntity.getBlockPos().below());
        return burner != null && burner.getType() == AllBlockEntityTypes.HEATER.get() ? ((BlazeBurnerBlockEntity) burner).getHeatLevelFromBlock() : BlazeBurnerBlock.HeatLevel.NONE;
    }

    //Fluid Handling


    public LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    public Integer arcanaRef;

    public SmartFluidTankBehaviour tank;

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        behaviours.add(tank = SmartFluidTankBehaviour.single(this, 1500).forbidExtraction());
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyFluidHandler = LazyOptional.of(() -> this.tank.getPrimaryHandler());

    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyFluidHandler.invalidate();
    }


    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap,@Nullable Direction side) {

        if(cap == ForgeCapabilities.FLUID_HANDLER && side == this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()) {
            return tank.getCapability().cast();
        }

        return super.getCapability(cap, side);
    }



    public void setFluid(FluidStack stack) {
        this.tank.getPrimaryHandler().setFluid(stack);
    }

    public FluidStack getFluidStack() {
        return this.tank.getPrimaryHandler().getFluid();
    }

    //Goggle Business

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {

        tooltip.add(componentSpacing.plainCopy().append("Arcana Within: " + arcana_maps.ArcanaMap.get(new SmartBlockPos(this.getBlockPos())) + "/500"));
        return containedFluidTooltip(tooltip,isPlayerSneaking,getCapability(ForgeCapabilities.FLUID_HANDLER));
    }

}
