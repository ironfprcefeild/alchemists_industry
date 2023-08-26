package net.ironf.alchemind.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.ironf.alchemind.Alchemind;
import net.ironf.alchemind.blocks.ModBlocks;
import net.ironf.alchemind.blocks.custom.effectLiquidBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {

    @Mod.EventBusSubscriber(modid = Alchemind.MODID)
    public class modEvents {
        @SubscribeEvent
        public static void onLivingTick(LivingEvent.LivingTickEvent event){
            if (event.getEntity() instanceof LivingEntity){
                if (event.getEntity().getFeetBlockState().getBlock() instanceof effectLiquidBlock){
                    event.getEntity().addEffect(((effectLiquidBlock) event.getEntity().getFeetBlockState().getBlock()).getEffect());
                }

                if (event.getEntity().getFeetBlockState().getBlock() == ModBlocks.TERRA_FLUID_BLOCK.get()){
                    event.getEntity().addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 150, 4));
                }
            }

        }
    }
}
