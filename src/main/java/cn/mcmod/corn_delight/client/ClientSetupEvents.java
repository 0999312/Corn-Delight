package cn.mcmod.corn_delight.client;

import java.util.Map;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.client.model.MultiModelBakedModel;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, modid = CornDelight.MODID, value = Dist.CLIENT)
public class ClientSetupEvents {
	
	@SubscribeEvent
	public static void onBakedModel(ModelEvent.BakingCompleted event) {
		ModelResourceLocation cob_pipe = new ModelResourceLocation(ItemRegistry.COB_PIPE.getId(), "inventory");
		ModelResourceLocation cob_pipe_model = new ModelResourceLocation(CornDelight.MODID, "cob_pipe_model", "inventory");
		Map<ResourceLocation, BakedModel> bakedTopLevelModels = event.getModelBakery().getBakedTopLevelModels();
		bakedTopLevelModels.put(cob_pipe,
				new MultiModelBakedModel(bakedTopLevelModels.get(cob_pipe), bakedTopLevelModels.get(cob_pipe_model)));
	}
	@SubscribeEvent
    public static void registerModels(ModelEvent.RegisterAdditional event) {

		event.register(new ModelResourceLocation(CornDelight.MODID, "cob_pipe_model", "inventory"));
	}
}
