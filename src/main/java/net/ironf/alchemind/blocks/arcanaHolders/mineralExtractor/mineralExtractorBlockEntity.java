package net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor;

import com.mojang.logging.LogUtils;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.ironf.alchemind.SmartBlockPos;
import net.ironf.alchemind.blocks.arcanaHolders.IArcanaReader;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static net.ironf.alchemind.blocks.arcanaHolders.IAcceleratorReaderBlockEntity.findAcceleratorSpeed;

public class mineralExtractorBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {



    private static final Logger LOGGER = LogUtils.getLogger();


    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public Integer arcanaRef;

    public Integer processingTicks = 0;

    private final ContainerData data;
    private final Random random = new Random();

    private final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    public mineralExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MINERAL_EXTRACTOR.get(), pos, state);
        this.data = new ContainerData() {

            @Override
            public int get(int p_39284_) {
                return 0;
            }

            @Override
            public void set(int p_39285_, int p_39286_) {

            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }


    //Normal Arcana buisness

    @Override
    public void tick(){
        super.tick();
        if (level.isClientSide) {
            return;
        }
        BlockPos pos = this.getBlockPos();
        this.arcanaRef = IArcanaReader.getOnArcanaMap(pos);
        mineralExtractor.ArcanaTick(level, pos, 100, 10, 0, false, true);
        extractionTick();

    }

    private void extractionTick(){


        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(0));
        }

        ItemStack inputItem = new ItemStack(this.level.getBlockState(this.getBlockPos().below()).getBlock().asItem(),1);
        Optional<MineralExtractorRecipe> recipe = grabRecipe(this.level,inputItem);

        if (recipe.isPresent()) {
            float acceleratorSpeed = findAcceleratorSpeed(this);
            if (acceleratorSpeed != 0) {
                float extractionSpeed = recipe.get().getExtractionSpeed();
                float realSpeed = extractionSpeed == 0 ? acceleratorSpeed : extractionSpeed;
                float currentProcessingRate = (80 - Math.round(realSpeed / 14));

                if (this.processingTicks <= currentProcessingRate) {
                    this.processingTicks++;
                } else {
                    craftItem(recipe.get());
                }
            }
        }
    }

    //Recipe Junk
    private void craftItem(MineralExtractorRecipe recipe) {
        Level level = this.level;



        if (this.arcanaRef >= recipe.getArcanaRequired()) {
            ItemStack resultItem = recipe.getResultItem();
            if (this.itemHandler.isItemValid(0,resultItem)) {
                this.processingTicks = 1;
                if (this.getRandom().nextFloat() < recipe.getChance()) {
                    this.itemHandler.setStackInSlot(0,resultItem);
                }

                if (this.getRandom().nextFloat() < recipe.getConsumeChance()) {
                    level.setBlock(this.getBlockPos().below(), Blocks.AIR.defaultBlockState(), 3);
                }

                arcana_maps.ArcanaMap.put(new SmartBlockPos(this.getBlockPos()), IArcanaReader.getOnArcanaMap(this.getBlockPos()) - recipe.getArcanaRequired());
            }
        }
    }



    public static Optional<MineralExtractorRecipe> grabRecipe(Level level, ItemStack stack){
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, stack);
        Optional<MineralExtractorRecipe> recipe = level.getRecipeManager().getRecipeFor(MineralExtractorRecipe.Type.INSTANCE,inventory, level);
        return recipe;


    }
    public static ItemStack getExtractionResult(Level level, ItemStack stack){
        return grabRecipe(level, stack).map(MineralExtractorRecipe::getResultItem).orElse(ItemStack.EMPTY);
    }

    private  Random getRandom(){
        return this.random;
    }

    //google do
    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {

        tooltip.add(componentSpacing.plainCopy().append("Arcana Within: " + IArcanaReader.getOnArcanaMap(this.getBlockPos()) + "/100"));
        return true;
    }





    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        this.arcanaRef = IArcanaReader.getOnArcanaMap(this.getBlockPos());
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {

    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap,@Nullable Direction side) {

        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    //Droping junk
    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void read(CompoundTag tag, boolean clientPacket) {
        tag.putInt("processing_ticks",this.processingTicks);
        super.read(tag, clientPacket);
    }

    @Override
    protected void write(CompoundTag tag, boolean clientPacket) {
        this.processingTicks = tag.getInt("processing_ticks");
        super.write(tag, clientPacket);

    }


}
