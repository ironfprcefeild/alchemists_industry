package net.ironf.alchemind.ponders;


import com.simibubi.create.AllBlocks;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.createmod.ponder.foundation.PonderTag;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static net.ironf.alchemind.Alchemind.createRL;

public class AllPonderTags {

    public static final ResourceLocation

    ARCANA = createRL("pondertag_arcana"),

    ACCELERATORS = createRL("pondertag_accelerators");

    public static void register(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        helper.registerTag(ARCANA)
                .addToIndex()
                .item(ModBlocks.ARCANA_RADIATOR.get(), true, false)
                .title("Arcana")
                .description("Machines which exploit Arcana, a magical current of energy.")
                .register();
        helper.registerTag(ACCELERATORS)
                .addToIndex()
                .item(ModBlocks.ACCELERATOR.get(), true, false)
                .title("Accelerators")
                .description("The Arcana Accelerator and related components.")
                .register();


        HELPER.addToTag(ARCANA)
                .add(ModBlocks.ARCANA_RADIATOR)
                .add(ModBlocks.ARCANA_INFUSER)
                .add(ModBlocks.MINERAL_EXTRACTOR)
                .add(ModBlocks.ESSENCE_MIXER)
                .add(ModBlocks.ACCELERATOR)
                .add(ModBlocks.POTION_CATALYZER);

        HELPER.addToTag(ACCELERATORS)
                .add(ModBlocks.ACCELERATOR)
                .add(ModBlocks.POTION_CATALYZER);

        HELPER.addToTag(AllCreatePonderTags.CREATIVE).add(ModBlocks.ARCANA_GENERATOR);
        HELPER.addToTag(AllCreatePonderTags.FLUIDS).add(ModBlocks.ARCANA_RADIATOR);
        HELPER.addToTag(AllCreatePonderTags.KINETIC_APPLIANCES).add(ModBlocks.ACCELERATOR);


    }

}
