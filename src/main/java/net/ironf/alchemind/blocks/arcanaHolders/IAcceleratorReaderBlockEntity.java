package net.ironf.alchemind.blocks.arcanaHolders;

import net.ironf.alchemind.BlockDimPos;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser.arcanaInfuser;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser.arcanaInfuserBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public interface IArcanaHolderBlockEntity {
    static float findAcceleratorSpeed(arcanaInfuserBlockEntity pEntity){
        BlockEntity accelerator = pEntity.getLevel().getBlockEntity(pEntity.getBlockPos().above());
        return accelerator != null && accelerator.getType() == ModBlockEntities.ACCELERATOR.get() ? Math.abs(((acceleratorBlockEntity) accelerator).getSpeed()) : 0;
    }
    

}
