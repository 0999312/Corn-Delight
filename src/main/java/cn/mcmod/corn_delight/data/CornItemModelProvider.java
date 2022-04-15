package cn.mcmod.corn_delight.data;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CornItemModelProvider extends AbstractItemModelProvider {

    public CornItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CornDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ItemRegistry.ITEMS.getEntries().forEach((item) -> {
            if(item != ItemRegistry.CORN_CRATE && item != ItemRegistry.CORN_KERNAL_BAG && item != ItemRegistry.WILD_CORN
                    && item != ItemRegistry.POPCORN_BOX)
                normalItem(item);
        });
        itemBlock(BlockRegistry.CORN_CRATE);
        itemBlock(BlockRegistry.CORN_KERNAL_BAG);
    }

}
