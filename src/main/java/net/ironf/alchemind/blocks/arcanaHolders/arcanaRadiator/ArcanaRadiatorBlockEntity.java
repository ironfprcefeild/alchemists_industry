package net.ironf.alchemind.blocks.arcanaHolders.arcanaLink;

import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ArcanaLinkBlockEntity extends BlockEntity {
    public ArcanaLinkBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANA_LINK.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState blockState, ArcanaLinkBlockEntity pEntity) {
        if (level.isClientSide){
            return;
        }
        ArcanaLink.ArcanaTick(level, pos, 100,100,1, false, true);
    }
}
