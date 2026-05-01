package cn.mcmod.corn_delight.item;

import cn.mcmod_mmf.mmlib.item.ItemFoodBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.Configuration;

public class FDFoodItem extends ItemFoodBase {

	public FDFoodItem(Item.Properties prop, FoodInfo info) {
		super(prop, info);
	}

	@Override
	public boolean shouldAddEffectTooltips() {
		return Configuration.ENABLE_FOOD_EFFECT_TOOLTIP.get();
	}

}
