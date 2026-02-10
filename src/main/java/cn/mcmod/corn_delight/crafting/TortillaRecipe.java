package cn.mcmod.corn_delight.crafting;

import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;

public class TortillaRecipe extends CustomRecipe {
    public TortillaRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput container, Level level) {
        ItemStack cornStack = ItemStack.EMPTY;
        ItemStack waterStack = ItemStack.EMPTY;

        for (int index = 0; index < container.size(); ++index) {
            ItemStack selectedStack = container.getItem(index);
            if (!selectedStack.isEmpty()) {
                if (selectedStack.is(ItemRegistry.CORN)) {
                    if (!cornStack.isEmpty()) return false;
                    cornStack = selectedStack;
                } else {
                    if (!selectedStack.is(Tags.Items.BUCKETS_WATER)) {
                        return false;
                    }
                    waterStack = selectedStack;
                }
            }
        }

        return !cornStack.isEmpty() && !waterStack.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingInput container, HolderLookup.Provider registryAccess) {
        return new ItemStack(ItemRegistry.RAW_TORTILLA.get());
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput container) {
        NonNullList<ItemStack> remainders = NonNullList.withSize(container.size(), ItemStack.EMPTY);

        for (int index = 0; index < remainders.size(); ++index) {
            ItemStack selectedStack = container.getItem(index);
            if (selectedStack.is(Tags.Items.BUCKETS_WATER)) {
                remainders.set(index, selectedStack.copy());
            }
        }

        return remainders;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 2 && height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializerRegistry.TORTILLA.get();
    }
}