package cn.mcmod.corn_delight.client;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.block.BlockRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = CornDelight.MODID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void clientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WILD_CORN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CORN_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.POPCORN_BOX.get(), RenderType.cutout());
        });
    }
}
