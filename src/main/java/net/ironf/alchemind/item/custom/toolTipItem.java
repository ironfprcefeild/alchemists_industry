package net.ironf.alchemind.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class toolTipItem extends Item {
    String ToolTipLangKey;
    public toolTipItem(Properties properties, String ToolTipLangKey) {
        super(properties);
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
