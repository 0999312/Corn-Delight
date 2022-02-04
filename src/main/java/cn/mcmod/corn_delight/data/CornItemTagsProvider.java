package cn.mcmod.corn_delight.data;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.CornForgeTags;
import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

public class CornItemTagsProvider extends ItemTagsProvider {

    public CornItemTagsProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, ExistingFileHelper existingFileHelper) {
        super(p_126530_, p_126531_, CornDelight.MODID, existingFileHelper);
    }
    
    @Override
    protected void addTags() {
        tag(ModTags.WILD_CROPS_ITEM).add(ItemRegistry.WILD_CORN.get());
        
        tag(ForgeTags.BREAD).add(ItemRegistry.CORNBREAD.get());
        tag(CornForgeTags.BREAD_CORN).add(ItemRegistry.CORNBREAD.get());
        tag(ForgeTags.CROPS).add(ItemRegistry.CORN.get());
        tag(ForgeTags.VEGETABLES).add(ItemRegistry.CORN.get());
        tag(CornForgeTags.CROPS_CORN).add(ItemRegistry.CORN.get());
        tag(CornForgeTags.GRAIN_CORN).add(ItemRegistry.CORN.get());
        tag(CornForgeTags.VEGETABLES_CORN).add(ItemRegistry.CORN.get());
        tag(ForgeTags.SEEDS).add(ItemRegistry.CORN_SEEDS.get());
        tag(CornForgeTags.SEEDS_CORN).add(ItemRegistry.CORN_SEEDS.get());
        
        tag(CornForgeTags.POPCORN).add(ItemRegistry.POPCORN.get());
        tag(CornForgeTags.TORTILLA).add(ItemRegistry.TORTILLA.get());
    }


    
}
