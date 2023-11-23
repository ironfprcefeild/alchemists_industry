package net.ironf.alchemind.item.custom;

import net.minecraft.world.level.block.Block;

public class zoomdustBlockItem extends toolTipBlockItem{
    public zoomdustBlockItem(Block block, Properties builder) {
        super(block, builder);
    }

    @Override
    public String getToolTipLangKey() {
        return "block.alchemind.zoomdust_block.tool_tip";
    }
}
