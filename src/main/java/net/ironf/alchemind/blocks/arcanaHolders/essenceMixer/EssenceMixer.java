package net.ironf.alchemind.blocks.arcanaHolders.essenceMixer;

import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaHoldingBlock;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class EssenceMixer extends arcanaHoldingBlock implements IBE<EssenceMixerBlockEntity> {

    public EssenceMixer(Properties properties) {
        super(properties, true, false);

    }

    @Override
    public Class<EssenceMixerBlockEntity> getBlockEntityClass() {
        return EssenceMixerBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends EssenceMixerBlockEntity> getBlockEntityType() {
        return ModBlockEntities.ESSENCE_MIXER.get();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EssenceMixerBlockEntity(pos, state);
    }








    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos preblockPos, BlockState state, boolean b) {
        super.onPlace(blockState, level, preblockPos, state, b);
    }






}
