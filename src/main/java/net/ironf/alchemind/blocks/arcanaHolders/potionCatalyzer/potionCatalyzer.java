package net.ironf.alchemind.blocks.arcanaHolders.potionCatalyzer;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator.ArcanaRadiatorBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class potionCatalyzer extends BaseEntityBlock implements IBE<potionCatalyzerBlockEntity> {
    public potionCatalyzer(Properties properties) {
        super(properties);
    }


    @Override
    public Class<potionCatalyzerBlockEntity> getBlockEntityClass() {
        return potionCatalyzerBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends potionCatalyzerBlockEntity> getBlockEntityType() {
        return ModBlockEntities.POTION_CATALYZER.get();
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.POTION_CATALYZER.get(), potionCatalyzerBlockEntity::tick);
    }


}
