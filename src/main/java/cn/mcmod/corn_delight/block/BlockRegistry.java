package cn.mcmod.corn_delight.block;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CornDelight.MODID);
    
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop", 
            () -> new CornCrop(Block.Properties.copy(Blocks.WHEAT), ItemRegistry.CORN_SEEDS));
    
    public static final RegistryObject<Block> WILD_CORN = BLOCKS.register("wild_corn",
            () -> new WildCropBlock(MobEffects.SATURATION, 8,Block.Properties.copy(Blocks.TALL_GRASS)));
    
    public static final RegistryObject<Block> CORN_CRATE = BLOCKS.register("corn_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    public static final RegistryObject<Block> CORN_KERNAL_BAG = BLOCKS.register("corn_kernel_bag",
            () -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL)));
    
    public static final RegistryObject<Block> NACHOS_BLOCK = BLOCKS.register("nachos_block",
            () -> new NachosBlock(Block.Properties.copy(Blocks.CAKE), ItemRegistry.NACHOS::get, true));
    
    public static final RegistryObject<Block> POPCORN_BOX = BLOCKS.register("popcorn_box",
            PopcornBoxBlock::new);
}
