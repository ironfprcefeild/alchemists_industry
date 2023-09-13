package net.ironf.alchemind.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ALCHEMIND_TAB = new CreativeModeTab("alchemindtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BLANK_SIGIL.get());
        }
    };



}
