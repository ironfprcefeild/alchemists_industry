package net.ironf.alchemind.blocks.arcanaHolders.essenceMixer;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.jei.EmptyBackground;
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
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static com.simibubi.create.compat.jei.category.CreateRecipeCategory.getRenderedSlot;

public class EssenceMixerRecipeCategory implements IRecipeCategory<EssenceMixerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alchemind.MODID, "essence_mixing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Alchemind.MODID, "textures/gui/essence_mixer_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public EssenceMixerRecipeCategory(IGuiHelper helper) {
        this.background = new EmptyBackground(177,125);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ESSENCE_MIXER.get()));
    }

    @Override
    public RecipeType<EssenceMixerRecipe> getRecipeType() {
        return JEIAlchemindPlugin.ESSENCE_MIXING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("alchemind.essence_mixing.title");
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
        builder.addSlot(RecipeIngredientRole.OUTPUT, 120, 25)
                .addFluidStack(recipe.getResultFluid().getFluid(),recipe.getResultFluid().getAmount())
                .setBackground(getRenderedSlot(),-1,-1);

        builder.addSlot(RecipeIngredientRole.INPUT, 120, 50)
                .addFluidStack(recipe.getIngredientsFR().get(0).getMatchingFluidStacks().get(0).getFluid(),recipe.getIngredientsFR().get(0).getMatchingFluidStacks().get(0).getAmount())
                .setBackground(getRenderedSlot(),-1,-1);
        builder.addSlot(RecipeIngredientRole.INPUT, 120, 65)
                .addFluidStack(recipe.getIngredientsFR().get(1).getMatchingFluidStacks().get(0).getFluid(),recipe.getIngredientsFR().get(1).getMatchingFluidStacks().get(0).getAmount())
                .setBackground(getRenderedSlot(),-1,-1);
        builder.addSlot(RecipeIngredientRole.INPUT, 120, 80)
                .addFluidStack(recipe.getIngredientsFR().get(2).getMatchingFluidStacks().get(0).getFluid(),recipe.getIngredientsFR().get(2).getMatchingFluidStacks().get(0).getAmount())
                .setBackground(getRenderedSlot(),-1,-1);
    }

    @Override
    public void draw(EssenceMixerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        Minecraft mc = Minecraft.getInstance();
        guiGraphics.drawString(mc.font, recipe.getArcanaNeeded() + " " + Component.translatable("alchemind.arcana_required"), 56, 5, 0);

        new SimpleAnimatedRecipeItem(AllBlocks.ITEM_DRAIN.getDefaultState())
                .draw(guiGraphics,80,60);

        new SimpleAnimatedRecipeItem(AllBlocks.ITEM_DRAIN.getDefaultState())
                .draw(guiGraphics,80,75);

        new SimpleAnimatedRecipeItem(AllBlocks.ITEM_DRAIN.getDefaultState())
                .draw(guiGraphics,80,90);

        new SimpleAnimatedRecipeItem(ModBlocks.ESSENCE_MIXER.getDefaultState())
                .draw(guiGraphics,80,45);
    }
}
