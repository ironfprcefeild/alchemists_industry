package net.ironf.alchemind.blocks.arcanaHolders;

import net.ironf.alchemind.SmartBlockPos;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;

public interface IArcanaReader {
    static Integer getOnArcanaMap(SmartBlockPos pos){
        Integer toReturn = arcana_maps.ArcanaMap.get(pos);
        return toReturn != null ? toReturn : 0;
    }

    static Integer getOnArcanaMap(BlockPos pos){
        return getOnArcanaMap(new SmartBlockPos(pos));
    }
}
