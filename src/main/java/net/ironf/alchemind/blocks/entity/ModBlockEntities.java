package net.ironf.alchemind.blocks.entity;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorCogInstance;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorRenderer;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser.arcanaInfuserBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator.ArcanaRadiatorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.arcanaRotorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.base.arcanaRotorBaseBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.creativeArcanaGenerator.creativeArcanaGeneratorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.essenceMixer.EssenceMixerBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor.mineralExtractorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.potionCatalyzer.potionCatalyzerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Alchemind.MODID);

    public static final RegistryObject<BlockEntityType<creativeArcanaGeneratorBlockEntity>> CREATIVE_ARCANA_GENERATOR =
            BLOCK_ENTITIES.register("creative_arcana_generator", () -> BlockEntityType.Builder.of(creativeArcanaGeneratorBlockEntity::new, ModBlocks.ARCANA_GENERATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<mineralExtractorBlockEntity>> MINERAL_EXTRACTOR =
            BLOCK_ENTITIES.register("mineral_extractor", () -> BlockEntityType.Builder.of(mineralExtractorBlockEntity::new, ModBlocks.MINERAL_EXTRACTOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<ArcanaRadiatorBlockEntity>> ARCANA_RADIATOR =
            BLOCK_ENTITIES.register("arcana_radiator", () -> BlockEntityType.Builder.of(ArcanaRadiatorBlockEntity::new, ModBlocks.ARCANA_RADIATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<EssenceMixerBlockEntity>> ESSENCE_MIXER =
            BLOCK_ENTITIES.register("essence_mixer", () -> BlockEntityType.Builder.of(EssenceMixerBlockEntity::new, ModBlocks.ESSENCE_MIXER.get()).build(null));

    public static final RegistryObject<BlockEntityType<arcanaRotorBaseBlockEntity>> ARCANA_ROTOR_BASE =
            BLOCK_ENTITIES.register("arcana_rotor_base", () -> BlockEntityType.Builder.of(arcanaRotorBaseBlockEntity::new, ModBlocks.ARCANA_ROTOR_BASE.get()).build(null));

    public static final RegistryObject<BlockEntityType<arcanaRotorBlockEntity>> ARCANA_ROTOR =
            BLOCK_ENTITIES.register("arcana_rotor", () -> BlockEntityType.Builder.of(arcanaRotorBlockEntity::new, ModBlocks.ARCANA_ROTOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<arcanaInfuserBlockEntity>> ARCANA_INFUSER =
            BLOCK_ENTITIES.register("arcana_infuser", () -> BlockEntityType.Builder.of(arcanaInfuserBlockEntity::new, ModBlocks.ARCANA_INFUSER.get()).build(null));


    public static final BlockEntityEntry<acceleratorBlockEntity> ACCELERATOR = Alchemind.REGISTRATE
            .blockEntity("accelerator", acceleratorBlockEntity::new)
            .instance(() -> acceleratorCogInstance::new, false)
            .validBlocks(ModBlocks.ACCELERATOR)
            .renderer(() -> acceleratorRenderer::new)
            .register();


    public static final RegistryObject<BlockEntityType<potionCatalyzerBlockEntity>> POTION_CATALYZER =
            BLOCK_ENTITIES.register("potion_catalyzer", () -> BlockEntityType.Builder
                    .of(potionCatalyzerBlockEntity::new, ModBlocks.POTION_CATALYZER.get()).build(null));
    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
        register();
    }

    public static void register(){}


}
