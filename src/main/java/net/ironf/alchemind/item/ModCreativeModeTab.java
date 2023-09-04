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

    public static final CreativeModeTab BAD_TAB = new CreativeModeTab("bad_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AMETHYST_POWDER.get());
        }
    };

}
