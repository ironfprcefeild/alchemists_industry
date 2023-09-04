package net.ironf.alchemind.blocks.arcanaHolders.arcanaAccelerator;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import com.simibubi.create.foundation.render.AllMaterialSpecs;

public class acceleratorCogInstance extends SingleRotatingInstance<acceleratorBlockEntity> {

    public acceleratorCogInstance(MaterialManager materialManager, acceleratorBlockEntity blockEntity) {
        super(materialManager, blockEntity);
    }

    @Override
    protected Instancer<RotatingData> getModel() {
        return getRotatingMaterial().getModel(AllPartialModels.ARM_COG, blockEntity.getBlockState());
    }

}