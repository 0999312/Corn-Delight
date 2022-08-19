package cn.mcmod.corn_delight;

import cn.mcmod.corn_delight.worldgen.WildCornGeneration;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = CornDelight.MODID)
public class CornCommonEvent {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        Biome.ClimateSettings climate = event.getClimate();
        if (climate.temperature > 0.0F && climate.temperature <= 1.0F) {
            if (CornDelightConfig.GENERATE_WILD_CORN.get()) {
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WildCornGeneration.PATCH_WILD_CORN.getHolder().get());  
            }
        }
    }
}
