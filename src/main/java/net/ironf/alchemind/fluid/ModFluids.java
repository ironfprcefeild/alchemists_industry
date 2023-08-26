package net.ironf.alchemind.fluid;


import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Alchemind.MODID);


    //IGNUS

    public static final RegistryObject<FlowingFluid> FLOWING_IGNUS = FLUIDS.register("flowing_ignus", () -> new ForgeFlowingFluid.Flowing(ModFluids.IGNUS_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_IGNUS = FLUIDS.register("source_ignus", () -> new ForgeFlowingFluid.Source(ModFluids.IGNUS_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties IGNUS_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.IGNUS_FLUID_TYPE,SOURCE_IGNUS,FLOWING_IGNUS).slopeFindDistance(2).levelDecreasePerBlock(3).block(ModBlocks.IGNUS_FLUID_BLOCK).bucket(ModItems.IGNUS_BUCKET);
    //TERRA

    public static final RegistryObject<FlowingFluid> FLOWING_TERRA = FLUIDS.register("flowing_terra", () -> new ForgeFlowingFluid.Flowing(ModFluids.TERRA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_TERRA = FLUIDS.register("source_terra", () -> new ForgeFlowingFluid.Source(ModFluids.TERRA_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties TERRA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.TERRA_FLUID_TYPE, SOURCE_TERRA, FLOWING_TERRA).slopeFindDistance(2).levelDecreasePerBlock(5).block(ModBlocks.TERRA_FLUID_BLOCK).bucket(ModItems.TERRA_BUCKET);

    //AQUA

    public static final RegistryObject<FlowingFluid> FLOWING_AQUA = FLUIDS.register("flowing_aqua", () -> new ForgeFlowingFluid.Flowing(ModFluids.AQUA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_AQUA = FLUIDS.register("source_aqua", () -> new ForgeFlowingFluid.Source(ModFluids.AQUA_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties AQUA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.AQUA_FLUID_TYPE, SOURCE_AQUA, FLOWING_AQUA).slopeFindDistance(8).levelDecreasePerBlock(2).block(ModBlocks.AQUA_FLUID_BLOCK).bucket(ModItems.AQUA_BUCKET);

    //AERO
    public static final RegistryObject<FlowingFluid> FLOWING_AERO = FLUIDS.register("flowing_aero", () -> new ForgeFlowingFluid.Flowing(ModFluids.AERO_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_AERO = FLUIDS.register("source_aero", () -> new ForgeFlowingFluid.Source(ModFluids.AERO_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties AERO_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.AERO_FLUID_TYPE, SOURCE_AERO, FLOWING_AERO).slopeFindDistance(3).levelDecreasePerBlock(1).block(ModBlocks.AERO_FLUID_BLOCK).bucket(ModItems.AERO_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}