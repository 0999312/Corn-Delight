package cn.mcmod.corn_delight.block;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.blocks.WildCropsBlock;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CornDelight.MODID);
    
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop", 
            () -> new CornCrop(Block.Properties.copy(Blocks.WHEAT), ItemRegistry.CORN_SEEDS));
    
    public static final RegistryObject<Block> WILD_CORN = BLOCKS.register("wild_corn",
            () -> new WildCropsBlock(Block.Properties.copy(Blocks.TALL_GRASS)));
    
    public static final RegistryObject<Block> CORN_CRATE = BLOCKS.register("corn_crate",
            () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    public static final RegistryObject<Block> CORN_KERNAL_BAG = BLOCKS.register("corn_kernel_bag",
            () -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL)));
}
