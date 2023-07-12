package cn.mcmod.corn_delight;

import net.minecraftforge.common.ForgeConfigSpec;

public class CornDelightConfig {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.BooleanValue GENERATE_CORN_LOOT;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("General settings").push("general");
        GENERATE_CORN_LOOT = COMMON_BUILDER.comment("Should this mod add some of its items (CORN!!!) as extra chest loot across Minecraft?")
                .define("genCornLootModifier", true);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

}