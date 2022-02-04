package cn.mcmod.corn_delight.data;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CornBlockStateProvider extends AbstractBlockStateProvider {

    public CornBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CornDelight.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        crossBlock(BlockRegistry.WILD_CORN);
        stageBlock(BlockRegistry.CORN_CROP, BlockStateProperties.AGE_7);
    }

}
