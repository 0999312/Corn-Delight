package cn.mcmod.corn_delight.block;

import java.util.function.Supplier;

import cn.mcmod_mmf.mmlib.block.HighCropBlock;
import net.minecraft.world.level.ItemLike;

public class CornCrop extends HighCropBlock {

    public CornCrop(Properties proper, Supplier<? extends ItemLike> seed) {
        super(proper, seed);
    }
    
    @Override
    public int getGrowUpperAge() {
        return 4;
    }
}
