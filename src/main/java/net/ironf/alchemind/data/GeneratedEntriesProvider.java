package net.ironf.alchemind.data;

import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.world.feature.ModBiomeModifiers;
import net.ironf.alchemind.world.feature.ModConfiguredFeatures;
import net.ironf.alchemind.world.feature.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GeneratedEntriesProvider extends DatapackBuiltinEntriesProvider {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, (RegistrySetBuilder.RegistryBootstrap) ModBiomeModifiers::bootstrap);
    public GeneratedEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER,Set.of(Alchemind.MODID));
    }


    @Override
    public String getName() {
        return "Create: Alchemist Industry's Generated Registry Entries";
    }
}
