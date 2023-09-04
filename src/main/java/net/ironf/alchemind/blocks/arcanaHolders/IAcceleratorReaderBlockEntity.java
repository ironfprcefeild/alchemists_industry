package net.ironf.alchemind.blocks.arcanaHolders;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.potionCatalyzer.potionCatalyzerBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntity;

public interface IAcceleratorReaderBlockEntity {
    static float findAcceleratorSpeed(SmartBlockEntity pEntity){
        BlockEntity accelerator = pEntity.getLevel().getBlockEntity(pEntity.getBlockPos().above());
        if (accelerator != null && accelerator.getType() == ModBlockEntities.ACCELERATOR.get()){
            return ((acceleratorBlockEntity) accelerator).getAcceleratorPower();
        }
        return 0;
    }

}
