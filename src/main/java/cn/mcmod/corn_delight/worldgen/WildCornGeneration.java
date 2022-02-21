package cn.mcmod.corn_delight.worldgen;

import com.google.common.collect.ImmutableSet;

import cn.mcmod.corn_delight.CornDelightConfig;
import cn.mcmod.corn_delight.block.BlockRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class WildCornGeneration {
    
    public static final BlockClusterFeatureConfig CORN_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockRegistry.WILD_CORN.get().defaultBlockState()), new SimpleBlockPlacer())).tries(64).xspread(2).zspread(2).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).noProjection().build();
    
    
    public static final ConfiguredFeature<?, ?> PATCH_WILD_CORN = Feature.RANDOM_PATCH.configured(CORN_PATCH_CONFIG)
            .decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).chance(CornDelightConfig.CHANCE_WILD_CORN.get());
    
    public static void registerGeneration() {
        register("patch_wild_corn", PATCH_WILD_CORN);
    }
    
    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
