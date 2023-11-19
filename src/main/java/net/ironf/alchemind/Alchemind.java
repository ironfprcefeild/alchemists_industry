package net.ironf.alchemind;

import com.mojang.logging.LogUtils;
import com.simibubi.create.CreateClient;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorRenderer;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRadiator.EssenceRadiationHandler;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.ironf.alchemind.fluid.ModFluidTypes;
import net.ironf.alchemind.fluid.ModFluids;
import net.ironf.alchemind.item.ModItems;
import net.ironf.alchemind.ponders.AllPonderTags;
import net.ironf.alchemind.ponders.PonderIndex;
import net.ironf.alchemind.recipe.ModRecipes;
import net.ironf.alchemind.world.feature.ModConfiguredFeatures;
import net.ironf.alchemind.world.feature.ModPlacedFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Alchemind.MODID)
public class Alchemind
{
    public static final String MODID = "alchemind";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);

    public static final Logger LOGGER = LogUtils.getLogger();

    public Alchemind()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        REGISTRATE.registerEventListeners(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModPlacedFeatures.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void ServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("Alchemist's industry is running on the server");


        LoadArcana(event.getServer());

        LOGGER.info("Alchemist's Industry is preparing Arcana Radiator Helpers");
        EssenceRadiationHandler.setLevel(event.getServer().overworld());
        EssenceRadiationHandler.generateHandler();
    }


    @SubscribeEvent
    public void ServerStopping(ServerStoppingEvent event)
    {
        // Do something when the server closes
        LOGGER.info("Alchemist's industry is closing on the server");
        SaveArcana(event.getServer());
    }



    public void SaveArcana(net.minecraft.server.MinecraftServer server){

        LOGGER.info("Alchemist's Industry is saving Arcana Information");

        arcana_maps data = arcana_maps.manage(server);

        data.setIsArcanaTakerMap(arcana_maps.IsArcanaTaker);
        data.setArcanaMap(arcana_maps.ArcanaMap);
    }

    public void LoadArcana(net.minecraft.server.MinecraftServer server){

        LOGGER.info("Alchemist's Industry is loading Arcana Information");

        arcana_maps data = arcana_maps.manage(server);

        arcana_maps.IsArcanaTaker = data.getisArcanaTakerMap();
        arcana_maps.ArcanaMap = data.getArcanaMap();

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("alchemist's industry is running on the client");
            AllPonderTags.register();
            PonderIndex.register();
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.ACCELERATOR.get(),
                   acceleratorRenderer::new);

        }
    }

    //Assisting Functions

    public static ResourceLocation createRL(String path){
        return new ResourceLocation(MODID,path);
    }



}
