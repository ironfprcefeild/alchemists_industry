package net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator;

import com.google.gson.JsonObject;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import net.ironf.alchemind.Alchemind;
import net.minecraft.core.RegistryAccess;
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

public class ArcanaRadiatorRecipe implements Recipe<SimpleContainer> {


    @Override
    public boolean matches(SimpleContainer p_44002_, Level p_44003_) {
        return false;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pLevel) {
        return ItemStack.EMPTY;
    }


    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pLevel) {
        return getResultItem();
    }

    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Type implements RecipeType<ArcanaRadiatorRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "arcana_radiating";
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public FluidIngredient getInput() {
        return input;
    }

    private final ResourceLocation id;

    private final FluidIngredient input;

    private final Integer arcanaPerMB;


    public ArcanaRadiatorRecipe(ResourceLocation id, FluidIngredient input, Integer arcanaPerMB) {
        this.id = id;
        this.input = input;
        this.arcanaPerMB = arcanaPerMB;
    }

    public Integer getArcanaPerMB() {
        return arcanaPerMB;
    }

    public static class Serializer implements RecipeSerializer<ArcanaRadiatorRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Alchemind.MODID, "arcana_radiating");

        @Override
        public ArcanaRadiatorRecipe fromJson(ResourceLocation id, JsonObject pSerializedRecipe) {
            FluidIngredient fluid = FluidIngredient.deserialize(GsonHelper.getAsJsonObject(pSerializedRecipe,"input_fluid"));
            Integer arcanavalue = GsonHelper.getAsInt(pSerializedRecipe,"arcana_per_mb");
            return new ArcanaRadiatorRecipe(id,fluid,arcanavalue);

        }

        @Override
        public @Nullable ArcanaRadiatorRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            FluidIngredient fluid = FluidIngredient.read(buf);
            Integer arcanavalue = buf.readInt();
            return new ArcanaRadiatorRecipe(id, fluid, arcanavalue);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, ArcanaRadiatorRecipe recipe) {
            recipe.input.write(buf);
            buf.writeInt(recipe.getArcanaPerMB());
        }
    }
}
