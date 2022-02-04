package cn.mcmod.corn_delight;

import java.util.Set;

import com.google.common.collect.Sets;

import cn.mcmod.corn_delight.worldgen.WildCornGeneration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.common.Configuration;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = CornDelight.MODID)
public class CornCommonEvent {

    private static final ResourceLocation SHIPWRECK_SUPPLY_CHEST = BuiltInLootTables.SHIPWRECK_SUPPLY;
    private static final Set<ResourceLocation> VILLAGE_HOUSE_CHESTS = Sets.newHashSet(
            BuiltInLootTables.VILLAGE_PLAINS_HOUSE, BuiltInLootTables.VILLAGE_SAVANNA_HOUSE,
            BuiltInLootTables.VILLAGE_SNOWY_HOUSE, BuiltInLootTables.VILLAGE_TAIGA_HOUSE,
            BuiltInLootTables.VILLAGE_DESERT_HOUSE);

    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        if (Configuration.CROPS_ON_SHIPWRECKS.get() && event.getName().equals(SHIPWRECK_SUPPLY_CHEST)) {
            event.getTable()
                    .addPool(LootPool.lootPool().add(LootTableReference
                            .lootTableReference(new ResourceLocation(CornDelight.MODID, "inject/shipwreck_supply"))
                            .setWeight(1).setQuality(0)).name("supply_cd_crops").build());
        }

        if (Configuration.CROPS_ON_VILLAGE_HOUSES.get() && VILLAGE_HOUSE_CHESTS.contains(event.getName())) {
            event.getTable()
                    .addPool(LootPool.lootPool().add(LootTableReference
                            .lootTableReference(new ResourceLocation(CornDelight.MODID, "inject/crops_villager_houses"))
                            .setWeight(1).setQuality(0)).name("villager_houses_cd_crops").build());
        }
    }

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        Biome.ClimateSettings climate = event.getClimate();
        if (climate.temperature > 0.0F && climate.temperature <= 1.0F) {
            if (CornDelightConfig.GENERATE_WILD_CORN.get()) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WildCornGeneration.PATCH_WILD_CORN);
            }
        }
    }
}
