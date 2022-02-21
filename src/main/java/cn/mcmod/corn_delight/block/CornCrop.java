package cn.mcmod.corn_delight.block;

import java.util.function.Supplier;

import cn.mcmod_mmf.mmlib.block.HighCropBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class CornCrop extends HighCropBlock {

    public CornCrop(Properties proper, Supplier<? extends IItemProvider> seed) {
        super(proper, seed);
    }
    
    private static final VoxelShape[] UPPER_SHAPE_BY_AGE = new VoxelShape[] { 
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), 
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), 
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), 
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D) 
    };
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.getValue(HighCropBlock.UPPER)? UPPER_SHAPE_BY_AGE[state.getValue(this.getAgeProperty())]: super.getShape(state, worldIn, pos, context);
    }
    @Override
    public int getGrowUpperAge() {
        return 4;
    }
}
