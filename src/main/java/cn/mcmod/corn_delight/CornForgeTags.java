package cn.mcmod.corn_delight;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class CornForgeTags {
    public static final IOptionalNamedTag<Item> CROPS_CORN = forgeItemTag("crops/corn");
    public static final IOptionalNamedTag<Item> GRAIN_CORN = forgeItemTag("grain/corn");
    public static final IOptionalNamedTag<Item> BREAD_CORN = forgeItemTag("bread/corn");
    public static final IOptionalNamedTag<Item> SEEDS_CORN = forgeItemTag("seeds/corn");
    public static final IOptionalNamedTag<Item> VEGETABLES_CORN = forgeItemTag("vegetables/corn");
    public static final IOptionalNamedTag<Item> TORTILLA = forgeItemTag("tortilla");
    public static final IOptionalNamedTag<Item> POPCORN = forgeItemTag("popcorn");
    
    private static IOptionalNamedTag<Item> forgeItemTag(String path) {
        return ItemTags.createOptional(new ResourceLocation("forge", path));
    }
    
}
