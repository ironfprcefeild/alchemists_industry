package net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.base;

import com.mojang.logging.LogUtils;
import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.ironf.alchemind.BlockDimPos;
import net.ironf.alchemind.blocks.arcanaHolders.IArcanaReader;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator.acceleratorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.arcanaRotor.arcanaRotorBlockEntity;
import net.ironf.alchemind.blocks.arcanaHolders.mineralExtractor.mineralExtractorBlockEntity;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;

import java.util.List;

public class arcanaRotorBaseBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation, IArcanaReader {

    public arcanaRotorBaseBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ARCANA_ROTOR_BASE.get(), pos, state);
    }

    private static final Logger LOGGER = LogUtils.getLogger();


    public static void tick(Level level, BlockPos pos, BlockState blockState, arcanaRotorBaseBlockEntity pEntity) {

        if (level.isClientSide){
            return;
        }


        ///Helpys
        BlockDimPos dPos = new BlockDimPos(pos,level);
        pEntity.arcanaRef = IArcanaReader.getOnArcanaMap(new BlockDimPos(pEntity.getBlockPos(),level));
        Float acSpeed = findAcceleratorSpeed(pEntity);

        ///Prepare Next Load Score

        //Make an arcana taker if next load score isn't set.
        arcana_maps.IsArcanaTaker.put(dPos, pEntity.nextLoadScore == 0);

        //Get next load score if arcana is present
        if (pEntity.arcanaRef > 0 && pEntity.nextLoadScore == 0){
            LOGGER.info("Making Next Load Score");
            pEntity.nextLoadScore = calculateLoadScore(pEntity.arcanaRef);
            arcana_maps.ArcanaMap.put(dPos,0);
        }


        ///Reduce Load Value

        LOGGER.info("Supposed SU: " + getSU(pEntity));
        pEntity.lastValue = pEntity.loadValue;
        if (pEntity.loadValue > 0) {
            pEntity.loadValue = (int) (pEntity.loadValue - acSpeed);
        }


        ///Check for empty Load, if Empty use next load score and reset

        if (pEntity.loadValue <= 0 && pEntity.nextLoadScore != 0){
            LOGGER.info("Empty Load, setting as next load score");
            pEntity.loadScore = pEntity.nextLoadScore;
            pEntity.nextLoadScore = 0;
            pEntity.loadValue = 8129;
        }



        ///Help out the rotor with accelerator reading
        if (pEntity.prevAcceleratorSpeed != acSpeed || pEntity.loadScore != pEntity.prevLoadScore){
            BlockEntity rotor = level.getBlockEntity(pos.above());
            if (rotor != null && rotor.getType() == ModBlockEntities.ARCANA_ROTOR.get()){
                ((arcanaRotorBlockEntity) rotor).updateGeneratedRotation();
            }
        }

        //set prevAccelerator
        pEntity.prevAcceleratorSpeed = findAcceleratorSpeed(pEntity);
        pEntity.prevLoadScore = pEntity.loadScore;


        LOGGER.info("Load Value Remaining " + pEntity.loadValue);
    }



    public static Integer calculateLoadScore(int arcana){
        return Math.round((float) Math.pow(arcana, 1.5));
    }

    public Integer lastValue = 0;
    public Integer loadValue = 0;
    public Integer loadScore = 0;
    public Integer nextLoadScore = 0;
    public Integer prevLoadScore = 0;
    public Float prevAcceleratorSpeed = 0f;
    public Boolean running = false;
    public Boolean isFreeTick = false;
    public Integer arcanaRef;

    public static float getSU(arcanaRotorBaseBlockEntity pEntity) {
        return pEntity.loadValue > 0 || pEntity.nextLoadScore != 0 ? Math.round((float) pEntity.loadScore * findAcceleratorSpeed(pEntity)) : 0;
    }


    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        /*
            tooltip.add(Component.literal("Charge Left in Rotor Load: " + this.loadValue));
            tooltip.add(Component.literal("Consuming " + findAcceleratorSpeed(this) + " Charge per tick"));
            tooltip.add(Component.literal("Load Score: " + this.loadScore + "A result of " + Math.sqrt(this.loadScore) + " Arcana loaded in 1 tick" ));
            tooltip.add(Component.literal("Producing " + getSU(this)/8 + " SU"));

         */
        return true;
    }

    @Override
    public void onLoad() {
        this.arcanaRef = IArcanaReader.getOnArcanaMap(new BlockDimPos(this.getBlockPos(),this.getLevel()));
        super.onLoad();
    }

    public static float findAcceleratorSpeed(arcanaRotorBaseBlockEntity pEntity){
        BlockEntity accelerator = pEntity.level.getBlockEntity(pEntity.getBlockPos().below());
        return accelerator != null && accelerator.getType() == ModBlockEntities.ACCELERATOR.get() ? Math.abs(((acceleratorBlockEntity) accelerator).getSpeed()) : 0;
    }



    @Override
    protected void read(CompoundTag tag, boolean clientPacket) {
        tag.putInt("load_value",this.loadValue);
        tag.putInt("load_score",this.loadScore);
        tag.putInt("next_load_score",this.nextLoadScore);
        tag.putInt("prev_load_score",this.prevLoadScore);
        tag.putFloat("prev_speed", this.prevAcceleratorSpeed);
        tag.putBoolean("is_running",this.running);
        tag.putBoolean("is_free_tick",this.isFreeTick);
        super.read(tag, clientPacket);
    }


    @Override
    protected void write(CompoundTag tag, boolean clientPacket) {
        this.loadValue = tag.getInt("load_value");
        this.loadScore = tag.getInt("load_score");
        this.nextLoadScore = tag.getInt("next_load_score");
        this.prevLoadScore = tag.getInt("prev_load_score");
        this.prevAcceleratorSpeed = tag.getFloat("prev_speed");
        this.running = tag.getBoolean("is_running");
        this.isFreeTick = tag.getBoolean("is_free_tick");
        super.write(tag, clientPacket);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
    }




}
