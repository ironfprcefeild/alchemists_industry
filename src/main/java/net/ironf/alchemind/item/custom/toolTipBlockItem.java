package net.ironf.alchemind.item.custom;

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

public abstract class toolTipBlockItem extends BlockItem {

    public toolTipBlockItem(Block block, Properties builder) {
        super(block, builder);
    }

    public String getToolTipLangKey(){
        return null;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.translatable(getToolTipLangKey()).withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.translatable("alchemind.hold_shift").withStyle(ChatFormatting.YELLOW));
        }
    }
}
