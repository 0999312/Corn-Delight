package cn.mcmod.corn_delight;

import java.util.Set;

import com.google.common.collect.Sets;

import cn.mcmod.corn_delight.worldgen.WildCornGeneration;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.setup.Configuration;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = CornDelight.MODID)
public class CornCommonEvent {

    private static final ResourceLocation SHIPWRECK_SUPPLY_CHEST = LootTables.SHIPWRECK_SUPPLY;
    private static final Set<ResourceLocation> VILLAGE_HOUSE_CHESTS = Sets.newHashSet(
            LootTables.VILLAGE_PLAINS_HOUSE, LootTables.VILLAGE_SAVANNA_HOUSE,
            LootTables.VILLAGE_SNOWY_HOUSE, LootTables.VILLAGE_TAIGA_HOUSE,
            LootTables.VILLAGE_DESERT_HOUSE);

    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        if (Configuration.CROPS_ON_SHIPWRECKS.get() && event.getName().equals(SHIPWRECK_SUPPLY_CHEST)) {
            event.getTable()
                    .addPool(LootPool.lootPool().add(TableLootEntry
                            .lootTableReference(new ResourceLocation(CornDelight.MODID, "inject/shipwreck_supply"))
                            .setWeight(1).setQuality(0)).name("supply_cd_crops").build());
        }

        if (Configuration.CROPS_ON_VILLAGE_HOUSES.get() && VILLAGE_HOUSE_CHESTS.contains(event.getName())) {
            event.getTable()
                    .addPool(LootPool.lootPool().add(TableLootEntry
                            .lootTableReference(new ResourceLocation(CornDelight.MODID, "inject/crops_villager_houses"))
                            .setWeight(1).setQuality(0)).name("villager_houses_cd_crops").build());
        }
    }

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        Biome.Climate climate = event.getClimate();
        if (climate.temperature > 0.0F && climate.temperature <= 1.0F) {
            if (CornDelightConfig.GENERATE_WILD_CORN.get()) {
                builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, WildCornGeneration.PATCH_WILD_CORN);
            }
        }
    }
}
