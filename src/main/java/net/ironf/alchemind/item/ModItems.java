package net.ironf.alchemind.item;


import com.tterrag.registrate.util.entry.ItemEntry;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.fluid.ModFluids;
import net.ironf.alchemind.item.custom.sigil;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Items;

import java.util.List;

import static net.ironf.alchemind.Alchemind.LOGGER;
import static net.ironf.alchemind.Alchemind.REGISTRATE;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Alchemind.MODID);

    static {
        REGISTRATE.setCreativeTab(ModCreativeModeTabs.BASE_CREATIVE_TAB);
    }

    ///Items for real

    //Essence Ingredient Items
    public static final ItemEntry<Item>
            FLUFFY_AERO = REGISTRATE.item("fluffy_aero",Item::new).register(),
            DENSE_AERO = REGISTRATE.item("dense_aero",Item::new).register(),
            GUNPOWDER_PIECE = REGISTRATE.item("gunpowder_piece",Item::new).register(),
            TRAPPED_EMBER = REGISTRATE.item("trapped_ember",Item::new).register(),
            LOOSE_SLIME_BALL = REGISTRATE.item("loose_slime_ball",Item::new).register();

    //Emerald Crafting

    public static final ItemEntry<Item>
            FLICKER_STONE = REGISTRATE.item("flicker_stone",Item::new).register(),
            AMETHYST_POWDER = REGISTRATE.item("amethyst_powder",Item::new).register();


    //-Ites

    public static final ItemEntry<Item>
            PYRITE = REGISTRATE.item("pyrite",Item::new).register(),
            GLAMERITE = REGISTRATE.item("glamerite",Item::new).register(),
            REACTIVITE = REGISTRATE.item("reactivite",Item::new).register(),
            PYRITE_POWDER = REGISTRATE.item("pyrite_powder",Item::new).register(),
            GLAMERITE_POWDER = REGISTRATE.item("glamerite_powder",Item::new).register(),
            REACTIVITE_POWDER = REGISTRATE.item("reactivite_powder",Item::new).register(),
            GLAMERITE_ALLOY = REGISTRATE.item("glamerite_alloy",Item::new).register(),
            REACTIVITE_ALLOY = REGISTRATE.item("reactivite_alloy",Item::new).register();


    //Miscellaneous Materials
    public static final ItemEntry<Item>
            IMPURE_GHAST_TEAR = REGISTRATE.item("impure_ghast_tear",Item::new).register(),
            WARPED_DIAMOND_DUST = REGISTRATE.item("warped_diamond_dust",Item::new).register(),
            CINDER_SCRAP = REGISTRATE.item("cinder_scrap",Item::new).register();

    //Galaxite

    public static final ItemEntry<Item>
            CRUSHED_GALAXITE = REGISTRATE.item("crushed_galaxite",Item::new).register(),
            GALAXITE_BEAD = REGISTRATE.item("galaxite_bead",Item::new).register(),
            HARD_GALAXIUM = REGISTRATE.item("hard_galaxium",Item::new).register(),
            GALAXIUM_SHARD = REGISTRATE.item("galaxium_shard",Item::new).register();


    //Lead

    public static final ItemEntry<Item>
            LEAD_INGOT = REGISTRATE.item("lead_ingot",Item::new).register(),
            LEAD_NUGGET = REGISTRATE.item("lead_nugget",Item::new).register(),
            LEAD_SHEET = REGISTRATE.item("lead_sheet",Item::new).register();

    //Pewter

    public static final ItemEntry<Item>
            PEWTER_INGOT = REGISTRATE.item("pewter_ingot",Item::new).register(),
            PEWTER_NUGGET = REGISTRATE.item("pewter_nugget",Item::new).register();

    //Sigils

    public static final ItemEntry<sigil>
            BLANK_SIGIL = REGISTRATE.item("blank_sigil",sigil::new).register(),
            IGNUS_SIGIL = REGISTRATE.item("ignus_sigil",sigil::new).register(),
            AQUA_SIGIL = REGISTRATE.item("aqua_sigil",sigil::new).register(),
            AERO_SIGIL = REGISTRATE.item("aero_sigil",sigil::new).register(),
            TERRA_SIGIL = REGISTRATE.item("terra_sigil",sigil::new).register();


    //Stones
    public static final ItemEntry<Item>
            CHARGED_STONE = REGISTRATE.item("charged_stone",Item::new).register(),
            SUPER_CHARGED_STONE = REGISTRATE.item("super_charged_stone",Item::new).register();

    //Arcana Materials
    public static final ItemEntry<Item>
            ARCANE_MECHANISM = REGISTRATE.item("arcane_mechanism",Item::new).register(),
            ROTOR_COMPONENT = REGISTRATE.item("rotor_component",Item::new).register(),
            ACCELERATING_CRYSTAL = REGISTRATE.item("accelerating_crystal",Item::new).register();


    //Combine Essence Powders

    public static final ItemEntry<Item>
            SHINEDUST = REGISTRATE.item("shinedust",Item::new).register(),
            POWERPOWDER = REGISTRATE.item("powerpowder",Item::new).register(),
            ZOOMDUST = REGISTRATE.item("zoomdust",Item::new).register();



    //Arcanum Ingot

    public static final ItemEntry<Item> ARCANUM_INGOT = REGISTRATE.item("arcanum_ingot",Item::new).properties(p -> p.rarity(Rarity.EPIC)).register();

    //Philosophers Stone Stuff

    public static final ItemEntry<Item>
            PHILOSOPHERS_DUST = REGISTRATE.item("philosophers_dust",Item::new).properties(p -> p.rarity(Rarity.RARE)).register(),
            PHILOSOPHERS_GUNK = REGISTRATE.item("philosophers_gunk",Item::new).properties(p -> p.rarity(Rarity.RARE)).register(),
            PHILOSOPHERS_STONE = REGISTRATE.item("philosophers_stone",Item::new).properties(p -> p.rarity(Rarity.EPIC)).register(),
            PHILOSOPHERS_FRAGMENT = REGISTRATE.item("philosophers_fragment",Item::new).properties(p -> p.rarity(Rarity.RARE)).register();


    //Ore Chunks
    public static final ItemEntry<Item>
            CRIMSITE_CHUNK = REGISTRATE.item("crimsite_chunk",Item::new).register(),
            ASURINE_CHUNK = REGISTRATE.item("asurine_chunk",Item::new).register(),
            VERIDIUM_CHUNK = REGISTRATE.item("veridium_chunk",Item::new).register(),
            OCHRUM_CHUNK = REGISTRATE.item("ochrum_chunk",Item::new).register(),
            CORVIUM_CHUNK = REGISTRATE.item("corvium_chunk",Item::new).properties(Item.Properties::fireResistant).register();


    public static List<RegistryObject<BucketItem>> allBuckets = new ReferenceArrayList<>(14);

    ///Buckets
    public static final RegistryObject<BucketItem> IGNUS_BUCKET = registerBucket("ignus",ModFluids.SOURCE_IGNUS);
    public static final RegistryObject<BucketItem> TERRA_BUCKET = registerBucket("terra",ModFluids.SOURCE_TERRA);
    public static final RegistryObject<BucketItem> AQUA_BUCKET = registerBucket("aqua",ModFluids.SOURCE_AQUA);
    public static final RegistryObject<BucketItem> AERO_BUCKET = registerBucket("aero",ModFluids.SOURCE_AERO);
    public static final RegistryObject<BucketItem> REAGENT_BUCKET = registerBucket("reagent",ModFluids.SOURCE_REAGENT);
    public static final RegistryObject<BucketItem> STELLAR_FUEL_BUCKET = registerBucket("stellar_fuel_bucket",ModFluids.SOURCE_STELLAR_FUEL);
    public static final RegistryObject<BucketItem> GLIMA_BUCKET = registerBucket("glima",ModFluids.SOURCE_GLIMA);
    public static final RegistryObject<BucketItem> SHADE_BUCKET = registerBucket("shade",ModFluids.SOURCE_SHADE);
    public static final RegistryObject<BucketItem> ORDER_BUCKET = registerBucket("order",ModFluids.SOURCE_MORTITH);
    public static final RegistryObject<BucketItem> POTERE_BUCKET = registerBucket("potere",ModFluids.SOURCE_POTERE);
    public static final RegistryObject<BucketItem> GHEIGH_BUCKET = registerBucket("gheigh",ModFluids.SOURCE_GHEIGH);
    public static final RegistryObject<BucketItem> VIVORN_BUCKET = registerBucket("vivorn",ModFluids.SOURCE_VIVORN);
    public static final RegistryObject<BucketItem> MORTITH_BUCKET = registerBucket("mortith",ModFluids.SOURCE_MORTITH);
    public static final RegistryObject<BucketItem> MOVERE_BUCKET = registerBucket("movere",ModFluids.SOURCE_MOVERE);

    //Bucket Helper Functions
    public static RegistryObject<BucketItem> registerBucket(String fluidName, RegistryObject<FlowingFluid> fluid){
        RegistryObject<BucketItem> toReturn = ITEMS.register(fluidName + "_bucket", () -> new BucketItem(fluid,new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        LOGGER.info("Trying to add bucket");
        allBuckets.add(toReturn);
        return toReturn;
    }


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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        register();
    }

    public static void register(){

    }
}

