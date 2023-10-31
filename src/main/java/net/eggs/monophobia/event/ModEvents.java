package net.eggs.monophobia.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.items.Moditems;
import net.eggs.monophobia.potion.ModPotions;
import net.eggs.monophobia.villager.ModVillagers;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;



// got help from https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java

@Mod.EventBusSubscriber(modid = Monophobiamod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.FLOW_WALKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Moditems.RAWOPAQUE.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.IRON_INGOT,3), stack, 10, 3, 0.02f
            )));

            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,2),
                    new ItemStack(Moditems.HERBAL_PURITY.get(), 3), 15, 1, 0.02f
            )));


            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,2),
                    new ItemStack(Moditems.MEMORY_ESSENCE.get(),2), 10, 2, 0.02f

            )));

            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.WHEAT,6),
                    new ItemStack(Moditems.CORRUPTEDFRUIT.get(),1), 10, 2, 0.02f

            )));

            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,7),
                    new ItemStack(Items.IRON_INGOT,2),
                    new ItemStack(Moditems.OPAQUE_HELMET.get(),1), 10, 6, 0.02f

            )));

            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,8),
                    new ItemStack(Items.IRON_INGOT,3),
                    new ItemStack(Moditems.OPAQUE_CHESTPLATE.get(),1), 10, 7, 0.02f

            )));

            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,7),
                    new ItemStack(Items.IRON_INGOT,3),
                    new ItemStack(Moditems.OPAQUE_LEGGINGS.get(),1), 10, 6, 0.02f

            )));

            trades.get(3).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,4),
                    new ItemStack(Items.IRON_INGOT,1),
                    new ItemStack(Moditems.OPAQUE_BOOTS.get(),1), 10, 5, 0.02f

            )));

        }
    }
}