package net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.integration.jei.JEIAlchemindPlugin;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ArcanaInfuserRecipeCategory implements IRecipeCategory<ArcanaInfuserRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alchemind.MODID, "arcana_infusing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Alchemind.MODID, "textures/gui/arcana_infuser_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public ArcanaInfuserRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ARCANA_INFUSER.get()));
    }

    @Override
    public RecipeType<ArcanaInfuserRecipe> getRecipeType() {
        return JEIAlchemindPlugin.ARCANA_INFUSING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Arcana Infuser");
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
    public void setRecipe(IRecipeLayoutBuilder builder, ArcanaInfuserRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem());
    }

}
