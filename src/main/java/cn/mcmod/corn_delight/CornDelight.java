package cn.mcmod.corn_delight;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vectorwing.farmersdelight.FarmersDelight;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod.corn_delight.item.ComposterRegistry;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod.corn_delight.worldgen.WildCornGeneration;

@Mod(CornDelight.MODID)
public class CornDelight {
    public static final String MODID = "corn_delight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CornDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        BlockRegistry.BLOCKS.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        WildCornGeneration.FEATURES.register(modEventBus);
        WildCornGeneration.PATCHES.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CornDelightConfig.COMMON_CONFIG);
    }
    
    private void setup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ComposterRegistry.registerCompost();
        });
    }
    
    public static Item.Properties defaultItemProperties() {
        return new Item.Properties().tab(FarmersDelight.CREATIVE_TAB);
    }

    public static Logger getLogger() {
        return LOGGER;
    }

}
