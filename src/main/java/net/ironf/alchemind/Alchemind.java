package net.ironf.alchemind;

import com.mojang.logging.LogUtils;
import com.simibubi.create.content.logistics.item.filter.attribute.FluidContentsAttribute;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.fluid.ModFluidTypes;
import net.ironf.alchemind.fluid.ModFluids;
import net.ironf.alchemind.item.ModItems;
import net.ironf.alchemind.world.feature.ModConfiguredFeatures;
import net.ironf.alchemind.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Alchemind.MODID)
public class Alchemind
{
    public static final String MODID = "alchemind";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Alchemind()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);


        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModPlacedFeatures.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("alchemist's industry is running");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("alchemist's industry is running");
            //ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_IGNUS.get(), RenderType.translucent());
            //ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_IGNUS.get(), RenderType.translucent());

        }
    }
}
