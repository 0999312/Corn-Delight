package cn.mcmod.corn_delight.villager;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.CornDelightConfig;
import cn.mcmod_mmf.mmlib.level.StructuresUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = CornDelight.MODID, bus = Bus.FORGE)
public class VillageStructures {
	@SubscribeEvent
	public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
		if (!CornDelightConfig.GENERATE_CORN_FARM.get()) {
			return;
		}
		Registry<StructureTemplatePool> templatePools = event.getServer().registryAccess()
				.registry(Registries.TEMPLATE_POOL).get();
		Registry<StructureProcessorList> processorLists = event.getServer().registryAccess()
				.registry(Registries.PROCESSOR_LIST).get();

		StructuresUtils.addBuildingToPool(templatePools, processorLists, 
				ResourceLocation.tryParse("minecraft:village/plains/houses"), 
				"corn_delight:village/houses/plains_small_corn_farm", 
				3);
		StructuresUtils.addBuildingToPool(templatePools, processorLists, 
				ResourceLocation.tryParse("minecraft:village/plains/houses"), 
				"corn_delight:village/houses/plains_large_corn_farm", 
				1);
		StructuresUtils.addBuildingToPool(templatePools, processorLists, 
				ResourceLocation.tryParse("minecraft:village/taiga/houses"), 
				"corn_delight:village/houses/taiga_small_corn_farm", 
				3);
		StructuresUtils.addBuildingToPool(templatePools, processorLists, 
				ResourceLocation.tryParse("minecraft:village/taiga/houses"), 
				"corn_delight:village/houses/taiga_large_corn_farm", 
				1);
	}
}
