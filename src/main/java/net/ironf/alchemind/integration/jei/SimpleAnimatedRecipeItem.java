package net.ironf.alchemind.integration.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Axis;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.gui.UIRenderHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleAnimatedRecipeItem extends AnimatedKinetics {

    public BlockState drawState;

    public SimpleAnimatedRecipeItem(BlockState drawState){
        this.drawState = drawState;
    }

    @Override
    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        PoseStack matrixStack = guiGraphics.pose();
        matrixStack.pushPose();
        matrixStack.translate(xOffset, yOffset, 100);
        matrixStack.mulPose(Axis.XP.rotationDegrees(-15.5f));
        matrixStack.mulPose(Axis.YP.rotationDegrees(22.5f));
        int scale = 20;

        blockElement(this.drawState)
                .scale(scale)
                .render(guiGraphics);

        MultiBufferSource.BufferSource buffer = MultiBufferSource.immediate(Tesselator.getInstance()
                .getBuilder());
        PoseStack ms = new PoseStack();
        UIRenderHelper.flipForGuiRender(ms);
        ms.scale(scale, scale, scale);
        float from = 2/16f;
        float to = 1f - from;
        buffer.endBatch();

        matrixStack.popPose();
    }
}
