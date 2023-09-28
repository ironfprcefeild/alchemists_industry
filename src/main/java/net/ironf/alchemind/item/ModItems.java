package net.ironf.alchemind.item;

import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.fluid.ModFluids;
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

    public static final RegistryObject<Item> CHARGED_STONE = ITEMS.register("charged_stone", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> SUPER_CHARGED_STONE = ITEMS.register("super_charged_stone", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> GLAMERITE_POWDER = ITEMS.register("glamerite_powder", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> REACTIVITE_POWDER = ITEMS.register("reactivite_powder", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> PYRITE_POWDER = ITEMS.register("pyrite_powder", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> REACITVITE_ALLOY = ITEMS.register("reactivite_alloy", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> GLAMERITE_ALLOY = ITEMS.register("glamerite_alloy", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> ARCANE_MECHANISM = ITEMS.register("arcane_mechanism", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> ROTOR_COMPONENT = ITEMS.register("rotor_component", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ACCELERTING_CRYSTAL = ITEMS.register("accelerating_crystal", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> WARPED_DIAMOND_DUST = ITEMS.register("warped_diamond_dust", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> SHINEDUST = ITEMS.register("shinedust", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> POWERPOWDER = ITEMS.register("powerpowder", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> ZOOMDUST = ITEMS.register("zoomdust", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> CRUSHED_GALAXITE = ITEMS.register("crushed_galaxite", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> GALAXITE_BEAD = ITEMS.register("galaxite_bead", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> HARD_GALAXIUM = ITEMS.register("hard_galaxium", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> GALAXIUM_SHARD = ITEMS.register("galaxium_shard", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    ///Lead Stuff
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> LEAD_SHEET = ITEMS.register("lead_sheet", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    ///Pewter Stuff
    public static final RegistryObject<Item> PEWTER_INGOT = ITEMS.register("pewter_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    public static final RegistryObject<Item> PEWTER_NUGGET = ITEMS.register("pewter_nugget", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    ///Arcanum Stuff
    public static final RegistryObject<Item> ARCANUM_INGOT = ITEMS.register("arcanum_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    ///Sigils
    public static final RegistryObject<Item> BLANK_SIGIL = ITEMS.register("blank_sigil", () -> new tool_tip_item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB),"item.alchemind.blank_sigil.tool_tip"));
    public static final RegistryObject<Item> AERO_SIGIL = ITEMS.register("aero_sigil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> AQUA_SIGIL = ITEMS.register("aqua_sigil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> TERRA_SIGIL = ITEMS.register("terra_sigil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> IGNUS_SIGIL = ITEMS.register("ignus_sigil", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    //Philosophers Stuff

    public static final RegistryObject<Item> PHILOSOPHERS_DUST = ITEMS.register("philosophers_dust", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> PHILOSOPHERS_GUNK = ITEMS.register("philosophers_gunk", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> PHILOSOPHERS_STONE = ITEMS.register("philosophers_stone", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> PHILOSOPHERS_FRAGMENT = ITEMS.register("philosophers_fragment", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));

    //ORe Chunks
    public static final RegistryObject<Item> CRIMSITE_CHUNK = ITEMS.register("crimsite_chunk", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> AUSRINE_CHUNK = ITEMS.register("asurine_chunk", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> VERDIUM_CHUNK = ITEMS.register("verdium_chunk", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> OCHRUM_CHUNK = ITEMS.register("orchrum_chunk", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));
    public static final RegistryObject<Item> CORVIUM_CHUNK = ITEMS.register("corvium_chunk", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB)));


    //Buckets
    public static final RegistryObject<Item> IGNUS_BUCKET = ITEMS.register("ignus_bucket",
            () -> new BucketItem(ModFluids.SOURCE_IGNUS, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> TERRA_BUCKET = ITEMS.register("terra_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TERRA, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> AQUA_BUCKET = ITEMS.register("aqua_bucket",
            () -> new BucketItem(ModFluids.SOURCE_AQUA, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> AERO_BUCKET = ITEMS.register("aero_bucket",
            () -> new BucketItem(ModFluids.SOURCE_AERO, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> REAGENT_BUCKET = ITEMS.register("reagent_bucket",
            () -> new BucketItem(ModFluids.SOURCE_REAGENT, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> STELLAR_FUEL_BUCKET = ITEMS.register("stellar_fuel_bucket",
            () -> new BucketItem(ModFluids.SOURCE_STELLAR_FUEL, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> GLIMA_BUCKET = ITEMS.register("glima_bucket",
            () -> new BucketItem(ModFluids.SOURCE_GLIMA, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> SHADE_BUCKET = ITEMS.register("shade_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SHADE, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> ORDER_BUCKET = ITEMS.register("order_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ORDER, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> POTERE_BUCKET = ITEMS.register("potere_bucket",
            () -> new BucketItem(ModFluids.SOURCE_POTERE, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> GHEIGH_BUCKET = ITEMS.register("gheigh_bucket",
            () -> new BucketItem(ModFluids.SOURCE_GHEIGH, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> VIVORN_BUCKET = ITEMS.register("vivorn_bucket",
            () -> new BucketItem(ModFluids.SOURCE_VIVORN, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> MORTITH_BUCKET = ITEMS.register("mortith_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MORTITH, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> MOVERE_BUCKET = ITEMS.register("movere_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOVERE, new Item.Properties().tab(ModCreativeModeTab.ALCHEMIND_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    //Sequenced Assembly Incomplete Items

    public static final RegistryObject<Item> INCOMPLETE_TERRA = ITEMS.register("incomplete_terra", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_ENCHANTED_GOLDEN_APPLE = ITEMS.register("incomplete_enchanted_golden_apple", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_TOTEM_OF_UNDYING = ITEMS.register("incomplete_totem_of_undying", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_NETHERRACK = ITEMS.register("incomplete_netherrack", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_CINDER_SCRAP = ITEMS.register("incomplete_cinder_scrap", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_ARCANE_MECHANISM = ITEMS.register("incomplete_arcane_mechanism", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_GUNK = ITEMS.register("incomplete_gunk", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_STONE = ITEMS.register("incomplete_stone", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_ACCELERATING_CRYSTAL = ITEMS.register("incomplete_accelerating_crystal", () -> new Item(new Item.Properties()));

    //Helper Functions

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

