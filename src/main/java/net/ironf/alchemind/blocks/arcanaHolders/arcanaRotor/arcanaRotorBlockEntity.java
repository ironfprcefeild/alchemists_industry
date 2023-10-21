package net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor;

import com.mojang.logging.LogUtils;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.base.arcanaRotorBaseBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

import java.util.List;

public class arcanaRotorBlockEntity extends GeneratingKineticBlockEntity implements IHaveGoggleInformation {
    public arcanaRotorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANA_ROTOR.get(), pos, state);
    }

    private static final Logger LOGGER = LogUtils.getLogger();

    static int ticker = 0;


    @Override
    public void tick() {

        if (findBase(this) == null){
            reActivateSource = true;
        }



        super.tick();
    }

    @Override
    public float getGeneratedSpeed() {
        return findBaseSu(this) > 0 ? 8 : 0;
    }

    @Override
    public float calculateAddedStressCapacity() {
        if (this.level.isClientSide()){
            return 0;
        }
        float capacity = findBaseSu(this)/8;
        LOGGER.info(String.valueOf(capacity));
        this.lastCapacityProvided = capacity;
        return capacity;
    }

    @Override
    public void updateGeneratedRotation() {
        super.updateGeneratedRotation();
        //this.lastCapacityProvided = findBaseSu(this)/8;
    }

    public static float findBaseSu(arcanaRotorBlockEntity pEntity){
        arcanaRotorBaseBlockEntity base = findBase(pEntity);
        return base == null ? 0 : arcanaRotorBaseBlockEntity.getSU(base);

    }

    public static arcanaRotorBaseBlockEntity findBase(arcanaRotorBlockEntity pEntity){
        BlockEntity preBase = pEntity.level.getBlockEntity(pEntity.getBlockPos().below());
        return (preBase != null && preBase.getType() == ModBlockEntities.ARCANA_ROTOR_BASE.get()) ? ((arcanaRotorBaseBlockEntity) preBase) : null;
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        return super.addToGoggleTooltip(tooltip, isPlayerSneaking);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }


}
