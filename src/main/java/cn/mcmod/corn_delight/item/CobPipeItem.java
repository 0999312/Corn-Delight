package cn.mcmod.corn_delight.item;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CobPipeItem extends Item implements Equipable {

	public CobPipeItem(Properties properties) {
		super(properties);
	}

	@Override
	public EquipmentSlot getEquipmentSlot() {
		return EquipmentSlot.HEAD;
	}
	
	@Override
	public Holder<SoundEvent> getEquipSound() {
		return Holder.direct(SoundEvents.GRASS_PLACE);
	}
	
	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlot armorType, LivingEntity entity) {
		// TODO Auto-generated method stub
		return super.canEquip(stack, armorType, entity);
	}

}
