package net.ironf.alchemind.blocks.arcanaHolders;

import net.ironf.alchemind.BlockDimPos;
import net.ironf.alchemind.data.arcana_maps;

public interface IArcanaReader {
    public static Integer getOnArcanaMap(BlockDimPos pos){
        Integer toReturn = arcana_maps.ArcanaMap.get(pos);
        return toReturn != null ? toReturn : 0;
    }
}
