package net.ironf.alchemind.blocks;


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
import net.ironf.alchemind.blocks.custom.zoomdustBlock;
import net.ironf.alchemind.fluid.ModFluids;
import net.ironf.alchemind.item.ModCreativeModeTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.ironf.alchemind.Alchemind.REGISTRATE;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Alchemind.MODID);

    static {
        Alchemind.REGISTRATE.setCreativeTab(ModCreativeModeTabs.BASE_CREATIVE_TAB);
    }
    //Blocks for real
    ///Solid Blocks

    public static final BlockEntry<Block> SOLID_IGNUS = REGISTRATE.block("solid_ignus", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.lightLevel(light -> 5).strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LOOSE_IGNUS = REGISTRATE.block("loose_ignus", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.lightLevel(light -> 10).strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SOLID_TERRA = REGISTRATE.block("solid_terra", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();
    public static final BlockEntry<FallingBlock> LOOSE_TERRA = REGISTRATE.block("loose_terra", FallingBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SCULKING_TERRA = REGISTRATE.block("sculking_terra", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SOLID_AQUA = REGISTRATE.block("solid_aqua", Block::new)
            .initialProperties(() -> Blocks.CLAY)
            .properties(p -> p.strength(1f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LOOSE_AQUA = REGISTRATE.block("loose_aqua", Block::new)
            .initialProperties(() -> Blocks.CLAY)
            .properties(p -> p.strength(1f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SOLID_AERO = REGISTRATE.block("solid_aero", Block::new)
            .initialProperties(() -> Blocks.CLAY)
            .properties(p -> p.strength(1f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LOOSE_AERO = REGISTRATE.block("loose_aero", Block::new)
            .initialProperties(() -> Blocks.CLAY)
            .properties(p -> p.strength(1f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();
    public static final BlockEntry<Block> GALENA = REGISTRATE.block("galena", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CORVIUM = REGISTRATE.block("corvium", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();
    public static final BlockEntry<Block> GALAXITE = REGISTRATE.block("galaxite", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(3f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LEAD_BLOCK = REGISTRATE.block("lead_block", Block::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(3f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> PEWTER_BLOCK = REGISTRATE.block("pewter_block", Block::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CRYSTAL_GLASS = REGISTRATE.block("crystal_glass", Block::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.strength(1f).requiresCorrectToolForDrops())
            .register();
    //TODO figure out how to get crystal glass tooltip

    public static final BlockEntry<Block> CINDERITE = REGISTRATE.block("cinderite", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CINDERSTONE = REGISTRATE.block("cinderstone", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> HEALTHY_NETHERRACK = REGISTRATE.block("healthy_netherrack", Block::new)
            .initialProperties(() -> Blocks.DIRT)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> UNSTABLE_DEBRIS = REGISTRATE.block("unstable_debris", Block::new)
            .initialProperties(() -> Blocks.ANCIENT_DEBRIS)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> INFUSED_ENDSTONE = REGISTRATE.block("infused_endstone", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();
    public static final BlockEntry<Block> SHINEDUST_LANTERN = REGISTRATE.block("shinedust_lantern", Block::new)
            .initialProperties(() -> Blocks.GLOWSTONE)
            .properties(p -> p.strength(1f).lightLevel(light -> 80))
            .simpleItem()
            .register();
    public static final BlockEntry<zoomdustBlock> ZOOMDUST_BLOCK_BLOCK = REGISTRATE.block("zoomdust_block", zoomdustBlock::new)
            .initialProperties(() -> Blocks.DIRT)
            .properties(p -> p.strength(2f))
            .simpleItem()
            .register();

    //TODO figure out how to give tooltip to zoomdut block
    public static final BlockEntry<Block> PURE_BASALT = REGISTRATE.block("pure_basalt", Block::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p.strength(3f))
            .simpleItem()
            .register();


    //ARCANA JUNK

    public static final BlockEntry<creativeArcanaGenerator> ARCANA_GENERATOR = REGISTRATE.block("creative_arcana_generator", creativeArcanaGenerator::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();

    public static final BlockEntry<ArcanaRadiator> ARCANA_RADIATOR = REGISTRATE.block("arcana_radiator", ArcanaRadiator::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<EssenceMixer> ESSENCE_MIXER = REGISTRATE.block("essence_mixer", EssenceMixer::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();

    public static final BlockEntry<mineralExtractor> MINERAL_EXTRACTOR = REGISTRATE.block("mineral_extractor", mineralExtractor::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();


    public static final BlockEntry<arcanaRotorBase> ARCANA_ROTOR_BASE = REGISTRATE.block("arcana_rotor_base", arcanaRotorBase::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .register();

    public static final BlockEntry<arcanaRotor> ARCANA_ROTOR = REGISTRATE.block("arcana_rotor", arcanaRotor::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .register();

    public static final BlockEntry<arcanaInfuser> ARCANA_INFUSER = REGISTRATE.block("arcana_infuser", arcanaInfuser::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();

    public static final BlockEntry<acceleratorBlock> ACCELERATOR = REGISTRATE.block("arcana_accelerator", acceleratorBlock::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();

    public static final BlockEntry<potionCatalyzer> POTION_CATALYZER = REGISTRATE.block("potion_catalyzer", potionCatalyzer::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops().noOcclusion())
            .simpleItem()
            .register();

    public static final BlockEntry<Block> ARCANE_CASING = REGISTRATE.block("arcane_casing", Block::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.strength(2f).requiresCorrectToolForDrops())
            .simpleItem()
            .register();


    ///Fluid Blocks
    public static final RegistryObject<LiquidBlock> IGNUS_FLUID_BLOCK = BLOCKS.register("ignus_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_IGNUS, BlockBehaviour.Properties.copy(Blocks.LAVA).lightLevel(value -> 12),new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10, 31)));

    public static final RegistryObject<LiquidBlock> TERRA_FLUID_BLOCK = BLOCKS.register("terra_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_TERRA, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 3)));

    public static final RegistryObject<LiquidBlock> AQUA_FLUID_BLOCK = BLOCKS.register("aqua_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_AQUA, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 11)));

    public static final RegistryObject<LiquidBlock> AERO_FLUID_BLOCK = BLOCKS.register("aero_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_AERO, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.LEVITATION,  20, 31)));
    public static final RegistryObject<LiquidBlock> REAGENT_FLUID_BLOCK = BLOCKS.register("reagent_fluid_block", () -> new LiquidBlock(ModFluids.SOURCE_REAGENT, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> STELLAR_FUEL_FLUID_BLOCK = BLOCKS.register("stellar_fuel_fluid_block", () -> new LiquidBlock(ModFluids.SOURCE_STELLAR_FUEL, BlockBehaviour.Properties.copy(Blocks.WATER).lightLevel(value -> 7)));

    public static final RegistryObject<LiquidBlock> GLIMA_FLUID_BLOCK = BLOCKS.register("glima_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_GLIMA, BlockBehaviour.Properties.copy(Blocks.WATER).lightLevel(value -> 60), new MobEffectInstance(MobEffects.GLOWING,  150, 31)));
    public static final RegistryObject<LiquidBlock> SHADE_FLUID_BLOCK = BLOCKS.register("shade_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_SHADE, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.DARKNESS,  150, 31)));
    public static final RegistryObject<LiquidBlock> ORDER_FLUID_BLOCK = BLOCKS.register("order_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_ORDER, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.LUCK,  150, 31)));
    public static final RegistryObject<LiquidBlock> POTERE_FLUID_BLOCK = BLOCKS.register("potere_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_POTERE, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.DAMAGE_BOOST,  150, 5)));
    public static final RegistryObject<LiquidBlock> GHEIGH_FLUID_BLOCK = BLOCKS.register("gheigh_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_GHEIGH, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.CONFUSION,  150, 5)));
    public static final RegistryObject<LiquidBlock> VIVORN_FLUID_BLOCK = BLOCKS.register("vivorn_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_VIVORN, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.REGENERATION,  80, 1)));

    public static final RegistryObject<LiquidBlock> MORTITH_FLUID_BLOCK = BLOCKS.register("mortith_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_MORTITH, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.HARM,  5, 1)));
    public static final RegistryObject<LiquidBlock> MOVERE_FLUID_BLOCK = BLOCKS.register("movere_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_MOVERE, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.MOVEMENT_SPEED,  80, 1)));


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        register();
    }

    public static void register() {

    }
}
