package cn.mcmod.corn_delight.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DataGen {
	@SubscribeEvent
	public static void dataGen(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(event.includeServer(), new DataMaps(output, lookupProvider));
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		
		CornBlockTagsProvider blockTagProvider = new CornBlockTagsProvider(output, lookupProvider, existingFileHelper);
		generator.addProvider(event.includeServer(), blockTagProvider);
		generator.addProvider(event.includeServer(), new CornItemTagsProvider(output, lookupProvider,
				blockTagProvider.contentsGetter(), existingFileHelper));
		
	}

}
