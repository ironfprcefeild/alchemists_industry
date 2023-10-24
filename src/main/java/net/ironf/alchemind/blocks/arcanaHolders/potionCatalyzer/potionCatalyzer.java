package net.ironf.alchemind.blocks.arcanaHolders.potionCatalyzer;

import com.simibubi.create.foundation.block.IBE;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;


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

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }




}
