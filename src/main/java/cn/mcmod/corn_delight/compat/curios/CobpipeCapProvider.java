package cn.mcmod.corn_delight.compat.curios;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class CobpipeCapProvider implements ICapabilityProvider{

    private final ItemStack stack;
    private final ICurio capInstance;

    public CobpipeCapProvider(ItemStack stack) {
        this.stack = stack;
        this.capInstance = new CobpipeCuriosWrapper(stack);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == CuriosCapability.ITEM)
            return LazyOptional.of(this::getCuriosInstance).cast();
        return LazyOptional.empty();
    }

    public ItemStack getItemStack() {
        return stack;
    }

    public ICurio getCuriosInstance() {
        return capInstance;
    }

}
