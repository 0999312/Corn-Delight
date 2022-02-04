package cn.mcmod.corn_delight.data.loot;

import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.data.loot.AbstartctBlockLoot;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class CornBlockLoot extends AbstartctBlockLoot {

    @Override
    public void addTables() {
        LootItemCondition.Builder corn_builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(BlockRegistry.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        this.add(BlockRegistry.CORN_CROP.get(), 
                createCropDrops(BlockRegistry.CORN_CROP.get(), 
                        ItemRegistry.CORN.get(),
                        ItemRegistry.CORN_SEEDS.get(), 
                        corn_builder));
        dropSelf(BlockRegistry.CORN_CRATE.get());
    }

}
