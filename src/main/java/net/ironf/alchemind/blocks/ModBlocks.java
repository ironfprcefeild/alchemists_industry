package net.ironf.alchemind.blocks;



import net.ironf.alchemind.blocks.custom.effectLiquidBlock;
import net.ironf.alchemind.blocks.custom.tool_tip_block_item;
import net.ironf.alchemind.fluid.ModFluids;
import net.ironf.alchemind.item.ModCreativeModeTab;
import net.ironf.alchemind.item.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ironf.alchemind.Alchemind;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Alchemind.MODID);

    //Blocks for real
    ///Solid Blocks
    public static  final RegistryObject<Block> SOLID_IGNUS = registerBlock("solid_ignus", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().lightLevel(new ToIntFunction<BlockState>() {
                @Override
                public int applyAsInt(BlockState value) {
                    return 5;
                }
            })), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> LOOSE_IGNUS = registerBlock("loose_ignus", () ->
            new FallingBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().lightLevel(new ToIntFunction<BlockState>() {
                @Override
                public int applyAsInt(BlockState value) {
                    return 10;
                }
            })), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SOLID_TERRA = registerBlock("solid_terra", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> LOOSE_TERRA = registerBlock("loose_terra", () ->
            new FallingBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SCULKING_TERRA = registerBlock("sculking_terra", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SOLID_AQUA = registerBlock("solid_aqua", () ->
            new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);
    public static  final RegistryObject<Block> LOOSE_AQUA = registerBlock("loose_aqua", () ->
            new FallingBlock(BlockBehaviour.Properties.of(Material.CLAY).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> SOLID_AERO = registerBlock("solid_aero", () ->
            new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);
    public static  final RegistryObject<Block> LOOSE_AERO = registerBlock("loose_aero", () ->
            new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> GALENA = registerBlock("galena", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> CORVIUM = registerBlock("corvium", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    public static  final RegistryObject<Block> CRYSTAL_GLASS = registerToolTipBlock("crystal_glass", () ->
            new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB,"It sees through what eyes cannot...");
    public static  final RegistryObject<Block> PEWTER_BLOCK = registerBlock("pewter_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.ALCHEMIND_TAB);

    //ARCANA JUNK


    ///Fluid Blocks
    public static final RegistryObject<LiquidBlock> IGNUS_FLUID_BLOCK = BLOCKS.register("ignus_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_IGNUS, BlockBehaviour.Properties.copy(Blocks.LAVA).lightLevel(new ToIntFunction<BlockState>() {
        @Override
        public int applyAsInt(BlockState value) {
            return 12;
        }
    }),new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10, 31)));

    public static final RegistryObject<LiquidBlock> TERRA_FLUID_BLOCK = BLOCKS.register("terra_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_TERRA, BlockBehaviour.Properties.copy(Blocks.LAVA), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 3)));

    public static final RegistryObject<LiquidBlock> AQUA_FLUID_BLOCK = BLOCKS.register("aqua_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_AQUA, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 11)));

    public static final RegistryObject<LiquidBlock> AERO_FLUID_BLOCK = BLOCKS.register("aero_fluid_block", () -> new effectLiquidBlock(ModFluids.SOURCE_AERO, BlockBehaviour.Properties.copy(Blocks.WATER), new MobEffectInstance(MobEffects.LEVITATION, 10, 31)));


    //Helper Functions
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerToolTipBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltip){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockToolTipItem(name, toReturn, tab, tooltip);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<Item> registerBlockToolTipItem(String name, Supplier<T> block, CreativeModeTab tab, String tooltip){
        return ModItems.ITEMS.register(name, () -> new tool_tip_block_item(block.get(), new Item.Properties().tab(tab),tooltip));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
