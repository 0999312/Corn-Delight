package cn.mcmod.corn_delight.data;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import cn.mcmod.corn_delight.data.loot.CornBlockLoot;
import cn.mcmod.corn_delight.data.loot.CornChestLoot;
import cn.mcmod_mmf.mmlib.data.AbstractLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class CornLootTableProvider extends AbstractLootTableProvider {

    public CornLootTableProvider(DataGenerator gen) {
        super(gen);
    }

    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>>
        tables = ImmutableList.of(
                Pair.of(CornBlockLoot::new, LootContextParamSets.BLOCK),
                Pair.of(CornChestLoot::new, LootContextParamSets.CHEST)
        );
    
    @Override
    public String getName() {
        return "Corn Delight Loot Table";
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
        return tables;
    }

}
