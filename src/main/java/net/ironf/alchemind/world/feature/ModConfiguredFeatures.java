package net.ironf.alchemind.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Alchemind.MODID);

    //GALENA
    public static final Supplier<List<OreConfiguration.TargetBlockState>> GALENA_SUPPLIER = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GALENA.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.GALENA.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GALENA_VEIN_ORE = CONFIGURED_FEATURES.register("galena_vein_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GALENA_SUPPLIER.get(),40))); //Vein Size is 40


    public static final RegistryObject<ConfiguredFeature<?, ?>> GALENA_VEIN_SCATTERED = CONFIGURED_FEATURES.register("galena_vein_scattered",
            () -> new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(GALENA_SUPPLIER.get(),40))); //Vein Size is 40


    //CORVIUM

    public static final Supplier<List<OreConfiguration.TargetBlockState>> CORVIUM_SUPPLIER = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.CORVIUM.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CORVIUM_VEIN_ORE = CONFIGURED_FEATURES.register("corvium_vein_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CORVIUM_SUPPLIER.get(),60))); //Vein Size is 60

    //GALAXITE


    public static final Supplier<List<OreConfiguration.TargetBlockState>> GALAXITE_SUPPLIER = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.GALAXITE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GALAXITE_VEIN_ORE = CONFIGURED_FEATURES.register("galaxite_vein_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GALAXITE_SUPPLIER.get(), 9)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}