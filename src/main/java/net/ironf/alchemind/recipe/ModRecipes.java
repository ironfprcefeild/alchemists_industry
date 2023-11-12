package net.ironf.alchemind.recipe;

import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser.ArcanaInfuserRecipe;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator.ArcanaRadiatorRecipe;
import net.ironf.alchemind.blocks.arcanaHolders.essenceMixer.EssenceMixerRecipe;
import net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor.MineralExtractorRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Alchemind.MODID);

    public static final RegistryObject<RecipeSerializer<MineralExtractorRecipe>> MINERAL_EXTRACTOR_SERIALIZER =
            SERIALIZERS.register("mineral_extracting", () -> MineralExtractorRecipe.Serializer.INSTANCE);


    public static final RegistryObject<RecipeSerializer<EssenceMixerRecipe>> ESSENCE_MIXER_SERIALIZER =
            SERIALIZERS.register("essence_mixing", () -> EssenceMixerRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ArcanaInfuserRecipe>> ARCANA_INFUSER_SERIALIZER =
            SERIALIZERS.register("arcana_infusing", () -> ArcanaInfuserRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ArcanaRadiatorRecipe>> ARCANA_RADIATOR_SERIALIZER =
            SERIALIZERS.register("arcana_radiating", () -> ArcanaRadiatorRecipe.Serializer.INSTANCE);
    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

    //TODO figure out if I need to switch all my translateable stuff over to TranslateAbleWithFallBack
}