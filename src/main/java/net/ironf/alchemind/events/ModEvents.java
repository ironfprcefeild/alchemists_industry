package net.ironf.alchemind.events;

import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.blocks.custom.effectLiquidBlock;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {

    @Mod.EventBusSubscriber(modid = Alchemind.MODID)
    public class modEvents {
        @SubscribeEvent
        public static void onLivingTick(LivingEvent.LivingTickEvent event){
            /*
            if (event.getEntity() != null && !event.getEntity().getLevel().isClientSide){
                if (event.getEntity().getLevel().getBlockState(event.getEntity().getOnPos().below()).getBlock() instanceof effectLiquidBlock){
                    event.getEntity().addEffect(((effectLiquidBlock) event.getEntity().getLevel().getBlockState(event.getEntity().getOnPos().below()).getBlock()).getEffect());
                }

                if (event.getEntity().getFeetBlockState().getBlock() == ModBlocks.TERRA_FLUID_BLOCK.get()){
                    event.getEntity().addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 150, 4));
                }
            }

             */
        }





    }
}
