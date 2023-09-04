package net.ironf.alchemind.ponders;

import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.ponders.scenes.*;

public class PonderIndex {


    static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper(Alchemind.MODID);

    public static final boolean REGISTER_DEBUG_SCENES = false;

    public static void register(){
        HELPER.forComponents(ModBlocks.MINERAL_EXTRACTOR)
                .addStoryBoard("mineral_extractor", mineralExtractorScene::extracting, AllPonderTags.ARCANA);

        HELPER.forComponents(ModBlocks.ARCANA_RADIATOR)
                .addStoryBoard("radiator", radiatorScene::essenceRadiating, AllPonderTags.ARCANA)
                .addStoryBoard("heated_radiator", radiatorScene::HeatedEssenceRadiating, AllPonderTags.ARCANA)
                .addStoryBoard("radiator",essenceMixerScenes::compoundEssenceRadiating, AllPonderTags.ARCANA);

        HELPER.forComponents(ModBlocks.ACCELERATOR)
                .addStoryBoard("accelerator", acceleratorScenes::accelerator, AllPonderTags.ACCELERATORS)
                .addStoryBoard("potion_catalyzer", acceleratorScenes::catalyzer, AllPonderTags.ACCELERATORS);

        HELPER.forComponents(ModBlocks.POTION_CATALYZER)
                .addStoryBoard("potion_catalyzer", acceleratorScenes::catalyzer, AllPonderTags.ACCELERATORS);

        HELPER.forComponents(ModBlocks.ESSENCE_MIXER)
                .addStoryBoard("essence_mixer", essenceMixerScenes::essenceMixing, AllPonderTags.ARCANA)
                .addStoryBoard("radiator",essenceMixerScenes::compoundEssenceRadiating, AllPonderTags.ARCANA);

        HELPER.forComponents(ModBlocks.ARCANA_INFUSER)
                .addStoryBoard("arcana_infuser", infuserScenes::infusing,AllPonderTags.ARCANA);



    }
}
