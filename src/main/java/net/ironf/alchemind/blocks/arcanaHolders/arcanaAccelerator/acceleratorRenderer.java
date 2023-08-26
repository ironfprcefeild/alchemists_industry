package net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;

public class acceleratorRenderer extends KineticBlockEntityRenderer<acceleratorBlockEntity> {

    public acceleratorRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(acceleratorBlockEntity be, BlockState state) {
        return CachedBufferer.partial(AllPartialModels.ARM_COG, state);
    }

    @Override
    protected void renderSafe(acceleratorBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        super.renderSafe(be, partialTicks, ms, buffer, 10, overlay);
    }
}