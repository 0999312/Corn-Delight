package cn.mcmod.corn_delight.compat.curios;

import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class CuriosCompat {
	@OnlyIn(Dist.CLIENT)
	public static void initClient() {
		CuriosRendererRegistry.register(ItemRegistry.COB_PIPE.get(), CobpipeRenderer::new);
	}
	
	public static boolean isLoaded() {
		return ModList.get().isLoaded("curios");
	}
}
