package cn.mcmod.corn_delight;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import java.util.function.Supplier;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod.corn_delight.item.ComposterRegistry;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.item.ItemFoodBase;
import cn.mcmod_mmf.mmlib.utils.VillagerUtils;

@Mod(CornDelight.MODID)
public class CornDelight {
    public static final String MODID = "corn_delight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CornDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CornDelightConfig.COMMON_CONFIG);
        BlockRegistry.BLOCKS.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(this::registerFuel);
        CornDelightCreativeGroup.CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ComposterRegistry.registerCompost();
            addFoodToVillage(ItemRegistry.CORN, 1);
        });
    }
    
    private void addFoodToVillage(Supplier<ItemFoodBase> corn, int i) {
		VillagerUtils.addFoodToVillage(corn.get(), i);
	}

	private void registerFuel(FurnaceFuelBurnTimeEvent event) {
    	if(event.getItemStack().is(ItemRegistry.CORNCOB.get()))
    		event.setBurnTime(100);
    }

    public static Item.Properties defaultItemProperties() {
        return new Item.Properties();
    }
    
    public static Logger getLogger() {
        return LOGGER;
    }

}
