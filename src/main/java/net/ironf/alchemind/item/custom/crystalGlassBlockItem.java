package net.ironf.alchemind.item.custom;

import net.minecraft.world.level.block.Block;

public class crystalGlassBlockItem extends toolTipBlockItem{
    public crystalGlassBlockItem(Block block, Properties builder) {
        super(block, builder);
    }

    @Override
    public String getToolTipLangKey() {
        return "block.alchemind.crystal_glass.tool_tip";
    }
}
