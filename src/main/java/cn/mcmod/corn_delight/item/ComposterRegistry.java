package cn.mcmod.corn_delight.item;

import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;

public class ComposterRegistry {
    public static void registerCompost() {
        register(ItemRegistry.CORN_SEEDS, 0.35F);
        register(ItemRegistry.POPCORN, 0.5F);
        register(ItemRegistry.WILD_CORN, 0.55F);
        register(ItemRegistry.CORN, 0.65F);
        register(ItemRegistry.BOILED_CORN, 0.65F);
        register(ItemRegistry.GRILLED_CORN, 0.65F);
        register(ItemRegistry.RAW_TORTILLA, 0.75F);
        register(ItemRegistry.TORTILLA, 0.75F);
        register(ItemRegistry.CORNBREAD_BATTER, 0.85F);
        register(ItemRegistry.CORNBREAD, 0.85F);
        register(ItemRegistry.TACO, 1F);
    }
    private static void register(Supplier<? extends Item> item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.get(), chance);
    }
}
