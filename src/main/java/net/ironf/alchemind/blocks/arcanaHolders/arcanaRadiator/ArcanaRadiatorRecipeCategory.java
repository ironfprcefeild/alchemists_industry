package net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.foundation.gui.AllGuiTextures;
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
import net.ironf.alchemind.integration.jei.JEIAlchemindPlugin;
import net.ironf.alchemind.integration.jei.SimpleAnimatedRecipeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static com.simibubi.create.compat.jei.category.CreateRecipeCategory.getRenderedSlot;

public class ArcanaRadiatorRecipeCategory implements IRecipeCategory<ArcanaRadiatorRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alchemind.MODID, "arcana_radiating");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Alchemind.MODID, "textures/gui/essence_mixer_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public ArcanaRadiatorRecipeCategory(IGuiHelper helper) {
        this.background = new EmptyBackground(177,48);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ARCANA_RADIATOR.get()));
    }

    @Override
    public RecipeType<ArcanaRadiatorRecipe> getRecipeType() {
        return JEIAlchemindPlugin.ARCANA_RADIATING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Essence Radiating");
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
    public void setRecipe(IRecipeLayoutBuilder builder, ArcanaRadiatorRecipe recipe, IFocusGroup focuses) {
        builder
                .addSlot(RecipeIngredientRole.INPUT, 27, 25)
                .addFluidStack(recipe.getInput().getMatchingFluidStacks().get(0).getFluid(),1000)
                .setBackground(getRenderedSlot(),-1,-1);
    }

    @Override
    public void draw(ArcanaRadiatorRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
        Minecraft mc = Minecraft.getInstance();

        AllGuiTextures.JEI_SHADOW.render(stack, 62, 35);
        new SimpleAnimatedRecipeItem(ModBlocks.ARCANA_RADIATOR.getDefaultState())
                .draw(stack,getBackground().getWidth() / 2 - 13,35);

        mc.font.draw(stack,recipe.getArcanaPerMB().toString() + " Arcana/Mb",111,25,0);
    }

}
