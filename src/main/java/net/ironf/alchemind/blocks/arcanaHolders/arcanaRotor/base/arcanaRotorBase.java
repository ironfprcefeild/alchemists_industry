package net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.base;

import net.ironf.alchemind.blocks.arcanaHolders.arcanaHoldingBlock;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.arcanaRotorBlockEntity;
import org.jetbrains.annotations.Nullable;

public class arcanaRotorBase extends arcanaHoldingBlock {

    public arcanaRotorBase(Properties properties) {
        super(properties, true, false);

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new arcanaRotorBaseBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.ARCANA_ROTOR_BASE.get(), arcanaRotorBaseBlockEntity::tick);
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState1, boolean b) {
        if (true || level.isClientSide()){
            return;
        }
        BlockEntity rotor = level.getBlockEntity(blockPos.above());
        if (rotor != null && rotor.getType() == ModBlockEntities.ARCANA_ROTOR.get()){
            ((arcanaRotorBlockEntity) rotor).updateGeneratedRotation();
        }
        super.onRemove(blockState, level, blockPos, blockState1, b);
    }
}
