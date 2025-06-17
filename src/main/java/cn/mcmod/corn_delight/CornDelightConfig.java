package cn.mcmod.corn_delight;

import net.minecraftforge.common.ForgeConfigSpec;

public class CornDelightConfig {

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.BooleanValue VILLAGER_TRADE_CORN;
    public static ForgeConfigSpec.BooleanValue GENERATE_CORN_FARM;
    static {
    	ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("General settings").push("general");
        
        GENERATE_CORN_FARM = COMMON_BUILDER
                .comment("Should this mod add corn farm to plains and taiga village?")
                .define("genCornFarm", true);
        
        VILLAGER_TRADE_CORN = COMMON_BUILDER
                .comment("Should Novice and Apprentice Farmers trade this mod's crops? (May reduce chances of other trades appearing)")
                .define("villagersTradeCorn", true);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}