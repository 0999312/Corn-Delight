package cn.mcmod.corn_delight;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vectorwing.farmersdelight.FarmersDelight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod.corn_delight.item.ComposterRegistry;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod.corn_delight.worldgen.WildCornGeneration;

@Mod(CornDelight.MODID)
public class CornDelight {
    public static final String MODID = "corn_delight";
    private static final Logger LOGGER = LogManager.getLogger();

    public CornDelight() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CornDelightConfig.COMMON_CONFIG);
    }
    
    private void setup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            WildCornGeneration.registerGeneration();
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
