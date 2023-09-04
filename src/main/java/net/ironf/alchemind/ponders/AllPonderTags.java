package net.ironf.alchemind.ponders;

import com.simibubi.create.foundation.ponder.PonderRegistry;
import com.simibubi.create.foundation.ponder.PonderTag;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;

public class AllPonderTags {

    public static final PonderTag

    ARCANA = create("arcana").item(ModBlocks.ARCANA_RADIATOR.get())
            .defaultLang("Arcana", "Components which use or generate Arcana Power")
            .addToIndex(),

    ACCELERATORS = create("accelerators").item(ModBlocks.ACCELERATOR.get())
            .defaultLang("Accelerators","Components which are used to control Arcana Machinery")
            .addToIndex();
    private static PonderTag create(String id) {
        return new PonderTag(Alchemind.createRL(id));
    }

    public static void register() {
        PonderRegistry.TAGS.forTag(ARCANA)
                .add(ModBlocks.ARCANA_RADIATOR.get())
                .add(ModBlocks.ARCANA_INFUSER.get())
                .add(ModBlocks.MINERAL_EXTRACTOR.get())
                .add(ModBlocks.ARCANA_ROTOR.get())
                .add(ModBlocks.ARCANA_ROTOR_BASE.get())
                .add(ModBlocks.ESSENCE_MIXER.get())
                .add(ModBlocks.ACCELERATOR.get())
                .add(ModBlocks.POTION_CATALYZER.get());

        PonderRegistry.TAGS.forTag(ACCELERATORS)
                .add(ModBlocks.ACCELERATOR.get())
                .add(ModBlocks.POTION_CATALYZER.get());

        PonderRegistry.TAGS.forTag(com.simibubi.create.infrastructure.ponder.AllPonderTags.CREATIVE).add(ModBlocks.ARCANA_GENERATOR);
        PonderRegistry.TAGS.forTag(com.simibubi.create.infrastructure.ponder.AllPonderTags.FLUIDS).add(ModBlocks.ARCANA_RADIATOR);
        PonderRegistry.TAGS.forTag(com.simibubi.create.infrastructure.ponder.AllPonderTags.KINETIC_APPLIANCES).add(ModBlocks.ACCELERATOR);
        PonderRegistry.TAGS.forTag(com.simibubi.create.infrastructure.ponder.AllPonderTags.KINETIC_SOURCES).add(ModBlocks.ARCANA_ROTOR);
        PonderRegistry.TAGS.forTag(com.simibubi.create.infrastructure.ponder.AllPonderTags.KINETIC_SOURCES).add(ModBlocks.ARCANA_ROTOR_BASE);




    }

}
