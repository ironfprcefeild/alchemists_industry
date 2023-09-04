package net.ironf.alchemind.world.feature;

import net.ironf.alchemind.Alchemind;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Alchemind.MODID);


    public static final RegistryObject<PlacedFeature> GALENA_VEIN_ORE_PLACED = PLACED_FEATURES.register("galena_vein_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GALENA_VEIN_ORE.getHolder().get(),
                    commonOrePlacement(1, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<PlacedFeature> GALENA_VEIN_SCATTERED_PLACED = PLACED_FEATURES.register("galena_vein_scattered_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GALENA_VEIN_SCATTERED.getHolder().get(),
                    commonOrePlacement(1, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> CORVIUM_VEIN_PLACED = PLACED_FEATURES.register("corvium_vein_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CORVIUM_VEIN_ORE.getHolder().get(),
                    commonOrePlacement(1, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));


    public static final RegistryObject<PlacedFeature> GALAXITE_ORE_PLACED = PLACED_FEATURES.register("galaxite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GALAXITE_VEIN_ORE.getHolder().get(), rareOrePlacement(5, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));



    public static final RegistryObject<PlacedFeature> GALAXITE_SCATTERED_ORE_PLACED = PLACED_FEATURES.register("galaxite_scattered_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GALAXITE_VEIN_ORE.getHolder().get(), rareOrePlacement(12, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));




    //Vanilla Helper Functions
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}