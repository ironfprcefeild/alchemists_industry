package net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.ironf.alchemind.Alchemind;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
public class MineralExtractorRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;

    private final float consumeChance;

    private final int arcanaRequired;
    private final float chance;



    private final float extractionSpeed;

    private final NonNullList<Ingredient> recipeItems;

    public MineralExtractorRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, float chance, float consumeChance, int arcanaRequired, float extractionSpeed) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.chance = chance;
        this.consumeChance = consumeChance;
        this.arcanaRequired = arcanaRequired;
        this.extractionSpeed = extractionSpeed;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return recipeItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pLevel) {
        return output;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pLevel) {
        return getResultItem();
    }


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


    public float getChance(){
        return chance;
    }

    public float getConsumeChance() {
        return consumeChance;
    }

    public int getArcanaRequired() {
        return arcanaRequired;
    }

    public float getExtractionSpeed() {
        return extractionSpeed;
    }


    public static class Type implements RecipeType<MineralExtractorRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "mineral_extracting";
    }


    public static class Serializer implements RecipeSerializer<MineralExtractorRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Alchemind.MODID, "mineral_extracting");

        @Override
        public MineralExtractorRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            float chance = GsonHelper.getAsFloat(pSerializedRecipe, "chance");
            float consumeChance = GsonHelper.getAsFloat(pSerializedRecipe, "break_chance");
            int arcanaRequired = GsonHelper.getAsInt(pSerializedRecipe, "arcana_required");
            float extractionSpeed = GsonHelper.getAsFloat(pSerializedRecipe,"extraction_speed");
            return new MineralExtractorRecipe(pRecipeId, output, inputs,chance,consumeChance,arcanaRequired, extractionSpeed);
        }

        @Override
        public @Nullable MineralExtractorRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();

            float chance = buf.readFloat();
            float consumeChance = buf.readFloat();
            int arcanaRequired = buf.readInt();
            float extractionSpeed =buf.readFloat();

            return new MineralExtractorRecipe(id, output, inputs, chance,consumeChance,arcanaRequired, extractionSpeed);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, MineralExtractorRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }


            buf.writeFloat(recipe.getChance());
            buf.writeFloat(recipe.getConsumeChance());
            buf.writeInt(recipe.getArcanaRequired());
            buf.writeFloat(recipe.getExtractionSpeed());


            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}