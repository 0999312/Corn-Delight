package cn.mcmod.corn_delight.item;

import java.util.function.Supplier;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod_mmf.mmlib.item.ItemDrinkBase;
import cn.mcmod_mmf.mmlib.item.ItemFoodBase;
import cn.mcmod_mmf.mmlib.item.ItemFoodSeeds;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CornDelight.MODID);
   
    public static final RegistryObject<Item> WILD_CORN = ITEMS.register("wild_corn",
            () -> new BlockItem(BlockRegistry.WILD_CORN.get(), CornDelight.defaultItemProperties()));
    
    public static final RegistryObject<Item> CORN_CRATE = ITEMS.register("corn_crate",
            () -> new BlockItem(BlockRegistry.CORN_CRATE.get(), CornDelight.defaultItemProperties()));
    
    public static final RegistryObject<Item> CORN_KERNAL_BAG = ITEMS.register("corn_kernel_bag",
            () -> new BlockItem(BlockRegistry.CORN_KERNAL_BAG.get(), CornDelight.defaultItemProperties()));
    
    public static final RegistryObject<Item> NACHOS_BLOCK = ITEMS.register("nachos_block",
            () -> new BlockItem(BlockRegistry.NACHOS_BLOCK.get(), CornDelight.defaultItemProperties()));
    
    public static final RegistryObject<Item> POPCORN_BOX = ITEMS.register("popcorn_box",
            () -> new BlockItem(BlockRegistry.POPCORN_BOX.get(), CornDelight.defaultItemProperties()));
    
    public static final RegistryObject<ItemFoodBase> CORN = register("corn", ()->food(
            FoodInfo.builder().name("corn")
            .amountAndCalories(2, 0.2F).water(5F)
            .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodSeeds> CORN_SEEDS = register("corn_seeds", 
            ()->seed(BlockRegistry.CORN_CROP.get(),
                FoodInfo.builder().name("corn_seeds")
                .amountAndCalories(1, 0.2F).water(5F)
                .nutrients(1F, 0F, 1F, 0F, 0F).decayModifier(2F)
                .heatCapacity(1F).cookingTemp(480F)
                .build())
    );
    
    public static final RegistryObject<ItemFoodBase> GRILLED_CORN = register("grilled_corn", ()->food(
            FoodInfo.builder().name("grilled_corn")
            .amountAndCalories(6, 0.2F).water(0F)
            .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> BOILED_CORN = register("boiled_corn", ()->food(
            FoodInfo.builder().name("boiled_corn")
            .amountAndCalories(6, 0.2F).water(5F)
            .nutrients(2F, 0F, 2F, 0F, 0F).decayModifier(2F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> POPCORN = register("popcorn", ()->food(
            FoodInfo.builder().name("popcorn")
            .amountAndCalories(3, 0.5F).water(0F)
            .nutrients(1F, 0F, 0F, 0F, 0F).decayModifier(0.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> CARAMEL_POPCORN = register("caramel_popcorn", ()->food(
            FoodInfo.builder().name("caramel_popcorn")
            .amountAndCalories(5, 0.6F).water(0F)
            .nutrients(3F, 0F, 0F, 0F, 0F).decayModifier(0.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> CREAMED_CORN = register("creamed_corn", ()->food(
            FoodInfo.builder().name("creamed_corn")
            .amountAndCalories(7, 0.5F).water(25F)
            .nutrients(2F, 0F, 2F, 0F, 4F).decayModifier(5F)
            .heatCapacity(1F).cookingTemp(480F)
            .addEffect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F)
            .build(), Items.BOWL)
    );
    
    public static final RegistryObject<ItemFoodBase> CORN_SOUP = register("corn_soup", ()->food(
            FoodInfo.builder().name("corn_soup")
            .amountAndCalories(10, 0.9F).water(40F)
            .nutrients(2F, 0F, 2F, 0F, 4F).decayModifier(5F)
            .heatCapacity(1F).cookingTemp(480F)
            .addEffect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F)
            .build(), Items.BOWL)
    );
    
    public static final RegistryObject<ItemFoodBase> CREAMY_CORN_DRINK = register("creamy_corn_drink", ()->drink(
            FoodInfo.builder().name("creamy_corn_drink")
            .amountAndCalories(2, 0.6F).water(40F)
            .nutrients(2F, 0F, 2F, 0F, 4F).decayModifier(5F)
            .heatCapacity(1F).cookingTemp(480F)
            .addEffect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), FoodValues.SHORT_DURATION, 0), 1.0F)
            .addEffect(() -> new MobEffectInstance(MobEffects.REGENERATION, FoodValues.SHORT_DURATION, 0), 1.0F)
            .build(), Items.GLASS_BOTTLE)
    );
    
    public static final RegistryObject<ItemFoodBase> CORNBREAD_BATTER = register("cornbread_batter", ()->food(
            FoodInfo.builder().name("cornbread_batter")
            .amountAndCalories(1, 0.2F).water(0F)
            .nutrients(2F, 0F, 2F, 0F, 4F).decayModifier(2.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> CORNBREAD = register("cornbread", ()->food(
            FoodInfo.builder().name("cornbread")
            .amountAndCalories(4, 0.5F).water(0F)
            .nutrients(2F, 0F, 2F, 0F, 4F).decayModifier(1F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> CORN_DOG = register("corn_dog", ()->food(
            FoodInfo.builder().name("corn_dog")
            .amountAndCalories(8, 0.9F).water(0F)
            .nutrients(4F, 0F, 4F, 4F, 4F).decayModifier(1F)
            .heatCapacity(1F).cookingTemp(480F)
            .build(), Items.STICK)
    );
    
    public static final RegistryObject<ItemFoodBase> CLASSIC_CORN_DOG = register("classic_corn_dog", ()->food(
            FoodInfo.builder().name("classic_corn_dog")
            .amountAndCalories(10, 0.9F).water(0F)
            .nutrients(4F, 0F, 5F, 4F, 4F).decayModifier(1F)
            .heatCapacity(1F).cookingTemp(480F)
            .build(), Items.STICK)
    );
    
    public static final RegistryObject<ItemFoodBase> RAW_TORTILLA = register("tortilla_raw", ()->food(
            FoodInfo.builder().name("tortilla_raw")
            .amountAndCalories(1, 0.2F).water(0F)
            .nutrients(2F, 0F, 2F, 0F, 4F).decayModifier(2.5F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> TORTILLA = register("tortilla", ()->food(
            FoodInfo.builder().name("tortilla")
            .amountAndCalories(3, 0.4F).water(0F)
            .nutrients(2F, 0F, 0F, 0F, 0F).decayModifier(1F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> TACO = register("taco", ()->food(
            FoodInfo.builder().name("taco")
            .amountAndCalories(12, 0.8F).water(0F)
            .nutrients(4F, 0F, 4F, 4F, 4F).decayModifier(1F)
            .heatCapacity(1F).cookingTemp(480F)
            .addEffect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, FoodValues.BRIEF_DURATION, 0), 1.0F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> CORNBREAD_STUFFING = register("cornbread_stuffing", ()->food(
            FoodInfo.builder().name("cornbread_stuffing")
            .amountAndCalories(12, 1F).water(0F)
            .nutrients(4F, 0F, 4F, 4F, 4F).decayModifier(1F)
            .heatCapacity(1F).cookingTemp(480F)
            .addEffect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F)
            .build(), Items.BOWL)
    );
    
    public static final RegistryObject<ItemFoodBase> TORTILLA_CHIP = register("tortilla_chip", ()->food(
            FoodInfo.builder().name("tortilla_chip")
            .amountAndCalories(1, 0.1F).water(0F)
            .nutrients(2F, 0F, 0F, 0F, 0F).decayModifier(1F)
            .heatCapacity(1F).cookingTemp(480F)
            .build())
    );
    
    public static final RegistryObject<ItemFoodBase> NACHOS = register("nachos_bowl", ()->food(
            FoodInfo.builder().name("nachos_bowl")
            .amountAndCalories(12, 1F).water(0F)
            .nutrients(4F, 0F, 4F, 4F, 4F).decayModifier(1F)
            .heatCapacity(1F).cookingTemp(480F)
            .addEffect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F)
            .build(), Items.BOWL)
    );
    
    private static ItemFoodBase food(FoodInfo info) {
        return new ItemFoodBase(CornDelight.defaultItemProperties(), info);
    }
    
    private static ItemFoodBase food(FoodInfo info, Item container) {
        return new ItemFoodBase(CornDelight.defaultItemProperties().craftRemainder(container).stacksTo(16), info);
    }
    
    private static ItemDrinkBase drink(FoodInfo info, Item container) {
        return new ItemDrinkBase(CornDelight.defaultItemProperties().craftRemainder(container).stacksTo(16), info);
    }

    private static ItemFoodSeeds seed(Block block, FoodInfo info) {
        return new ItemFoodSeeds(block, CornDelight.defaultItemProperties(), info);
    }

    private static <V extends Item> RegistryObject<V> register(String name, Supplier<V> item) {
        return ITEMS.register(name, item);
    }
}
