package net.ironf.alchemind.world.feature;

import net.ironf.alchemind.Alchemind;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier>
            GALENA_VEIN_ORE = key("galena_vein_ore"),
            GALENA_VEIN_SCATTERED = key("galena_vein_scattered"),
            CORVIUM_VEIN_ORE = key("corvium_vein_ore"),
            GALAXITE_VEIN_ORE = key("galaxite_vein_ore"),
            GALAXITE_VEIN_SCATTERED = key("galaxite_vein_scattered");


    //TODO fix this crash
    private static ResourceKey<BiomeModifier> key(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, Alchemind.createRL(name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> ctx) {
        //Get Holders and lookups
        HolderGetter<Biome> biomeLookup = ctx.lookup(Registries.BIOME);
        HolderSet<Biome> isOverworld = biomeLookup.getOrThrow(BiomeTags.IS_OVERWORLD);
        HolderSet<Biome> isNether = biomeLookup.getOrThrow(BiomeTags.IS_NETHER);
        HolderSet<Biome> isEnd = biomeLookup.getOrThrow(BiomeTags.IS_END);
        HolderGetter<PlacedFeature> featureLookup = ctx.lookup(Registries.PLACED_FEATURE);

        ctx.register(GALENA_VEIN_ORE, addOre(isOverworld, featureLookup.getOrThrow(ModPlacedFeatures.GALENA_VEIN_ORE)));
        ctx.register(GALENA_VEIN_SCATTERED, addOre(isOverworld, featureLookup.getOrThrow(ModPlacedFeatures.GALENA_VEIN_SCATTERED)));
        ctx.register(CORVIUM_VEIN_ORE, addOre(isNether, featureLookup.getOrThrow(ModPlacedFeatures.CORVIUM_VEIN_ORE)));
        ctx.register(GALAXITE_VEIN_ORE, addOre(isEnd, featureLookup.getOrThrow(ModPlacedFeatures.GALAXITE_VEIN_ORE)));
        ctx.register(GALAXITE_VEIN_SCATTERED, addOre(isEnd, featureLookup.getOrThrow(ModPlacedFeatures.GALAXITE_VEIN_SCATTERED)));



    }
    private static ForgeBiomeModifiers.AddFeaturesBiomeModifier addOre(HolderSet<Biome> biomes, Holder<PlacedFeature> feature) {
        return new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes, HolderSet.direct(feature), GenerationStep.Decoration.UNDERGROUND_ORES);
    }
}
