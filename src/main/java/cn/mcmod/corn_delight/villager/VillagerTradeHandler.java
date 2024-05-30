package cn.mcmod.corn_delight.villager;

import java.util.List;

import cn.mcmod.corn_delight.CornDelightConfig;
import cn.mcmod.corn_delight.item.ItemRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.common.Configuration;

@Mod.EventBusSubscriber
public class VillagerTradeHandler {
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (!Configuration.FARMERS_BUY_FD_CROPS.get()) return;
        if (!CornDelightConfig.VILLAGER_TRADE_CORN.get()) return;
        addVillageTrade(event, "farmer", 1,
                new RandomPriceSellItemListing(new ItemStack(ItemRegistry.CORN.get()), 1, 16, 32, 16, 2));
        
        addVillageTrade(event, "farmer", 1,
                new RandomPriceSellItemListing(new ItemStack(ItemRegistry.CORN.get()), 1, 32, 48, 16, 2));

        addVillageTrade(event, "farmer", 2,
                new RandomPriceOrderItemListing(new ItemStack(ItemRegistry.CORNBREAD.get()), 1, 6, 16, 16, 5));
        
        addVillageTrade(event, "farmer", 2,
                new RandomPriceOrderItemListing(new ItemStack(ItemRegistry.TORTILLA.get()), 1, 6, 16, 16, 5));
    }

    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        genericTrades
                .add(new RandomPriceOrderItemListing(new ItemStack(ItemRegistry.CORN_SEEDS.get()), 1, 2, 8, 16, 2));

        List<VillagerTrades.ItemListing> rareTrades = event.getGenericTrades();
        
        rareTrades
            .add(new RandomPriceOrderItemListing(new ItemStack(ItemRegistry.POPCORN_BOX.get()), 2, 1, 2, 16, 15));
    }

    public static void addVillageTrade(VillagerTradesEvent event, String villager, int level,
            VillagerTrades.ItemListing listing) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        VillagerProfession profession = event.getType();
        if (profession.name() == null)
            return;
        if (profession.name().equals(villager)) {
            trades.get(level).add(listing);
        }
    }
}
