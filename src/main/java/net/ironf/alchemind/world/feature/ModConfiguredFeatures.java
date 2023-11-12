package net.ironf.alchemind.world.feature;

import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static net.minecraft.data.worldgen.features.FeatureUtils.register;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>>
            GALENA_VEIN_ORE = key("galena_vein_ore"),
            GALENA_VEIN_SCATTERED = key("galena_vein_scattered"),
            CORVIUM_VEIN_ORE = key("corvium_vein_ore"),
            GALAXITE_VEIN_ORE = key("galaxite_vein_ore"),
            GALAXITE_VEIN_SCATTERED = key("galaxite_vein_scattered");


    //TODO fix this crash
    private static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Alchemind.createRL(name));
    }



    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> ctx) {
        RuleTest stoneOreReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        ///Galena
        List<OreConfiguration.TargetBlockState> galenaTargetStates = List.of(
                OreConfiguration.target(stoneOreReplaceables, ModBlocks.GALENA.get()
                        .defaultBlockState()),
                OreConfiguration.target(deepslateOreReplaceables,ModBlocks.GALENA.get()
                        .defaultBlockState())
        );

        register(ctx, GALENA_VEIN_ORE, Feature.ORE, new OreConfiguration(galenaTargetStates, 40));
        register(ctx, GALENA_VEIN_SCATTERED, Feature.SCATTERED_ORE, new OreConfiguration(galenaTargetStates, 40));

        ///Corvium
        List<OreConfiguration.TargetBlockState> corviumTargetStates = List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.CORVIUM.get()
                        .defaultBlockState())
        );

        register(ctx, CORVIUM_VEIN_ORE, Feature.ORE, new OreConfiguration(corviumTargetStates, 40));

        ///Galaxite
        List<OreConfiguration.TargetBlockState> galaxiteTargetStates = List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.GALAXITE.get()
                        .defaultBlockState())
        );

        register(ctx, GALAXITE_VEIN_ORE, Feature.ORE, new OreConfiguration(galaxiteTargetStates, 25));
        register(ctx, GALAXITE_VEIN_SCATTERED, Feature.SCATTERED_ORE, new OreConfiguration(galaxiteTargetStates, 25));

    }

}