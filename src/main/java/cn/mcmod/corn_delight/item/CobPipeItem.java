package cn.mcmod.corn_delight.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;

public class CobPipeItem extends Item implements Equipable {

	public CobPipeItem(Properties properties) {
		super(properties);
	}

	@Override
	public EquipmentSlot getEquipmentSlot() {
		return EquipmentSlot.HEAD;
	}
	
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.GRASS_PLACE;
	}
	

}
