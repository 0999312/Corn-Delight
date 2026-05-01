package cn.mcmod.corn_delight.item;

import org.jetbrains.annotations.Nullable;

import cn.mcmod.corn_delight.compat.curios.CobpipeCapProvider;
import cn.mcmod.corn_delight.compat.curios.CuriosCompat;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

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

	@Override
	public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		if (!stack.isEmpty()) {
			if (CuriosCompat.isLoaded())
				return new CobpipeCapProvider(stack);
		}
		return super.initCapabilities(stack, nbt);
	}

}
