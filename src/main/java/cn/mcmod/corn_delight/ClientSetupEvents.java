package cn.mcmod.corn_delight;

import java.util.Map;

import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.client.model.MultiModelBakedModel;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.client.event.ModelEvent;

@EventBusSubscriber(bus = Bus.MOD, modid = CornDelight.MODID, value = Dist.CLIENT)
public class ClientSetupEvents {
	
	@SubscribeEvent
	public static void onBakedModel(ModelEvent.BakingCompleted event) {
		ModelResourceLocation cob_pipe = ModelResourceLocation
				.inventory(ItemRegistry.COB_PIPE.getId());
		ModelResourceLocation cob_pipe_model = ModelResourceLocation
				.standalone(ResourceLocation.fromNamespaceAndPath(CornDelight.MODID, "item/cob_pipe_model"));
		Map<ModelResourceLocation, BakedModel> bakedTopLevelModels = event.getModelBakery().getBakedTopLevelModels();
		bakedTopLevelModels.put(cob_pipe,
				new MultiModelBakedModel(bakedTopLevelModels.get(cob_pipe), bakedTopLevelModels.get(cob_pipe_model)));
	}
	@SubscribeEvent
    public static void registerModels(ModelEvent.RegisterAdditional event) {
		event.register(ModelResourceLocation
				.standalone(ResourceLocation.fromNamespaceAndPath(CornDelight.MODID, "item/cob_pipe_model")));
	}
}
