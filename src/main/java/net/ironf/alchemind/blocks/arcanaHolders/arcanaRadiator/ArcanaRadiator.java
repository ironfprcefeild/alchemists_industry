package net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaHoldingBlock;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ArcanaRadiator extends arcanaHoldingBlock implements IBE<ArcanaRadiatorBlockEntity>, IWrenchable {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    public ArcanaRadiator(Properties properties) {
        super(properties, false, true);

    }

    private static final VoxelShape SHAPE =
            Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, Objects.requireNonNull(pContext.getPlayer()).isCrouching() ? pContext.getHorizontalDirection().getOpposite() : pContext.getHorizontalDirection());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }


    /* BLOCK ENTITY */



    @Override
    public Class<ArcanaRadiatorBlockEntity> getBlockEntityClass() {
        return ArcanaRadiatorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends ArcanaRadiatorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.ARCANA_RADIATOR.get();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ArcanaRadiatorBlockEntity(pos, state);
    }



}
