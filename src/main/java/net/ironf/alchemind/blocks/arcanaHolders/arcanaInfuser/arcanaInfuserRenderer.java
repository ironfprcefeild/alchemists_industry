package net.ironf.alchemind.blocks.arcanaHolders.arcanaInfuser;

import com.jozufozu.flywheel.backend.Backend;
import com.jozufozu.flywheel.core.PartialModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
import com.simibubi.create.foundation.blockEntity.renderer.SafeBlockEntityRenderer;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import net.ironf.alchemind.Alchemind;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;

public class arcanaInfuserRenderer extends SafeBlockEntityRenderer<arcanaInfuserBlockEntity> {

    public arcanaInfuserRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected void renderSafe(arcanaInfuserBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {

        if (Backend.canUseInstancing(be.getLevel()))
            return;

        BlockState blockState = be.getBlockState();
        float renderedHeadOffset = be.getRenderedHeadOffset(partialTicks);
        renderedHeadOffset = 250;
        PartialModel renderModel  = new PartialModel(Alchemind.createRL("block/arcana_infuser/head"));


        SuperByteBuffer headRender = CachedBufferer.partialFacing(AllPartialModels.MECHANICAL_PRESS_HEAD, blockState,
                blockState.getValue(HORIZONTAL_FACING));
        headRender.translate(0, -renderedHeadOffset, 0)
                .light(light)
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }

    @Override
    public boolean shouldRenderOffScreen(arcanaInfuserBlockEntity p_112306_) {
        return true;
    }
}
