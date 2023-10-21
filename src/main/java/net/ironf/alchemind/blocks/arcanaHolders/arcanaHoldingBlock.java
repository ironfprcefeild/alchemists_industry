package net.ironf.alchemind.blocks.arcanaHolders;

import com.mojang.logging.LogUtils;
import net.ironf.alchemind.SmartBlockPos;
import net.ironf.alchemind.data.arcana_maps;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
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

            SmartBlockPos blockPos = new SmartBlockPos(preblockPos);

            //Increase Arcana

            arcana_maps.ArcanaMap.put(blockPos, IArcanaReader.getOnArcanaMap(blockPos)+passiveGen);

            //Distribute arcana
            if (sends) {

                int Dis = 0;

                SmartBlockPos TempBlockPos = new SmartBlockPos(blockPos.above());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new SmartBlockPos(blockPos.below());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new SmartBlockPos(blockPos.east());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new SmartBlockPos(blockPos.west());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new SmartBlockPos(blockPos.south());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }
                TempBlockPos = new SmartBlockPos(blockPos.north());
                if (arcana_maps.IsArcanaTaker.get(TempBlockPos) != null && arcana_maps.IsArcanaTaker.get(TempBlockPos)) {
                    Dis++;
                }




                //Distribute
                if (Dis != 0) {
                    int toDistribute = Integer.min(IArcanaReader.getOnArcanaMap(blockPos), Mth.floor(maximumTransfer / Dis));

                    TempBlockPos = new SmartBlockPos(blockPos.above());
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new SmartBlockPos(blockPos.below());
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new SmartBlockPos(blockPos.east());
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new SmartBlockPos(blockPos.west());
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new SmartBlockPos(blockPos.north());
                    feed(TempBlockPos, blockPos, toDistribute);

                    TempBlockPos = new SmartBlockPos(blockPos.south());
                    feed(TempBlockPos, blockPos, toDistribute);
                }
            }


            //Limit At maximum
            if (IArcanaReader.getOnArcanaMap(blockPos) >= maximumArcana && maximumArcana != 0) {
                arcana_maps.ArcanaMap.put(blockPos, maximumArcana);
                arcana_maps.IsArcanaTaker.put(blockPos, false);
            } else if (accepts && IArcanaReader.getOnArcanaMap(blockPos) < maximumArcana){
                arcana_maps.IsArcanaTaker.put(blockPos, true);
            }
        }
    }

    public static void feed(SmartBlockPos target, SmartBlockPos sender, int amount){
        if (arcana_maps.IsArcanaTaker.get(target) != null && arcana_maps.IsArcanaTaker.get(target)) {
            arcana_maps.ArcanaMap.put(target, IArcanaReader.getOnArcanaMap(target) + amount);
            arcana_maps.ArcanaMap.put(sender, IArcanaReader.getOnArcanaMap(sender) - amount);
        }
    }
    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos preblockPos, BlockState state, boolean b) {
        if (!level.isClientSide) {

            //LOGGER.info("Arcana Holder placed");

            SmartBlockPos blockPos = new SmartBlockPos(preblockPos);
            arcana_maps.ArcanaMap.put(blockPos, 0);
            arcana_maps.IsArcanaTaker.put(blockPos, this.accepts);
        }
        super.onPlace(blockState, level, preblockPos, state, b);
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState1, boolean b) {
        if (!level.isClientSide){
            //LOGGER.info("Arcana Holder removed");

            arcana_maps.IsArcanaTaker.put(new SmartBlockPos(blockPos),false);
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
