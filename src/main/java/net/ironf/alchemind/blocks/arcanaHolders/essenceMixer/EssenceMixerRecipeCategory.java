package net.ironf.alchemind.blocks.arcanaHolders.essenceMixer;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser.ArcanaInfuserRecipe;
import net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor.MineralExtractorRecipe;
import net.ironf.alchemind.integration.jei.JEIAlchemindPlugin;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class EssenceMixerRecipeCategory implements IRecipeCategory<EssenceMixerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alchemind.MODID, "essence_mixing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Alchemind.MODID, "textures/gui/essence_mixer_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public EssenceMixerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ESSENCE_MIXER.get()));
    }

    @Override
    public RecipeType<EssenceMixerRecipe> getRecipeType() {
        return JEIAlchemindPlugin.ESSENCE_MIXING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Essence Mixing");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, EssenceMixerRecipe recipe, IFocusGroup focuses) {

        builder.addSlot(RecipeIngredientRole.INPUT, 86, 30).addFluidStack(recipe.getIngredientsFR().get(0).getMatchingFluidStacks().get(0).getFluid(),recipe.getIngredientsFR().get(0).getMatchingFluidStacks().get(0).getAmount());
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 45).addFluidStack(recipe.getIngredientsFR().get(1).getMatchingFluidStacks().get(0).getFluid(),recipe.getIngredientsFR().get(1).getMatchingFluidStacks().get(0).getAmount());
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 60).addFluidStack(recipe.getIngredientsFR().get(2).getMatchingFluidStacks().get(0).getFluid(),recipe.getIngredientsFR().get(2).getMatchingFluidStacks().get(0).getAmount());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 15).addFluidStack(recipe.getResultFluid().getFluid(),recipe.getResultFluid().getAmount());
    }

    @Override
    public void draw(EssenceMixerRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
        Minecraft mc = Minecraft.getInstance();
        mc.font.draw(stack, recipe.getArcanaNeeded() + " Arcana Required", 56, 5, 255);
    }

}
