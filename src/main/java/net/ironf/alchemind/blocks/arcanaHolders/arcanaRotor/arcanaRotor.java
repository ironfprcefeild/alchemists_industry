package net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor;

import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;


public class arcanaRotor extends DirectionalKineticBlock implements IBE<arcanaRotorBlockEntity> {

    public arcanaRotor(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return state.getValue(FACING).getAxis() == face.getAxis();
    }
    @Override
    public Class<arcanaRotorBlockEntity> getBlockEntityClass() {
        return arcanaRotorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends arcanaRotorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.ARCANA_ROTOR.get();
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getAxis();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, Direction.UP );
    }



    @Override
    public boolean hideStressImpact() {
        return true;
    }
}
