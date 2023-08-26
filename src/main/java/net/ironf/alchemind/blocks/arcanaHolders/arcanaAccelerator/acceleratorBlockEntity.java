package net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator;

import com.simibubi.create.content.kinetics.BlockStressValues;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.foundation.data.CreateBlockEntityBuilder;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.arcanaHolders.potionCatalyzer.potionCatalyzerBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class acceleratorBlockEntity extends KineticBlockEntity {
    public acceleratorBlockEntity(BlockEntityType<?> type,BlockPos pos, BlockState state) {
        super(ModBlockEntities.ACCELERATOR.get(), pos, state);
    }

    @Override
    public float calculateStressApplied() {
        float impact = 5;
        this.lastStressApplied = impact;
        return impact;
    }

    @Override
    public void tick() {
        super.tick();
    }

    public float getAcceleratorPower(){
        BlockEntity catalyzer = this.getLevel().getBlockEntity(this.getBlockPos().above());
        if (catalyzer != null && catalyzer.getType() == ModBlockEntities.POTION_CATALYZER.get()){
            return ((potionCatalyzerBlockEntity) catalyzer).active() ?  Math.abs(this.getSpeed()) * 4: Math.abs(this.getSpeed());
        } else {
            return Math.abs(this.getSpeed());
        }
    }




}
