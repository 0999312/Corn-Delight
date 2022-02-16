package cn.mcmod.corn_delight.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeClient()) {
            generator.addProvider(new CornBlockStateProvider(generator, existingFileHelper));
            generator.addProvider(new CornItemModelProvider(generator, existingFileHelper));
            generator.addProvider(new CornLanguageProvider(generator));
        }
        if (event.includeServer()) {
            CornBlockTagsProvider block_tag = new CornBlockTagsProvider(generator, existingFileHelper);
            generator.addProvider(block_tag);
            generator.addProvider(new CornItemTagsProvider(generator, block_tag, existingFileHelper));
            generator.addProvider(new CornLootTableProvider(generator));
            generator.addProvider(new CornRecipeProvider(generator));
        }
    }
}
