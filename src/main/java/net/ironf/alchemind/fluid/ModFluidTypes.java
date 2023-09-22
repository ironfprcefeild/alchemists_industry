package net.ironf.alchemind.fluid;

import net.ironf.alchemind.Alchemind;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ModFluidTypes {


    ///Helper functions


    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Alchemind.MODID);
    private static RegistryObject<FluidType> registerFluidType(String name, UnaryOperator<FluidType.Properties> operator, ResourceLocation Still_RL, ResourceLocation Flowing_RL, ResourceLocation Overlay_RL) {

        return FLUID_TYPES.register(name, () -> new FluidType(operator.apply(FluidType.Properties.create())) {

            private final ResourceLocation stillTexture = Still_RL;
            private final ResourceLocation flowingTexture = Flowing_RL;
            private final ResourceLocation overlayTexture = Overlay_RL;


            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {
                    @Override
                    public ResourceLocation getStillTexture() {
                        return stillTexture;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return flowingTexture;
                    }

                    @Override
                    public ResourceLocation getOverlayTexture() {
                        return overlayTexture;
                    }
                });
            }
        });
    }

    //IGNUS
    public static final ResourceLocation IGNUS_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_ignus_still");
    public static final ResourceLocation IGNUS_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_ignus_flow");
    public static final ResourceLocation IGNUS_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_ignus_still");
    public static final RegistryObject<FluidType> IGNUS_FLUID_TYPE = registerFluidType("source_ignus",
            properties -> properties.
                    temperature(10).lightLevel(2).
                    density(1500).
                    viscosity(2000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            IGNUS_STILL_RL,IGNUS_FLOWING_RL,IGNUS_OVERLAY_RL);

    //AQUA
    public static final ResourceLocation AQUA_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_aqua_still");
    public static final ResourceLocation AQUA_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_aqua_flow");
    public static final ResourceLocation AQUA_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_aqua_still");
    public static final RegistryObject<FluidType> AQUA_FLUID_TYPE = registerFluidType("source_aqua",
            properties -> properties.
                    temperature(0).
                    density(20).
                    viscosity(10).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            AQUA_STILL_RL,AQUA_FLOWING_RL,AQUA_OVERLAY_RL);

    //AERO
    public static final ResourceLocation AERO_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_aero_still");
    public static final ResourceLocation AERO_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_aero_flow");
    public static final ResourceLocation AERO_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_aero_still");
    public static final RegistryObject<FluidType> AERO_FLUID_TYPE = registerFluidType("source_aero",
            properties -> properties.
                    temperature(0).
                    density(20).
                    viscosity(10).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            AERO_STILL_RL,AERO_FLOWING_RL,AERO_OVERLAY_RL);

    //TERRA
    public static final ResourceLocation TERRA_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_terra_still");
    public static final ResourceLocation TERRA_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_terra_flow");
    public static final ResourceLocation TERRA_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_terra_still");
    public static final RegistryObject<FluidType> TERRA_FLUID_TYPE = registerFluidType("source_terra",
            properties -> properties.
                    density(20).
                    viscosity(2000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            TERRA_STILL_RL,TERRA_FLOWING_RL,TERRA_OVERLAY_RL);


    //Reagent

    public static final ResourceLocation REAGENT_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_reagent_still");
    public static final ResourceLocation REAGENT_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_reagent_flow");
    public static final ResourceLocation REAGENT_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_reagent_still");
    public static final RegistryObject<FluidType> REAGENT_FLUID_TYPE = registerFluidType("source_reagent",
            properties -> properties.
                    density(20).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            REAGENT_STILL_RL,REAGENT_FLOWING_RL,REAGENT_OVERLAY_RL);

    //STELLAR FUEL
    public static final ResourceLocation STELLAR_FUEL_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_stellar_fuel_still");
    public static final ResourceLocation STELLAR_FUEL_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_stellar_fuel_flow");
    public static final ResourceLocation STELLAR_FUEL_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_stellar_fuel_still");
    public static final RegistryObject<FluidType> STELLAR_FUEL_FLUID_TYPE = registerFluidType("source_stellar_fuel",
            properties -> properties.
                    density(20).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            STELLAR_FUEL_STILL_RL,STELLAR_FUEL_FLOWING_RL,STELLAR_FUEL_OVERLAY_RL);
    //GLIMA
    public static final ResourceLocation GLIMA_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_glima_still");
    public static final ResourceLocation GLIMA_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_glima_flow");
    public static final ResourceLocation GLIMA_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_glima_still");
    public static final RegistryObject<FluidType> GLIMA_FLUID_TYPE = registerFluidType("source_glima",
            properties -> properties.
                    density(20).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            GLIMA_STILL_RL,GLIMA_FLOWING_RL,GLIMA_OVERLAY_RL);

    //SHADE
    public static final ResourceLocation SHADE_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_shade_still");
    public static final ResourceLocation SHADE_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_shade_flow");
    public static final ResourceLocation SHADE_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_shade_still");
    public static final RegistryObject<FluidType> SHADE_FLUID_TYPE = registerFluidType("source_shade",
            properties -> properties.
                    density(2).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            SHADE_STILL_RL,SHADE_FLOWING_RL,SHADE_OVERLAY_RL);

    //ORDER

    public static final ResourceLocation ORDER_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_order_still");
    public static final ResourceLocation ORDER_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_order_flow");
    public static final ResourceLocation ORDER_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_order_still");
    public static final RegistryObject<FluidType> ORDER_FLUID_TYPE = registerFluidType("source_order",
            properties -> properties.
                    density(2).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            ORDER_STILL_RL,ORDER_FLOWING_RL,ORDER_OVERLAY_RL);

    //POTERE
    public static final ResourceLocation POTERE_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_potere_still");
    public static final ResourceLocation POTERE_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_potere_flow");
    public static final ResourceLocation POTERE_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_potere_still");
    public static final RegistryObject<FluidType> POTERE_FLUID_TYPE = registerFluidType("source_potere",
            properties -> properties.
                    density(2).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            POTERE_STILL_RL,POTERE_FLOWING_RL,POTERE_OVERLAY_RL);

    //Gheigh
    public static final ResourceLocation GHEIGH_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_gheigh_still");
    public static final ResourceLocation GHEIGH_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_gheigh_flow");
    public static final ResourceLocation GHEIGH_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_gheigh_still");
    public static final RegistryObject<FluidType> GHEIGH_FLUID_TYPE = registerFluidType("source_gheigh",
            properties -> properties.
                    density(2).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            GHEIGH_STILL_RL,GHEIGH_FLOWING_RL,GHEIGH_OVERLAY_RL);

    //Vivorn

    public static final ResourceLocation VIVORN_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_vivorn_still");
    public static final ResourceLocation VIVORN_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_vivorn_flow");
    public static final ResourceLocation VIVORN_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_vivorn_still");
    public static final RegistryObject<FluidType> VIVORN_FLUID_TYPE = registerFluidType("source_vivorn",
            properties -> properties.
                    density(2).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            VIVORN_STILL_RL,VIVORN_FLOWING_RL,VIVORN_OVERLAY_RL);

    //Mortith

    public static final ResourceLocation MORTITH_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_mortith_still");
    public static final ResourceLocation MORTITH_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_mortith_flow");
    public static final ResourceLocation MORTITH_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_mortith_still");
    public static final RegistryObject<FluidType> MORTITH_FLUID_TYPE = registerFluidType("source_mortith",
            properties -> properties.
                    density(2).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            MORTITH_STILL_RL,MORTITH_FLOWING_RL,MORTITH_OVERLAY_RL);

    //Movere
    public static final ResourceLocation MOVERE_STILL_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_movere_still");
    public static final ResourceLocation MOVERE_FLOWING_RL = new ResourceLocation(Alchemind.MODID,"fluids/in_movere_flow");
    public static final ResourceLocation MOVERE_OVERLAY_RL = new ResourceLocation(Alchemind.MODID, "fluids/in_movere_still");
    public static final RegistryObject<FluidType> MOVERE_FLUID_TYPE = registerFluidType("source_movere",
            properties -> properties.
                    density(2).
                    viscosity(1000).
                    sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK),
            MOVERE_STILL_RL,MOVERE_FLOWING_RL,MOVERE_OVERLAY_RL);
    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}