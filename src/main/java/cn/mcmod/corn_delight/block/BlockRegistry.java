package cn.mcmod.corn_delight.block;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CornDelight.MODID);
    
    @SuppressWarnings("deprecation")
	public static final DeferredBlock<CornCrop> CORN_CROP = BLOCKS.register("corn_crop", 
            () -> new CornCrop(Block.Properties.ofLegacyCopy(Blocks.WHEAT), ItemRegistry.CORN_SEEDS));
    
    @SuppressWarnings("deprecation")
	public static final DeferredBlock<WildCropBlock> WILD_CORN = BLOCKS.register("wild_corn",
            () -> new WildCropBlock(MobEffects.SATURATION, 8,Block.Properties.ofLegacyCopy(Blocks.TALL_GRASS)));
    
    @SuppressWarnings("deprecation")
	public static final DeferredBlock<Block> CORN_CRATE = BLOCKS.register("corn_crate",
            () -> new Block(Block.Properties.ofLegacyCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    @SuppressWarnings("deprecation")
	public static final DeferredBlock<Block> CORN_KERNAL_BAG = BLOCKS.register("corn_kernel_bag",
            () -> new Block(Block.Properties.ofLegacyCopy(Blocks.WHITE_WOOL)));
    
    @SuppressWarnings("deprecation")
	public static final DeferredBlock<NachosBlock> NACHOS_BLOCK = BLOCKS.register("nachos_block",
            () -> new NachosBlock(Block.Properties.ofLegacyCopy(Blocks.CAKE), ItemRegistry.NACHOS::get, true));
    
    public static final DeferredBlock<PopcornBoxBlock> POPCORN_BOX = BLOCKS.register("popcorn_box",
            PopcornBoxBlock::new);
}
