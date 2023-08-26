package net.ironf.alchemind.blocks.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.registries.RegistryObject;

public class effectLiquidBlock extends LiquidBlock {

    MobEffectInstance effect;
    public effectLiquidBlock(RegistryObject<FlowingFluid> flowingFluid, Properties properties, MobEffectInstance effect) {
        super(flowingFluid, properties);
        this.effect = effect;
    }

    public MobEffectInstance getEffect(){
        return(this.effect);
    }
}
