package net.ironf.alchemind.blocks;


import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorBlock;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser.arcanaInfuser;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator.ArcanaRadiator;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.arcanaRotor;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.base.arcanaRotorBase;
import net.ironf.alchemind.blocks.arcanaHolders.creativeArcanaGenerator.creativeArcanaGenerator;
import net.ironf.alchemind.blocks.arcanaHolders.essenceMixer.EssenceMixer;
import net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor.mineralExtractor;
import net.ironf.alchemind.blocks.arcanaHolders.potionCatalyzer.potionCatalyzer;
import net.ironf.alchemind.blocks.custom.effectLiquidBlock;
import net.ironf.alchemind.blocks.custom.tool_tip_block_item;
import net.ironf.alchemind.blocks.custom.zoomdustBlock;
import net.ironf.alchemind.fluid.ModFluids;
import net.ironf.alchemind.item.ModCreativeModeTab;
import net.ironf.alchemind.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.ironf.alchemind.Alchemind.REGISTRATE;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Alchemind.MODID);

    static {
        Alchemind.REGISTRATE.creativeModeTab(() -> ModCreativeModeTab.ALCHEMIND_TAB);
    }
    //Blocks for real
    ///Solid Blocks
    public static  final RegistryObject<Block> SOLID_IGNUS = registerBlock("solid_ignus", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().lightLevel(value -> 5)), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> LOOSE_IGNUS = registerBlock("loose_ignus", () ->
            new FallingBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().lightLevel(value -> 10)), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SOLID_TERRA = registerBlock("solid_terra", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> LOOSE_TERRA = registerBlock("loose_terra", () ->
            new FallingBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SCULKING_TERRA = registerBlock("sculking_terra", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SOLID_AQUA = registerBlock("solid_aqua", () ->
            new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);
    public static  final RegistryObject<Block> LOOSE_AQUA = registerBlock("loose_aqua", () ->
            new FallingBlock(BlockBehaviour.Properties.of(Material.CLAY).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SOLID_AERO = registerBlock("solid_aero", () ->
            new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);
    public static  final RegistryObject<Block> LOOSE_AERO = registerBlock("loose_aero", () ->
            new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> GALENA = registerBlock("galena", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> CORVIUM = registerBlock("corvium", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);
    public static  final RegistryObject<Block> GALAXITE = registerBlock("galaxite", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> CRYSTAL_GLASS = registerToolTipBlock("crystal_glass", () ->
            new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB,  "block.alchemind.crystal_glass.tool_tip");
    public static  final RegistryObject<Block> PEWTER_BLOCK = registerBlock("pewter_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);
    public static  final RegistryObject<Block> CINDERITE = registerBlock("cinderite", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);
    public static  final RegistryObject<Block> CINDERSTONE = registerBlock("cinderstone", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> HEALTHY_NETHERRACK = registerBlock("healthy_netherrack", () ->
            new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> UNSTABLE_DEBRIS = registerBlock("unstable_debris", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> INFUSED_ENDSTONE = registerBlock("infused_endstone", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SHINEDUST_LANTERN = registerBlock("shinedust_lantern", () ->
            new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(2f).lightLevel(value -> 80)), ModCreativeModeTab.ALCHEMIND_TAB);
    public static  final RegistryObject<Block> ZOOMDUST_BLOCK = registerToolTipBlock("zoomdust_block", () ->
            new zoomdustBlock(BlockBehaviour.Properties.of(Material.DIRT).strength(2f)), ModCreativeModeTab.ALCHEMIND_TAB,"block.alchemind.zoomdust_block.tooltip");
    public static  final RegistryObject<Block> PURE_BASALT = registerBlock("pure_basalt", () ->
            new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(2f)), ModCreativeModeTab.ALCHEMIND_TAB);


    //ARCANA JUNK

    public static final BlockEntry<creativeArcanaGenerator> ARCANA_GENERATOR = REGISTRATE.block("creative_arcana_generator", creativeArcanaGenerator::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<ArcanaRadiator> ARCANA_RADIATOR = REGISTRATE.block("arcana_radiator", ArcanaRadiator::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<EssenceMixer> ESSENCE_MIXER = REGISTRATE.block("essence_mixer", EssenceMixer::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();

    public static final BlockEntry<mineralExtractor> MINERAL_EXTRACTOR = REGISTRATE.block("mineral_extractor", mineralExtractor::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();


    public static final BlockEntry<arcanaRotorBase> ARCANA_ROTOR_BASE = REGISTRATE.block("arcana_rotor_base", arcanaRotorBase::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops())
            .register();

    public static final BlockEntry<arcanaRotor> ARCANA_ROTOR = REGISTRATE.block("arcana_rotor", arcanaRotor::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops())
            .register();

    public static final BlockEntry<arcanaInfuser> ARCANA_INFUSER = REGISTRATE.block("arcana_infuser", arcanaInfuser::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();

    public static final BlockEntry<acceleratorBlock> ACCELERATOR = REGISTRATE.block("arcana_accelerator", acceleratorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();

    public static final BlockEntry<potionCatalyzer> POTION_CATALYZER = REGISTRATE.block("potion_catalyzer", potionCatalyzer::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();
    public static  final RegistryObject<Block> ARCANE_CASING =  registerBlock("arcane_casing", () ->
            new CasingBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);



    ///Fluid Blocks
    public static final RegistryObject<LiquidBlock> IGNUS_FLUID_BLOCK = BLOCKS.register("ignus_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_IGNUS, BlockBehaviour.Properties.copy(Blocks.LAVA).lightLevel(value -> 12),new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10, 31)));

    public static final RegistryObject<LiquidBlock> TERRA_FLUID_BLOCK = BLOCKS.register("terra_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_TERRA, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 3)));

    public static final RegistryObject<LiquidBlock> AQUA_FLUID_BLOCK = BLOCKS.register("aqua_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_AQUA, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 11)));

    public static final RegistryObject<LiquidBlock> AERO_FLUID_BLOCK = BLOCKS.register("aero_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_AERO, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.LEVITATION,  20, 31)));

    public static final RegistryObject<LiquidBlock> REAGENT_FLUID_BLOCK = BLOCKS.register("reagent_fluid_block", () -> new LiquidBlock(ModFluids.SOURCE_REAGENT, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> GLIMA_FLUID_BLOCK = BLOCKS.register("glima_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_GLIMA, BlockBehaviour.Properties.copy(Blocks.WATER).lightLevel(value -> 60), new MobEffectInstance(MobEffects.GLOWING,  150, 31)));
    public static final RegistryObject<LiquidBlock> SHADE_FLUID_BLOCK = BLOCKS.register("shade_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_SHADE, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.DARKNESS,  150, 31)));
    public static final RegistryObject<LiquidBlock> ORDER_FLUID_BLOCK = BLOCKS.register("order_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_ORDER, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.LUCK,  150, 31)));
    public static final RegistryObject<LiquidBlock> POTERE_FLUID_BLOCK = BLOCKS.register("potere_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_POTERE, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.DAMAGE_BOOST,  150, 5)));
    public static final RegistryObject<LiquidBlock> GHEIGH_FLUID_BLOCK = BLOCKS.register("gheigh_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_GHEIGH, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.CONFUSION,  150, 5)));
    public static final RegistryObject<LiquidBlock> VIVORN_FLUID_BLOCK = BLOCKS.register("vivorn_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_VIVORN, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.REGENERATION,  80, 1)));

    public static final RegistryObject<LiquidBlock> MORTITH_FLUID_BLOCK = BLOCKS.register("mortith_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_MORTITH, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.HARM,  5, 1)));
    public static final RegistryObject<LiquidBlock> MOVERE_FLUID_BLOCK = BLOCKS.register("movere_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_MOVERE, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.MOVEMENT_SPEED,  80, 1)));


    //Helper Functions
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerToolTipBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltip){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockToolTipItem(name, toReturn, tab, tooltip);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<Item> registerBlockToolTipItem(String name, Supplier<T> block, CreativeModeTab tab, String tooltip){
        return ModItems.ITEMS.register(name, () -> new tool_tip_block_item(block.get(), new Item.Properties().tab(tab),tooltip));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        register();
    }

    public static void register() {

    }
}
