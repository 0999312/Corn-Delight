package cn.mcmod.corn_delight;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod.corn_delight.item.ItemRegistry;

@Mod(CornDelight.MODID)
public class CornDelight {
    public static final String MODID = "corn_delight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CornDelight(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, CornDelightConfig.COMMON_CONFIG);
        BlockRegistry.BLOCKS.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        CornDelightCreativeGroup.CREATIVE_MODE_TABS.register(modEventBus);
    }

    public static Item.Properties defaultItemProperties() {
        return new Item.Properties();
    }
    
    public static Logger getLogger() {
        return LOGGER;
    }

}
