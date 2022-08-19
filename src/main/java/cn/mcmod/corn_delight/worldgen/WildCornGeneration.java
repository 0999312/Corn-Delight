package cn.mcmod.corn_delight.worldgen;

import java.util.function.Supplier;

import com.google.common.collect.Lists;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.CornDelightConfig;
import cn.mcmod.corn_delight.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.world.WildCropGeneration;

public class WildCornGeneration {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister
            .create(BuiltinRegistries.CONFIGURED_FEATURE.key(), CornDelight.MODID);
    public static final DeferredRegister<PlacedFeature> PATCHES = DeferredRegister
            .create(BuiltinRegistries.PLACED_FEATURE.key(), CornDelight.MODID);
    public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);

    public static RegistryObject<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_CORN = FEATURES.register("patch_wild_corn",
            () -> wildCropFeature(BlockRegistry.WILD_CORN, BlockTags.DIRT));
    public static RegistryObject<PlacedFeature> PATCH_WILD_CORN = PATCHES.register("patch_wild_corn",
            () -> wildCropPatch(FEATURE_PATCH_WILD_CORN,
                    RarityFilter.onAverageOnceEvery(CornDelightConfig.CHANCE_WILD_CORN.get()),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    

    private static ConfiguredFeature<?, ?> wildCropFeature(Supplier<Block> wildCrop, TagKey<Block> blockTag) {
        return new ConfiguredFeature<>(Feature.RANDOM_PATCH, WildCropGeneration.getWildCropConfiguration(wildCrop.get(),
                64, 4, BlockPredicate.matchesTag(blockTag, BLOCK_BELOW)));
    }
    private static PlacedFeature wildCropPatch(RegistryObject<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers) {
        return new PlacedFeature(feature.getHolder().get(), Lists.newArrayList(modifiers));
    }
}
