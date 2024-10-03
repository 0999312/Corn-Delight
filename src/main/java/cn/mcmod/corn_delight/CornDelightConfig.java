package cn.mcmod.corn_delight;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CornDelightConfig {
    public static ModConfigSpec COMMON_CONFIG;
    public static ModConfigSpec.BooleanValue GENERATE_CORN_LOOT;
    public static ModConfigSpec.BooleanValue VILLAGER_TRADE_CORN;
    static {
    	ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
        COMMON_BUILDER.comment("General settings").push("general");
        GENERATE_CORN_LOOT = COMMON_BUILDER
                .comment("Should this mod add some of its items (CORN!!!) as extra chest loot across Minecraft?")
                .define("genCornLootModifier", true);
        
        VILLAGER_TRADE_CORN = COMMON_BUILDER
                .comment("Should Novice and Apprentice Farmers trade this mod's crops? (May reduce chances of other trades appearing)")
                .define("villagersTradeCorn", true);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

}