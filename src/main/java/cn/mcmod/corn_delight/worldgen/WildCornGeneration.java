package cn.mcmod.corn_delight.worldgen;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.CornDelightConfig;
import cn.mcmod.corn_delight.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import vectorwing.farmersdelight.common.world.WildCropGeneration;

public class WildCornGeneration {
    public static ConfiguredFeature<RandomPatchConfiguration, ?> FEATURE_PATCH_WILD_CORN;

    public static PlacedFeature PATCH_WILD_CORN;
    public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);

    public static void registerGeneration() {
        FEATURE_PATCH_WILD_CORN = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(CornDelight.MODID, "patch_wild_corn"),
                Feature.RANDOM_PATCH
                        .configured(WildCropGeneration.getWildCropConfiguration(BlockRegistry.WILD_CORN.get(), 64, 4,
                                BlockPredicate.matchesBlock(Blocks.GRASS_BLOCK, BLOCK_BELOW))));
        PATCH_WILD_CORN = Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(CornDelight.MODID, "patch_wild_corn"),
                FEATURE_PATCH_WILD_CORN.placed(RarityFilter.onAverageOnceEvery(CornDelightConfig.CHANCE_WILD_CORN.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }
}
