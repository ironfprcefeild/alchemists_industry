package net.ironf.alchemind.blocks.arcanaHolders;

import com.mojang.logging.LogUtils;
import net.ironf.alchemind.BlockDimPos;
import net.ironf.alchemind.data.arcana_maps;
import net.ironf.alchemind.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class arcanaHoldingBlock extends BaseEntityBlock implements IArcanaReader {

    boolean accepts;
    boolean sends;


    public arcanaHoldingBlock(Properties properties, boolean accepts, boolean sends) {
        super(properties);
        this.accepts = accepts;
        this.sends = sends;

    }
    private static final Logger LOGGER = LogUtils.getLogger();


    public static void ArcanaTick(Level Level, BlockPos preblockPos,int maximumArcana,  int maximumTransfer, int passiveGen, boolean sends, boolean accepts) {


        if (!Level.isClientSide){

            BlockDimPos blockPos = new BlockDimPos(preblockPos,Level);

            //Increase Arcana

            arcana_maps.ArcanaMap.put(blockPos, IArcanaReader.getOnArcanaMap(blockPos)+passiveGen);

            //Distribute arcana
            if (sends) {

                int Dis = 0;

                BlockDimPos TempBlockPos = new BlockDimPos(blockPos.above(), blockPos.getDimension());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new BlockDimPos(blockPos.below(), blockPos.getDimension());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new BlockDimPos(blockPos.east(), blockPos.getDimension());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new BlockDimPos(blockPos.west(), blockPos.getDimension());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new BlockDimPos(blockPos.south(), blockPos.getDimension());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new BlockDimPos(blockPos.north(), blockPos.getDimension());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }




                //Distribute
                if (Dis != 0) {
                    int toDistribute = Integer.min(IArcanaReader.getOnArcanaMap(blockPos), Mth.roundToward(maximumTransfer,1)) / Dis;

                    TempBlockPos = new BlockDimPos(blockPos.above(), Level);
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new BlockDimPos(blockPos.below(), Level);
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new BlockDimPos(blockPos.east(), Level);
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new BlockDimPos(blockPos.west(), Level);
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new BlockDimPos(blockPos.north(), Level);
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new BlockDimPos(blockPos.south(), Level);
                    feed(TempBlockPos, blockPos, toDistribute);
                }
            }


            //Limit At maximum
            if (IArcanaReader.getOnArcanaMap(blockPos) >= maximumArcana) {
                arcana_maps.ArcanaMap.put(blockPos, maximumArcana);
                arcana_maps.IsArcanaTaker.put(blockPos, false);
            } else if (accepts && IArcanaReader.getOnArcanaMap(blockPos) < maximumArcana){
                arcana_maps.IsArcanaTaker.put(blockPos, true);
            }
        }
    }

    public static void feed(BlockDimPos target, BlockDimPos sender, int amount){
        if (arcana_maps.IsArcanaTaker.get(target) != null && arcana_maps.IsArcanaTaker.get(target)) {
            arcana_maps.ArcanaMap.put(target, IArcanaReader.getOnArcanaMap(target) + amount);
            arcana_maps.ArcanaMap.put(sender, IArcanaReader.getOnArcanaMap(sender) - amount);
        }
    }
    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos preblockPos, BlockState state, boolean b) {
        if (!level.isClientSide) {

            //LOGGER.info("Arcana Holder placed");

            BlockDimPos blockPos = new BlockDimPos(preblockPos, level);
            arcana_maps.ArcanaMap.put(blockPos, 0);
            arcana_maps.IsArcanaTaker.put(blockPos, this.accepts);
        }
        super.onPlace(blockState, level, preblockPos, state, b);
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState1, boolean b) {
        if (!level.isClientSide){
            //LOGGER.info("Arcana Holder removed");

            arcana_maps.IsArcanaTaker.put(new BlockDimPos(blockPos,level),false);
        }
        super.onRemove(blockState, level, blockPos, blockState1, b);
    }


    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return null;
    }


}
