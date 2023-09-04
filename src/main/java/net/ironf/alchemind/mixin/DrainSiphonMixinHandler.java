package net.ironf.alchemind.mixin;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.fluids.drain.ItemDrainBlock;
import net.ironf.alchemind.blocks.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(ItemDrainBlock.class)
public abstract class DrainSiphonMixinHandler {
    /*

    private static final IntegerProperty siphonTracker = IntegerProperty.create("siphontracker",0,3);



    @Inject(method = "createBlockStateDefinition", at = @At("HEAD"))
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(siphonTracker);
    }




    public BlockState setSiphonState(Level level, BlockPos pos) {
        BlockPos abovePos = pos.above();
        BlockEntity preBE = level.getBlockEntity(abovePos);
        BlockState drainBlockState = ((ItemDrainBlock) (Object) this).defaultBlockState();
        if (preBE != null){
            if (preBE.getType() == AllBlockEntityTypes.ITEM_DRAIN.get()){
                int recordedSiphonState = level.getBlockState(abovePos).getValue(siphonTracker);
                if (recordedSiphonState > 0){
                    return drainBlockState.setValue(siphonTracker,recordedSiphonState == 3 ? 0 : recordedSiphonState + 1);
                }
            } else if (preBE.getType() == ModBlockEntities.ESSENCE_MIXER.get()){
                return drainBlockState.setValue(siphonTracker,1);
            }
        }
        return drainBlockState.setValue(siphonTracker,0);
    }
    @Inject(method = "getStateForPlacement", at = @At("HEAD"))
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return setSiphonState(pContext.getLevel(),pContext.getClickedPos());
    }

*/
}
