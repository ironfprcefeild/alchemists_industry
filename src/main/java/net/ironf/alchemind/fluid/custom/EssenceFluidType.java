package net.ironf.alchemind.fluid.custom;

import net.minecraftforge.fluids.FluidType;

public class EssenceFluidType extends FluidType {

    public int arcanaValue;
    public EssenceFluidType(Properties properties, int arcanaValue) {
        super(properties);
        this.arcanaValue = arcanaValue;

    }
}
