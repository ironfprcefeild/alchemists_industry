package net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser;

import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaHoldingBlock;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class arcanaInfuser extends arcanaHoldingBlock implements IBE<arcanaInfuserBlockEntity> {

    public arcanaInfuser(Properties properties) {
        super(properties, true, false);

    }

    @Override
    public Class<arcanaInfuserBlockEntity> getBlockEntityClass() {
        return arcanaInfuserBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends arcanaInfuserBlockEntity> getBlockEntityType() {
        return ModBlockEntities.ARCANA_INFUSER.get();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new arcanaInfuserBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.ARCANA_INFUSER.get(), arcanaInfuserBlockEntity::tick);
    }








}
