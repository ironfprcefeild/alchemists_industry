package net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import net.ironf.alchemind.Alchemind;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.HashMap;

public class ArcanaInfuserRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;

    private final float arcanaRequired;

    private final NonNullList<Ingredient> recipeItems;



    public ArcanaInfuserRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, float arcanaRequired) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.arcanaRequired = arcanaRequired;
    }
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return recipeItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }


    public float getArcanaRequired(){
        return arcanaRequired;
    }



    public static class Type implements RecipeType<ArcanaInfuserRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "arcana_infusing";
    }


    public static class Serializer implements RecipeSerializer<ArcanaInfuserRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Alchemind.MODID, "arcana_infusing");

        @Override
        public ArcanaInfuserRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            float arcana_required = GsonHelper.getAsFloat(pSerializedRecipe, "arcana_required");


            return new ArcanaInfuserRecipe(pRecipeId, output, inputs,arcana_required);
        }

        @Override
        public @Nullable ArcanaInfuserRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();

            float arcana = buf.readFloat();

            return new ArcanaInfuserRecipe(id, output, inputs, arcana);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, ArcanaInfuserRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }


            buf.writeFloat(recipe.getArcanaRequired());

            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}