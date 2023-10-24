package net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor;

import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaHoldingBlock;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class mineralExtractor extends arcanaHoldingBlock implements IBE<mineralExtractorBlockEntity> {

    public mineralExtractor(Properties properties) {
        super(properties, true, false);
    }


    @Override
    public void onRemove(BlockState pState, Level level, BlockPos pPos, BlockState pNewState, boolean b) {

        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pPos);
            if (blockEntity instanceof mineralExtractorBlockEntity) {
                ((mineralExtractorBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, level, pPos, pNewState, b);

    }

    @Override
    public Class<mineralExtractorBlockEntity> getBlockEntityClass() {
        return mineralExtractorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends mineralExtractorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.MINERAL_EXTRACTOR.get();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new mineralExtractorBlockEntity(pos, state);
    }






}
