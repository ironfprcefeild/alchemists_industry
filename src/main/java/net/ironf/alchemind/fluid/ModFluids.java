package net.ironf.alchemind.fluid;


import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static net.ironf.alchemind.Alchemind.REGISTRATE;


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

    //MIXING REAGENT
    public static final RegistryObject<FlowingFluid> FLOWING_REAGENT = FLUIDS.register("flowing_reagent", () -> new ForgeFlowingFluid.Flowing(ModFluids.REAGENT_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_REAGENT = FLUIDS.register("source_reagent", () -> new ForgeFlowingFluid.Source(ModFluids.REAGENT_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties REAGENT_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.REAGENT_FLUID_TYPE, SOURCE_REAGENT, FLOWING_REAGENT).slopeFindDistance(1).levelDecreasePerBlock(3).block(ModBlocks.REAGENT_FLUID_BLOCK).bucket(ModItems.REAGENT_BUCKET);

    //STELLAR FUEL
    public static final RegistryObject<FlowingFluid> FLOWING_STELLAR_FUEL = FLUIDS.register("flowing_stellar_fuel", () -> new ForgeFlowingFluid.Flowing(ModFluids.STELLAR_FUEL_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_STELLAR_FUEL = FLUIDS.register("source_stellar_fuel", () -> new ForgeFlowingFluid.Source(ModFluids.STELLAR_FUEL_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties STELLAR_FUEL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.STELLAR_FUEL_FLUID_TYPE, SOURCE_STELLAR_FUEL, FLOWING_STELLAR_FUEL).slopeFindDistance(1).levelDecreasePerBlock(3).block(ModBlocks.STELLAR_FUEL_FLUID_BLOCK).bucket(ModItems.STELLAR_FUEL_BUCKET);

    //GLIMA
    public static final RegistryObject<FlowingFluid> FLOWING_GLIMA = FLUIDS.register("flowing_glima", () -> new ForgeFlowingFluid.Flowing(ModFluids.GLIMA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_GLIMA = FLUIDS.register("source_glima", () -> new ForgeFlowingFluid.Source(ModFluids.GLIMA_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties GLIMA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.GLIMA_FLUID_TYPE, SOURCE_GLIMA, FLOWING_GLIMA).slopeFindDistance(3).levelDecreasePerBlock(1).block(ModBlocks.GLIMA_FLUID_BLOCK).bucket(ModItems.GLIMA_BUCKET);

    //Shade
    public static final RegistryObject<FlowingFluid> FLOWING_SHADE = FLUIDS.register("flowing_shade", () -> new ForgeFlowingFluid.Flowing(ModFluids.SHADE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_SHADE = FLUIDS.register("source_shade", () -> new ForgeFlowingFluid.Source(ModFluids.SHADE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties SHADE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SHADE_FLUID_TYPE, SOURCE_SHADE, FLOWING_SHADE).slopeFindDistance(3).levelDecreasePerBlock(1).block(ModBlocks.SHADE_FLUID_BLOCK).bucket(ModItems.SHADE_BUCKET);

    //Order
    public static final RegistryObject<FlowingFluid> FLOWING_ORDER = FLUIDS.register("flowing_order", () -> new ForgeFlowingFluid.Flowing(ModFluids.ORDER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_ORDER = FLUIDS.register("source_order", () -> new ForgeFlowingFluid.Source(ModFluids.ORDER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties ORDER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ORDER_FLUID_TYPE, SOURCE_ORDER, FLOWING_ORDER).slopeFindDistance(0).levelDecreasePerBlock(10).block(ModBlocks.ORDER_FLUID_BLOCK).bucket(ModItems.ORDER_BUCKET);
    //Potere

    public static final RegistryObject<FlowingFluid> FLOWING_POTERE = FLUIDS.register("flowing_potere", () -> new ForgeFlowingFluid.Flowing(ModFluids.POTERE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_POTERE = FLUIDS.register("source_potere", () -> new ForgeFlowingFluid.Source(ModFluids.POTERE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties POTERE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.POTERE_FLUID_TYPE, SOURCE_POTERE, FLOWING_POTERE).slopeFindDistance(4).levelDecreasePerBlock(2).block(ModBlocks.POTERE_FLUID_BLOCK).bucket(ModItems.POTERE_BUCKET);


    //Gheigh

    public static final RegistryObject<FlowingFluid> FLOWING_GHEIGH = FLUIDS.register("flowing_gheigh", () -> new ForgeFlowingFluid.Flowing(ModFluids.GHIEGH_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_GHEIGH = FLUIDS.register("source_gheigh", () -> new ForgeFlowingFluid.Source(ModFluids.GHIEGH_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties GHIEGH_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.GHEIGH_FLUID_TYPE, SOURCE_GHEIGH, FLOWING_GHEIGH).slopeFindDistance(12).levelDecreasePerBlock(1).block(ModBlocks.GHEIGH_FLUID_BLOCK).bucket(ModItems.GHEIGH_BUCKET);

    //Vivorn
    public static final RegistryObject<FlowingFluid> FLOWING_VIVORN = FLUIDS.register("flowing_vivorn", () -> new ForgeFlowingFluid.Flowing(ModFluids.VIVORN_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_VIVORN = FLUIDS.register("source_vivorn", () -> new ForgeFlowingFluid.Source(ModFluids.VIVORN_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties VIVORN_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.VIVORN_FLUID_TYPE, SOURCE_VIVORN, FLOWING_VIVORN).slopeFindDistance(5).levelDecreasePerBlock(3).block(ModBlocks.VIVORN_FLUID_BLOCK).bucket(ModItems.VIVORN_BUCKET);

    //Mortith
    public static final RegistryObject<FlowingFluid> FLOWING_MORTITH = FLUIDS.register("flowing_mortith", () -> new ForgeFlowingFluid.Flowing(ModFluids.MORTITH_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_MORTITH = FLUIDS.register("source_mortith", () -> new ForgeFlowingFluid.Source(ModFluids.MORTITH_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MORTITH_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MORTITH_FLUID_TYPE, SOURCE_MORTITH, FLOWING_MORTITH).slopeFindDistance(2).levelDecreasePerBlock(3).block(ModBlocks.MORTITH_FLUID_BLOCK).bucket(ModItems.MORTITH_BUCKET);
    //Movere

    public static final RegistryObject<FlowingFluid> FLOWING_MOVERE = FLUIDS.register("flowing_movere", () -> new ForgeFlowingFluid.Flowing(ModFluids.MOVERE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_MOVERE = FLUIDS.register("source_movere", () -> new ForgeFlowingFluid.Source(ModFluids.MOVERE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOVERE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOVERE_FLUID_TYPE, SOURCE_MOVERE, FLOWING_MOVERE).slopeFindDistance(3).levelDecreasePerBlock(3).block(ModBlocks.MOVERE_FLUID_BLOCK).bucket(ModItems.MOVERE_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}