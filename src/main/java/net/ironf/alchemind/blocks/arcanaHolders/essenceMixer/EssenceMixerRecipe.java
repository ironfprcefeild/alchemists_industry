package net.ironf.alchemind.blocks.arcanaHolders.essenceMixer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import net.ironf.alchemind.Alchemind;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class EssenceMixerRecipe implements Recipe<SimpleContainer> {
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return false;
    }
    @Override
    public ItemStack assemble(SimpleContainer simpleContainer) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return null;
    }


    public FluidStack getResultFluid() {
        return output.getMatchingFluidStacks().get(0);
    }

    public NonNullList<FluidIngredient> getIngredientsFR() {
        return Ingredients;
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


    public static class Type implements RecipeType<EssenceMixerRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "essence_mixing";
    }


    private final ResourceLocation id;
    private final NonNullList<FluidIngredient> Ingredients;
    private final FluidIngredient.FluidStackIngredient output;

    private final Integer arcanaNeeded;


    public EssenceMixerRecipe(ResourceLocation id, NonNullList<FluidIngredient> Ingredients, FluidIngredient.FluidStackIngredient output, Integer arcanaNeeded) {
        this.id = id;
        this.Ingredients = Ingredients;
        this.output = output;
        this.arcanaNeeded = arcanaNeeded;
    }

    public Boolean tester (FluidStack[] toTest){
        int helper = 0;
        for (FluidStack f : toTest){
            if (this.Ingredients.get(helper).test(f)){
                if (helper == 2){
                    return true;
                }
                helper++;
            } else {
                return false;
            }
        }
        return null;
    }

    public Integer getArcanaNeeded() {
        return arcanaNeeded;
    }

    public static class Serializer implements RecipeSerializer<EssenceMixerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Alchemind.MODID, "essence_mixing");

        @Override
        public EssenceMixerRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<FluidIngredient> inputs = NonNullList.withSize(3, FluidIngredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, FluidIngredient.deserialize(ingredients.get(i)));
            }
            FluidIngredient.FluidStackIngredient output = (FluidIngredient.FluidStackIngredient) FluidIngredient.deserialize(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
            Integer arcanaNeeded = GsonHelper.getAsInt(pSerializedRecipe,"arcana_required");
            return new EssenceMixerRecipe(pRecipeId,inputs,output, arcanaNeeded);
        }

        @Override
        public @Nullable EssenceMixerRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<FluidIngredient> inputs = NonNullList.withSize(buf.readInt(), FluidIngredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, FluidIngredient.read(buf));
            }



            return new EssenceMixerRecipe(id, inputs, (FluidIngredient.FluidStackIngredient) FluidIngredient.FluidStackIngredient.read(buf), buf.readInt());
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, EssenceMixerRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (FluidIngredient ing : recipe.Ingredients) {
                ing.write(buf);
            }

            FluidIngredient.FluidStackIngredient output = recipe.output;
            output.write(buf);
            buf.writeInt(recipe.arcanaNeeded);
        }
    }




}
