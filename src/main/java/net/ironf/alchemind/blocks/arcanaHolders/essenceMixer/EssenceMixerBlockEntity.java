package net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator;

import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.fluid.SmartFluidTank;

import net.ironf.alchemind.BlockDimPos;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.ironf.alchemind.fluid.custom.EssenceFluidType;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ArcanaRadiatorBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {

    //Traditional Arcana Stuff
    public ArcanaRadiatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANA_RADIATOR.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState blockState, ArcanaRadiatorBlockEntity pEntity) {
        if (level.isClientSide){
            return;
        }

        SmartFluidTank FluidTank = tank.getPrimaryHandler();
        arcanaRef = arcana_maps.ArcanaMap.get(new BlockDimPos(pos,level));

        if (FluidTank.getFluid().getAmount() > 1 && FluidTank.getFluid().getFluid().getFluidType() instanceof EssenceFluidType && arcanaRef != 500){
            ArcanaRadiator.ArcanaTick(level, pos, 500,3,2, true, false);
            tank.getPrimaryHandler().setFluid(new FluidStack(FluidTank.getFluid(), FluidTank.getFluidAmount() - 2));
        } else {
            ArcanaRadiator.ArcanaTick(level, pos, 500,3,0, true, false);

        }



    }

    //Fluid Handling


    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    static Integer arcanaRef;

    static SmartFluidTankBehaviour tank;

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        tank = SmartFluidTankBehaviour.single(this, 1000);
        behaviours.add(tank);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyFluidHandler = LazyOptional.of(() -> tank.getPrimaryHandler());

    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyFluidHandler.invalidate();
    }


    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap,@Nullable Direction side) {

        if(cap == ForgeCapabilities.FLUID_HANDLER) {
            return lazyFluidHandler.cast();
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
        tooltip.add(componentSpacing.plainCopy().append("Arcana Within: " + arcanaRef.toString() + "/500"));
        return containedFluidTooltip(tooltip,isPlayerSneaking,lazyFluidHandler);
    }

}
