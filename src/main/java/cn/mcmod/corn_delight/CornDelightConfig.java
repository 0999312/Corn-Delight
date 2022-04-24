package cn.mcmod.corn_delight;

import net.minecraftforge.common.ForgeConfigSpec;

public class CornDelightConfig {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.BooleanValue GENERATE_CORN_LOOT;
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_CORN;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_CORN;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("General settings").push("general");
        GENERATE_CORN_LOOT = COMMON_BUILDER.comment("Should this mod add some of its items (CORN!!!) as extra chest loot across Minecraft?")
                .define("genCornLootModifier", true);
        GENERATE_WILD_CORN = COMMON_BUILDER.comment("Generate wild corn on cold biomes (temperature between 0.0 and 1.0)")
                .define("genWildCorn", true);
        CHANCE_WILD_CORN = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 30, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

}