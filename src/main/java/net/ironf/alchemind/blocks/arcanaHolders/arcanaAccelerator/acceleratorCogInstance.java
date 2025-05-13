package net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator;

import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.SingleAxisRotatingVisual;
import dev.engine_room.flywheel.api.model.Model;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.model.Models;
import net.minecraft.core.Direction;

public class acceleratorCogInstance extends SingleAxisRotatingVisual<acceleratorBlockEntity> {


    public acceleratorCogInstance(VisualizationContext context, acceleratorBlockEntity blockEntity, float partialTick, Direction from, Model model) {
        super(context, blockEntity, partialTick, Direction.UP, Models.partial(AllPartialModels.ARM_COG));
    }



}