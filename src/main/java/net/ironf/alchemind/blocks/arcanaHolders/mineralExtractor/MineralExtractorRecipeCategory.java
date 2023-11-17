package net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor;

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
import net.ironf.alchemind.integration.jei.JEIAssistant;
import net.ironf.alchemind.integration.jei.SimpleAnimatedRecipeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static com.simibubi.create.compat.jei.category.CreateRecipeCategory.getRenderedSlot;

public class MineralExtractorRecipeCategory implements IRecipeCategory<MineralExtractorRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alchemind.MODID, "mineral_extracting");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Alchemind.MODID, "textures/gui/mineral_extractor_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public MineralExtractorRecipeCategory(IGuiHelper helper) {
        this.background = new EmptyBackground(177,125);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MINERAL_EXTRACTOR.get()));
    }

    @Override
    public RecipeType<MineralExtractorRecipe> getRecipeType() {
        return JEIAlchemindPlugin.MINERAL_EXTRACTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("alchemind.mineral_extracting.title");
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
    public void setRecipe(IRecipeLayoutBuilder builder, MineralExtractorRecipe recipe, IFocusGroup focuses) {
        builder
                .addSlot(RecipeIngredientRole.INPUT, getBackground().getWidth() / 2 - 8, 105)
                .addIngredients(recipe.getIngredients().get(0))
                .setBackground(getRenderedSlot(),-1,-1);

        builder
                .addSlot(RecipeIngredientRole.OUTPUT, getBackground().getWidth() / 2 + 30, 68)
                .addItemStack(recipe.getResultItem())
                .setBackground(getRenderedSlot(),-1,-1);
    }



    @Override
    public void draw(MineralExtractorRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        JEIAssistant assistant = new JEIAssistant(guiGraphics);
        assistant.spriteRender(AllGuiTextures.JEI_SHADOW,62,97);
        assistant.animatedBlock(ModBlocks.MINERAL_EXTRACTOR.getDefaultState(),
                getBackground().getWidth() / 2 - 13,92);


        assistant.text( recipe.getChance() * 100 + Component.translatable("alchemind.mineral_extracting.extraction_chance").getString(),20, 5);
        assistant.text( recipe.getConsumeChance() * 100 + Component.translatable("alchemind.mineral_extracting.break_chance").getString(), 20, 25);
        assistant.text( recipe.getArcanaRequired() + " " + Component.translatable("alchemind.arcana_required").getString(), 20, 40);


        if (recipe.getExtractionSpeed() != 0){
            assistant.text(Component.translatable("alchemind.no_accelerator_required"), 20, 60);
        }
    }
}
