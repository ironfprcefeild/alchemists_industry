package net.ironf.alchemind.ponders;

import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.ponders.scenes.*;
import net.minecraft.resources.ResourceLocation;

public class PonderIndex {


 

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper){
        PonderSceneRegistrationHelper<ItemProviderEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);


        HELPER.forComponents(ModBlocks.MINERAL_EXTRACTOR)
                .addStoryBoard("mineral_extractor", mineralExtractorScene::extracting);

        HELPER.forComponents(ModBlocks.ARCANA_RADIATOR)
                .addStoryBoard("radiator", radiatorScene::essenceRadiating)
                .addStoryBoard("heated_radiator", radiatorScene::HeatedEssenceRadiating)
                .addStoryBoard("radiator",essenceMixerScenes::compoundEssenceRadiating);

        HELPER.forComponents(ModBlocks.ACCELERATOR)
                .addStoryBoard("accelerator", acceleratorScenes::accelerator)
                .addStoryBoard("potion_catalyzer", acceleratorScenes::catalyzer);

        HELPER.forComponents(ModBlocks.POTION_CATALYZER)
                .addStoryBoard("potion_catalyzer", acceleratorScenes::catalyzer);

        HELPER.forComponents(ModBlocks.ESSENCE_MIXER)
                .addStoryBoard("essence_mixer", essenceMixerScenes::essenceMixing)
                .addStoryBoard("radiator",essenceMixerScenes::compoundEssenceRadiating);

        HELPER.forComponents(ModBlocks.ARCANA_INFUSER)
                .addStoryBoard("arcana_infuser", infuserScenes::infusing);



    }
}
