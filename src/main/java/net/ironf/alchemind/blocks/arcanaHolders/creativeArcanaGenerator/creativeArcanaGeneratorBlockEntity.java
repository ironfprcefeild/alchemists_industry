package net.ironf.alchemind.blocks.arcanaHolders.creativeArcanaGenerator;

import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import net.ironf.alchemind.BlockDimPos;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class creativeArcanaGeneratorBlockEntity extends BlockEntity implements IHaveGoggleInformation {

    public creativeArcanaGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CREATIVE_ARCANA_GENERATOR.get(), pos, state);
    }


    public static void tick(Level level, BlockPos pos, BlockState blockState, creativeArcanaGeneratorBlockEntity pEntity) {
        if (level.isClientSide){
            return;
        }

        pEntity.arcanaRef = arcana_maps.ArcanaMap.get(new BlockDimPos(pos,level));

        creativeArcanaGenerator.ArcanaTick(level, pos, 50000, 50000, 50000, true, false);


    }

    public Integer arcanaRef;
    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        tooltip.add(componentSpacing.plainCopy().append("Plenty"));
        return true;
    }

    @Override
    public void onLoad() {
        this.arcanaRef = arcana_maps.ArcanaMap.get(new BlockDimPos(this.getBlockPos(),this.getLevel()));
        super.onLoad();
    }
}
