package cn.mcmod.corn_delight.data;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.CornDelightConfig;
import cn.mcmod.corn_delight.data.loot.CornChestLoot;
import cn.mcmod_mmf.mmlib.data.loot.modifier.AddLootTableModifier;
import cn.mcmod_mmf.mmlib.data.loot.modifier.GLMRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class CornGLMProvider extends GlobalLootModifierProvider {

    public CornGLMProvider(DataGenerator gen) {
        super(gen, CornDelight.MODID);

    }

    @Override
    protected void start() {
        this.add("village_house", GLMRegistry.ADD_LOOT_TABLE.get(), new AddLootTableModifier(new LootItemCondition[] {
                LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_PLAINS_HOUSE)
                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_DESERT_HOUSE))
                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_SAVANNA_HOUSE))
                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_SNOWY_HOUSE))
                .or(LootTableIdCondition.builder(BuiltInLootTables.VILLAGE_TAIGA_HOUSE))
                .build(),
        }, CornChestLoot.VILLAGE_HOUSE) {
            @Override
            public boolean canApplyModifier() {
                return CornDelightConfig.GENERATE_CORN_LOOT.get();
            }
        });
        this.add("shipwreck_loot", GLMRegistry.ADD_LOOT_TABLE.get(), new AddLootTableModifier(new LootItemCondition[] {
                LootTableIdCondition.builder(BuiltInLootTables.SHIPWRECK_SUPPLY).build()
        }, CornChestLoot.SHIPWRECK_SUPPLY) {
            @Override
            public boolean canApplyModifier() {
                return CornDelightConfig.GENERATE_CORN_LOOT.get();
            }
        });
    }

}
