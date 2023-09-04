package net.ironf.alchemind.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser.ArcanaInfuserRecipe;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser.ArcanaInfuserRecipeCategory;
import net.ironf.alchemind.blocks.arcanaHolders.essenceMixer.EssenceMixerRecipe;
import net.ironf.alchemind.blocks.arcanaHolders.essenceMixer.EssenceMixerRecipeCategory;
import net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor.MineralExtractorRecipe;
import net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor.MineralExtractorRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIAlchemindPlugin implements IModPlugin {
    public static RecipeType<ArcanaInfuserRecipe> ARCANA_INFUSING_TYPE =
            new RecipeType<>(ArcanaInfuserRecipeCategory.UID, ArcanaInfuserRecipe.class);

    public static RecipeType<MineralExtractorRecipe> MINERAL_EXTRACTING_TYPE =
            new RecipeType<>(MineralExtractorRecipeCategory.UID, MineralExtractorRecipe.class);

    public static RecipeType<EssenceMixerRecipe> ESSENCE_MIXING_TYPE =
            new RecipeType<>(EssenceMixerRecipeCategory.UID, EssenceMixerRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Alchemind.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ArcanaInfuserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new MineralExtractorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new EssenceMixerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<ArcanaInfuserRecipe> recipesArcanaInfusing = rm.getAllRecipesFor(ArcanaInfuserRecipe.Type.INSTANCE);
        registration.addRecipes(ARCANA_INFUSING_TYPE, recipesArcanaInfusing);

        List<MineralExtractorRecipe> recipesMineralExtracting = rm.getAllRecipesFor(MineralExtractorRecipe.Type.INSTANCE);
        registration.addRecipes(MINERAL_EXTRACTING_TYPE, recipesMineralExtracting);

        List<EssenceMixerRecipe> recipesEssenceMixing = rm.getAllRecipesFor(EssenceMixerRecipe.Type.INSTANCE);
        registration.addRecipes(ESSENCE_MIXING_TYPE, recipesEssenceMixing);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        IModPlugin.super.registerRecipeCatalysts(registration);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ARCANA_INFUSER.get().asItem()),ARCANA_INFUSING_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ESSENCE_MIXER.get().asItem()),ESSENCE_MIXING_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MINERAL_EXTRACTOR.get().asItem()),MINERAL_EXTRACTING_TYPE);
    }
}