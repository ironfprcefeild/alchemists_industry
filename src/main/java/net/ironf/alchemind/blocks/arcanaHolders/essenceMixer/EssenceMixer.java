package net.ironf.alchemind.blocks.arcanaHolders.essenceMixer;

import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaHoldingBlock;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
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

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.ESSENCE_MIXER.get(), EssenceMixerBlockEntity::tick);
    }






    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos preblockPos, BlockState state, boolean b) {
        super.onPlace(blockState, level, preblockPos, state, b);
    }






}
