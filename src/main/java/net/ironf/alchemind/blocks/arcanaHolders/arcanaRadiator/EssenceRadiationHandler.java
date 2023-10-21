package net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator;

import net.ironf.alchemind.Alchemind;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.List;

public class EssenceRadiationHandler implements ResourceManagerReloadListener {

    public static HashMap<Fluid,Integer> radiationHandler = new HashMap<>();
    public static Level level = null;

    public static void setLevel(Level level) {
        EssenceRadiationHandler.level = level;
    }

    public static void generateHandler(){
        if (level == null){
            return;
        }
        Alchemind.LOGGER.info("Generating Arcana Radiator Recipe Helper");
        List<ArcanaRadiatorRecipe> recipeList = createRecipeCollection();
        for (ArcanaRadiatorRecipe r : recipeList){
            for (FluidStack f : r.getInput().getMatchingFluidStacks()){
                Alchemind.LOGGER.info(f.getTranslationKey());
                Alchemind.LOGGER.info(r.getArcanaPerMB().toString());
                radiationHandler.put(f.getFluid(),r.getArcanaPerMB());
            }
        }
    }

    public static List<ArcanaRadiatorRecipe> createRecipeCollection(){
        return level.getRecipeManager().getAllRecipesFor(ArcanaRadiatorRecipe.Type.INSTANCE);
    }


    @Override
    public void onResourceManagerReload(ResourceManager p_10758_) {
        generateHandler();
    }
}
