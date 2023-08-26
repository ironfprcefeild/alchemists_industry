package net.ironf.alchemind.blocks.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class tool_tip_block_item extends BlockItem {

    String ToolTipLangKey;

    public tool_tip_block_item(Block block, Properties properties, String ToolTipLangKey) {
        super(block, properties);
        this.ToolTipLangKey = ToolTipLangKey;
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.translatable(this.ToolTipLangKey).withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.translatable("alchemind.hold_shift").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack,level,components,flag);
    }
}
