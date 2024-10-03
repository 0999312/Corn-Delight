package cn.mcmod.corn_delight.data;

import java.util.concurrent.CompletableFuture;

import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

public class DataMaps extends DataMapProvider{
	protected DataMaps(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void gather() {
		builder(NeoForgeDataMaps.COMPOSTABLES)
		.add(ItemRegistry.CORN_SEEDS, new Compostable(0.35F), false)
		.add(ItemRegistry.POPCORN, new Compostable(0.5F), false)
		.add(ItemRegistry.WILD_CORN, new Compostable(0.55F), false)
		.add(ItemRegistry.CORN, new Compostable(0.65F), false)
		.add(ItemRegistry.BOILED_CORN, new Compostable(0.65F), false)
		.add(ItemRegistry.GRILLED_CORN, new Compostable(0.65F), false)
		.add(ItemRegistry.RAW_TORTILLA, new Compostable(0.75F), false)
		.add(ItemRegistry.TORTILLA, new Compostable(0.75F), false)
		.add(ItemRegistry.CORNBREAD_BATTER, new Compostable(0.85F), false)
		.add(ItemRegistry.CORNBREAD, new Compostable(0.85F), false)
		.add(ItemRegistry.TACO, new Compostable(1F), false)
		;
	}
}
