package net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.fluid.SmartFluidTank;

import net.ironf.alchemind.BlockDimPos;
import net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.ironf.alchemind.fluid.custom.EssenceFluidType;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

import static net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity.findAcceleratorSpeed;

public class ArcanaRadiatorBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {

    //Traditional Arcana Stuff
    public ArcanaRadiatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANA_RADIATOR.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState blockState, ArcanaRadiatorBlockEntity pEntity) {
        if (level.isClientSide){
            return;
        }

        SmartFluidTank FluidTank = pEntity.tank.getPrimaryHandler();

        pEntity.arcanaRef = arcana_maps.ArcanaMap.get(new BlockDimPos(pos,level));
        if (FluidTank.getFluid().getAmount() > 0 && FluidTank.getFluid().getFluid().getFluidType() instanceof EssenceFluidType && arcana_maps.ArcanaMap.get(new BlockDimPos(pos,level)) != 500){
            ArcanaRadiator.ArcanaTick(level, pos, 500,findTransferValue(pEntity),((EssenceFluidType) FluidTank.getFluid().getFluid().getFluidType()).arcanaValue * Mth.roundToward(findGenerationValue(pEntity),1), true, false);
            FluidTank.drain(Mth.roundToward(findGenerationValue(pEntity),1), IFluidHandler.FluidAction.EXECUTE);
        } else {
            ArcanaRadiator.ArcanaTick(level, pos, 500,findTransferValue(pEntity),0, true, false);
        }
    }

    public static int findGenerationValue(ArcanaRadiatorBlockEntity pEntity){
        return switch (findHeating(pEntity)) {
            case KINDLED -> (int) ((findAcceleratorSpeed(pEntity) / 2));
            case SEETHING -> (int) ((findAcceleratorSpeed(pEntity)));
            default -> (int) (findAcceleratorSpeed(pEntity) / 4 );
        };
    }

    public static int findTransferValue(ArcanaRadiatorBlockEntity pEntity){
        return switch (findHeating(pEntity)) {
            case KINDLED -> (int) ((findAcceleratorSpeed(pEntity) / 4));
            case SEETHING -> (int) ((findAcceleratorSpeed(pEntity) / 2));
            default -> (int) (findAcceleratorSpeed(pEntity) / 8);
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

        tooltip.add(componentSpacing.plainCopy().append("Arcana Within: " + arcana_maps.ArcanaMap.get(new BlockDimPos(this.getBlockPos(), this.level)) + "/500"));
        return containedFluidTooltip(tooltip,isPlayerSneaking,getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY));
    }

}
