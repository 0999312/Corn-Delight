package cn.mcmod.corn_delight.data.loot;

import java.util.function.BiConsumer;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class CornChestLoot extends ChestLoot {
    public static final ResourceLocation VILLAGE_HOUSE = new ResourceLocation(CornDelight.MODID, "village_house");
    public static final ResourceLocation SHIPWRECK_SUPPLY = new ResourceLocation(CornDelight.MODID, "shipwreck_supply");
    @Override
    public void accept(BiConsumer<ResourceLocation, Builder> consumer) {
        consumer.accept(VILLAGE_HOUSE,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0F, 5.0F))
                .add(LootItem.lootTableItem(ItemRegistry.CORN_SEEDS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                .add(LootItem.lootTableItem(ItemRegistry.CORN.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
        ));
        consumer.accept(SHIPWRECK_SUPPLY,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 4.0F))
                .add(LootItem.lootTableItem(ItemRegistry.CORN_SEEDS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                .add(LootItem.lootTableItem(ItemRegistry.CORN.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
        ));
    }
    
}
