package net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;



public class acceleratorBlock extends KineticBlock implements ICogWheel, IBE<acceleratorBlockEntity> {
    public acceleratorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }


    @Override
    public Class<acceleratorBlockEntity> getBlockEntityClass() {
        return acceleratorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends acceleratorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.ACCELERATOR.get();
    }


}
