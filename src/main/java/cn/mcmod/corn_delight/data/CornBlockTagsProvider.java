package cn.mcmod.corn_delight.data;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.block.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

public class CornBlockTagsProvider extends BlockTagsProvider {

    public CornBlockTagsProvider(DataGenerator p_126511_, ExistingFileHelper existingFileHelper) {
        super(p_126511_, CornDelight.MODID, existingFileHelper);
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void addTags() {
        tag(net.minecraft.tags.BlockTags.CROPS).add(
                BlockRegistry.CORN_CROP.get());
        tag(net.minecraft.tags.BlockTags.SMALL_FLOWERS).add(
                BlockRegistry.WILD_CORN.get());
        tag(ModTags.WILD_CROPS).add(
                BlockRegistry.WILD_CORN.get());
    }
}
