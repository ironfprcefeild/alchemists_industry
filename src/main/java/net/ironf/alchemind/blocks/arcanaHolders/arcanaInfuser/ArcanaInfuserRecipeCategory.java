package net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser;

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
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.simibubi.create.compat.jei.category.CreateRecipeCategory.getRenderedSlot;

@ParametersAreNonnullByDefault
public class ArcanaInfuserRecipeCategory implements IRecipeCategory<ArcanaInfuserRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alchemind.MODID, "arcana_infusing");

    private final IDrawable background;
    private final IDrawable icon;

    public ArcanaInfuserRecipeCategory(IGuiHelper helper) {
        this.background = new EmptyBackground(177,125);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ARCANA_INFUSER.get()));
    }
    @Override
    public RecipeType<ArcanaInfuserRecipe> getRecipeType() {
        return JEIAlchemindPlugin.ARCANA_INFUSING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("alchemind.arcana_infusing.title");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return null;
    }




    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ArcanaInfuserRecipe recipe, IFocusGroup focuses) {
        builder
                .addSlot(RecipeIngredientRole.INPUT, 27, 51)
                .addIngredients(recipe.getIngredients().get(0))
                .setBackground(getRenderedSlot(),-1,-1);
        builder
                .addSlot(RecipeIngredientRole.OUTPUT, 131, 50)
                .addItemStack(recipe.getResultItem())
                .setBackground(getRenderedSlot(),-1,-1);;


    }


    @Override
    public void draw(ArcanaInfuserRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        Minecraft mc = Minecraft.getInstance();

        guiGraphics.drawString(mc.font, recipe.getArcanaRequired() + " " + Component.translatable("alchemind.arcana_required").getString(), 56, 70, 0, false);
        AllGuiTextures.JEI_SHADOW.render(guiGraphics, 61, 41);
        AllGuiTextures.JEI_LONG_ARROW.render(guiGraphics, 52, 54);

        new SimpleAnimatedRecipeItem(ModBlocks.ARCANA_INFUSER.getDefaultState())
                .draw(guiGraphics, getBackground().getWidth() / 2 - 17, 22);


    }

}
