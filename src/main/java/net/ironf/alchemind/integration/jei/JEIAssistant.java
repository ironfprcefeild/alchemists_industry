package net.ironf.alchemind.integration.jei;

import com.simibubi.create.foundation.gui.element.ScreenElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;

public class JEIAssistant {

    public Font font;
    public GuiGraphics gg;

    public JEIAssistant(Font font, GuiGraphics gg){
        this.font = font;
        this.gg = gg;
    }

    public JEIAssistant(GuiGraphics gg){
        this.font = Minecraft.getInstance().font;
        this.gg = gg;
    }

    public void text(String toDraw, int pos1, int pos2){
        this.gg.drawString(this.font,toDraw,pos1,pos2,0,false);
    }
    public void text(Component toDraw, int pos1, int pos2){
        this.gg.drawString(this.font,toDraw,pos1,pos2,0,false);
    }

    public void animatedBlock(BlockState block, int xOffset, int yOffset){
        new SimpleAnimatedRecipeItem(block).draw(this.gg, xOffset,yOffset);
    }

    public void spriteRender(ScreenElement screenElement, int x, int y){
        screenElement.render(this.gg,x,y);
    }
}

