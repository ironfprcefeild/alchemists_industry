package net.ironf.alchemind.item;

import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.fluid.ModFluids;
import net.ironf.alchemind.item.custom.arcana_connector_tool_item;
import net.ironf.alchemind.item.custom.arcana_detector_tool_item;
import net.ironf.alchemind.item.custom.tool_tip_item;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Items;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Alchemind.MODID);
    //Items for real
    public static final RegistryObject<Item> FLUFFY_AERO = ITEMS.register("fluffy_aero", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> DENSE_AERO = ITEMS.register("dense_aero", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> GUNPOWDER_PIECE = ITEMS.register("gunpowder_piece", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    //TODO give texture to Incomplete Totem
    public static final RegistryObject<Item> TRAPPED_EMBER = ITEMS.register("trapped_ember", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> LOOSE_SLIME_BALL = ITEMS.register("loose_slime_ball", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> FLICKER_STONE = ITEMS.register("flicker_stone", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> AMETHYST_POWDER = ITEMS.register("amethyst_powder", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> PYRITE = ITEMS.register("pyrite", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> GLAMERITE = ITEMS.register("glamerite", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> REACTIVITE = ITEMS.register("reactivite", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> CINDER_SCRAP = ITEMS.register("cinder_scrap", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> IMPURE_GHAST_TEAR = ITEMS.register("impure_ghast_tear", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    ///Lead Stuff
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> LEAD_SHEET = ITEMS.register("lead_sheet", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    ///Pewter Stuff
    public static final RegistryObject<Item> PEWTER_INGOT = ITEMS.register("pewter_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> PEWTER_NUGGET = ITEMS.register("pewter_nugget", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    ///Sigils
    public static final RegistryObject<Item> BLANK_SIGIL = ITEMS.register("blank_sigil", () -> new tool_tip_item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB),"Pour Essence and Drain it out to get 100mb more than you put in! Convert Pewter to Essence"));
    public static final RegistryObject<Item> AERO_SIGIL = ITEMS.register("aero_sigil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> AQUA_SIGIL = ITEMS.register("aqua_sigil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> TERRA_SIGIL = ITEMS.register("terra_sigil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> IGNUS_SIGIL = ITEMS.register("ignus_sigil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    ///Arcana Stuff
    public static final RegistryObject<Item> ARCANA_LINKER = ITEMS.register("arcana_linker", () -> new arcana_connector_tool_item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ARCANA_DETECTOR = ITEMS.register("arcana_detector", () -> new arcana_detector_tool_item(new Item.Properties().stacksTo(1)));


    ///Staffs


    //Buckets
    public static final RegistryObject<Item> IGNUS_BUCKET = ITEMS.register("ignus_bucket",
            () -> new BucketItem(ModFluids.SOURCE_IGNUS, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> TERRA_BUCKET = ITEMS.register("terra_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TERRA, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> AQUA_BUCKET = ITEMS.register("aqua_bucket",
            () -> new BucketItem(ModFluids.SOURCE_AQUA, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> AERO_BUCKET = ITEMS.register("aero_bucket",
            () -> new BucketItem(ModFluids.SOURCE_AERO, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    //Sequenced Assembly Incomplete Items

    public static final RegistryObject<Item> INCOMPLETE_TERRA = ITEMS.register("incomplete_terra", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_ENCHANTED_GOLDEN_APPLE = ITEMS.register("incomplete_enchanted_golden_apple", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_TOTEM_OF_UNDYING = ITEMS.register("incomplete_totem_of_undying", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_NETHERRACK = ITEMS.register("incomplete_netherrack", () -> new Item(new Item.Properties()));


    //Helper Functions

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

