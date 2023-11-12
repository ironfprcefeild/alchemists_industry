package net.ironf.alchemind.world.feature;

import net.ironf.alchemind.Alchemind;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.data.worldgen.placement.PlacementUtils.register;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature>
            GALENA_VEIN_ORE = key("galena_vein_ore_placed"),
            GALENA_VEIN_SCATTERED = key("galena_vein_scattered_placed"),
            CORVIUM_VEIN_ORE = key("corvium_vein_placed"),
            GALAXITE_VEIN_ORE = key("galaxite_ore_placed"),
            GALAXITE_VEIN_SCATTERED = key("galaxite_scattered_ore_placed");


    private static ResourceKey<PlacedFeature> key(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Alchemind.createRL(name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> ctx) {
        HolderGetter<ConfiguredFeature<?, ?>> featureLookup = ctx.lookup(Registries.CONFIGURED_FEATURE);
        List<PlacementModifier> alchemicalStonePlacement = simpleTrianglePlacement(1,false,-80,80);

        ///Galena
        Holder<ConfiguredFeature<?, ?>> galenaVeinOre = featureLookup.getOrThrow(ModConfiguredFeatures.GALENA_VEIN_ORE);
        Holder<ConfiguredFeature<?, ?>> galenaScatteredVeinOre = featureLookup.getOrThrow(ModConfiguredFeatures.GALENA_VEIN_SCATTERED);
        register(ctx, GALENA_VEIN_ORE, galenaVeinOre, alchemicalStonePlacement);
        register(ctx, GALENA_VEIN_SCATTERED, galenaScatteredVeinOre, alchemicalStonePlacement);

        //Corvium
        Holder<ConfiguredFeature<?, ?>> corviumVeinOre = featureLookup.getOrThrow(ModConfiguredFeatures.CORVIUM_VEIN_ORE);
        register(ctx, CORVIUM_VEIN_ORE, corviumVeinOre, alchemicalStonePlacement);

        //Galaxite
        Holder<ConfiguredFeature<?, ?>> galaxiteVeinOre = featureLookup.getOrThrow(ModConfiguredFeatures.GALAXITE_VEIN_ORE);
        Holder<ConfiguredFeature<?, ?>> galaxiteScatteredVeinOre = featureLookup.getOrThrow(ModConfiguredFeatures.GALAXITE_VEIN_SCATTERED);
        register(ctx, GALAXITE_VEIN_ORE, galaxiteVeinOre, simpleTrianglePlacement(5,true,-80,80));
        register(ctx, GALAXITE_VEIN_SCATTERED, galaxiteScatteredVeinOre, simpleTrianglePlacement(12,true,-80,80));

    }


    //Vanilla Helper Functions

    public static List<PlacementModifier> simpleTrianglePlacement(int placementsByChunk, boolean isRare, int lower, int upper){
        return orePlacement(isRare ? RarityFilter.onAverageOnceEvery(placementsByChunk) : CountPlacement.of(placementsByChunk), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(lower), VerticalAnchor.aboveBottom(upper)));
    }

    public static List<PlacementModifier> commonOrePlacement(int placementsPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(placementsPerChunk), placementModifier);
    }
    public static List<PlacementModifier> rareOrePlacement(int placementsPerChunk, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(placementsPerChunk), placementModifier);
    }
    public static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier placementModifier) {
        return List.of(countPlacement, InSquarePlacement.spread(), placementModifier, BiomeFilter.biome());
    }

}