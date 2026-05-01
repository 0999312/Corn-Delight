package cn.mcmod.corn_delight.compat.curios;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class CobpipeCuriosWrapper implements ICurio {
    private final ItemStack stack;

    public CobpipeCuriosWrapper(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public void curioTick(SlotContext slotContext) {
        ICurio.super.curioTick(slotContext);
    }

    @Override
    public boolean canEquip(SlotContext slotContext) {
    	return slotContext.identifier().equals("head");
    }
    
    @Override
    public boolean canEquipFromUse(SlotContext slotContext) {
    	var helmet = !slotContext.entity().getItemBySlot(EquipmentSlot.HEAD).isEmpty();
    	return slotContext.identifier().equals("head") && helmet;
    }

    @Override
    public SoundInfo getEquipSound(SlotContext slotContext) {
        return new SoundInfo(SoundEvents.GRASS_PLACE, 1.0f, 1.0f);
    }

    @Override
    public ItemStack getStack() {
        return stack;
    }

}
