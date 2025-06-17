package cn.mcmod.corn_delight.data;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CornItemTagsProvider extends ItemTagsProvider {

	public CornItemTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
			CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags, CornDelight.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(ItemTags.CHICKEN_FOOD)
				.add(ItemRegistry.CORN.get())
				.add(ItemRegistry.CORNCOB.get())
				.add(ItemRegistry.CORN_SEEDS.get());
		
		this.tag(ItemTags.PIG_FOOD)
				.add(ItemRegistry.CORN.get())
				.add(ItemRegistry.CORNCOB.get())
				.add(ItemRegistry.CORN_SEEDS.get());
		
		this.tag(ItemTags.COW_FOOD)
				.add(ItemRegistry.CORN.get())
				.add(ItemRegistry.CORNCOB.get())
				.add(ItemRegistry.CORN_SEEDS.get());
		
		this.tag(ItemTags.SHEEP_FOOD)
				.add(ItemRegistry.CORN.get())
				.add(ItemRegistry.CORNCOB.get())
				.add(ItemRegistry.CORN_SEEDS.get());
		
		this.tag(ItemTags.GOAT_FOOD)
				.add(ItemRegistry.CORN.get())
				.add(ItemRegistry.CORNCOB.get())
				.add(ItemRegistry.CORN_SEEDS.get());
		
		this.tag(ItemTags.HORSE_FOOD)
				.add(ItemRegistry.CORN.get())
				.add(ItemRegistry.CORNCOB.get())
				.add(ItemRegistry.CORN_SEEDS.get());
		
		this.tag(ItemTags.PARROT_FOOD)
				.add(ItemRegistry.CORN.get())
				.add(ItemRegistry.CORNCOB.get())
				.add(ItemRegistry.CORN_SEEDS.get());
	}

}
