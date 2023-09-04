package net.ironf.alchemind.blocks.arcanaHolders.potionCatalyzer;

import com.mojang.logging.LogUtils;
import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.AllFluids;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.slf4j.Logger;

import java.util.List;

public class potionCatalyzerBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {

    private static final Logger LOGGER = LogUtils.getLogger();


    public potionCatalyzerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POTION_CATALYZER.get(), pos, state);
    }


    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {

    }

    public float ticksSince = 0;

    //Problem is with finding fluid tank
    public static void tick(Level level, BlockPos pos, BlockState blockState, potionCatalyzerBlockEntity pEntity) {
        // LOGGER.info("ticking catalyzer");
        IFluidTank fluidTank = getTank(pEntity);
        if (fluidTank != null && fluidTank.getFluid().getFluid().getFluidType() == AllFluids.POTION.get().getFluidType()) {
            //LOGGER.info("Found Tank");
            if (pEntity.ticksSince >= ((4096 - findAcceleratorSpeedBelow(pEntity) * 15)/32)) {
                pEntity.ticksSince = 0;
                fluidTank.drain(1, IFluidHandler.FluidAction.EXECUTE);
            } else {
                pEntity.ticksSince++;
            }
        }
    }

    public static IFluidTank getTank(potionCatalyzerBlockEntity pEntity){
        BlockEntity tank = pEntity.getLevel().getBlockEntity(pEntity.getBlockPos().above());
        return tank != null && tank.getType() == AllBlockEntityTypes.FLUID_TANK.get() ? ((FluidTankBlockEntity) tank).getControllerBE().getTankInventory() : null;
    }


    public boolean active(){
        return getTank(this) != null && getTank(this).getFluid().getFluid().getFluidType() == AllFluids.POTION.get().getFluidType();
    }

    @Override
    protected void read(CompoundTag tag, boolean clientPacket) {
        tag.putFloat("ticks_since",this.ticksSince);
        super.read(tag, clientPacket);
    }

    @Override
    protected void write(CompoundTag tag, boolean clientPacket) {
        this.ticksSince = tag.getFloat("ticks_since");
        super.write(tag, clientPacket);

    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(componentSpacing.plainCopy().append("Ticks Until Potion Consumption: " + this.ticksSince + "/" + ((4096 - findAcceleratorSpeedBelow(this) * 15)/32)));
        tooltip.add(componentSpacing.plainCopy().append(this.active() ? "Active, Accelerator speed Quadrupled" : "Inactive, not boosting accelerator"));
        return true;
    }

    static float findAcceleratorSpeedBelow(SmartBlockEntity pEntity){
        BlockEntity accelerator = pEntity.getLevel().getBlockEntity(pEntity.getBlockPos().below());
        return accelerator != null && accelerator.getType() == ModBlockEntities.ACCELERATOR.get() ? Math.abs(((acceleratorBlockEntity) accelerator).getSpeed()) : 0;
    }
}
