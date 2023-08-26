package net.ironf.alchemind.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class EssenceMixerRecipe implements Recipe<SimpleContainer> {
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

    public static class Type implements RecipeType<EssenceMixerRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "essence_mixing";
    }


    public NonNullList<FluidIngredient> getFluidIngredients() {
        return recipeFluids;
    }

    ResourceLocation id;
    FluidStack output;

    NonNullList<FluidIngredient> recipeFluids;

    public EssenceMixerRecipe(ResourceLocation id, FluidStack output, NonNullList<FluidIngredient> recipeFluids) {
        this.id = id;
        this.output = output;
        this.recipeFluids = recipeFluids;

    }

    public static class Serializer implements RecipeSerializer<EssenceMixerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Alchemind.MODID, "essence_mixing");

        @Override
        public EssenceMixerRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {


            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<FluidIngredient> inputs = NonNullList.withSize(2, FluidIngredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, FluidIngredient.deserialize(ingredients.get(i)));
            }

            ResourceLocation id = new ResourceLocation(GsonHelper.getAsString(pSerializedRecipe, "fluid_output"));
            Fluid output = (Fluid)ForgeRegistries.FLUIDS.getValue(id);

            int outputAmount = GsonHelper.getAsInt(pSerializedRecipe,"output_amount");

            return new EssenceMixerRecipe(pRecipeId, new FluidStack(output, outputAmount), inputs);
        }







        @Override
        public @Nullable EssenceMixerRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<FluidIngredient> inputs = NonNullList.withSize(buf.readInt(), FluidIngredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, FluidIngredient.read(buf));
            }

            FluidStack output = buf.readFluidStack();


            return new EssenceMixerRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, EssenceMixerRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (FluidIngredient ing : recipe.getFluidIngredients()) {
                ing.write(buf);
            }
            buf.writeFluidStack(recipe.getResultFluid());


        }
    }




}
