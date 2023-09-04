package net.ironf.alchemind.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class zoomdustBlock extends FallingBlock {
    public zoomdustBlock(Properties p_53205_) {
        super(p_53205_);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState blockState, Entity entity) {
        Direction dir = entity.getDirection();
        entity.setPos(dir.getStepX() + entity.getX(),dir.getStepY() + entity.getY(), dir.getStepZ() + entity.getZ());
        super.stepOn(level, pos, blockState, entity);
    }
}
