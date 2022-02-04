package cn.mcmod.corn_delight.data;

import java.util.function.Consumer;
import java.util.stream.Stream;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.CornForgeTags;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class CornRecipeProvider extends AbstractRecipeProvider {

    public CornRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CornForgeTags.CROPS_CORN),
                Ingredient.of(ForgeTags.TOOLS_KNIVES), ItemRegistry.CORN_SEEDS.get(), 2)
                .addResult(ModItems.STRAW.get())
                .build(consumer);
        
        foodSmeltingRecipes("popcorn", ItemRegistry.CORN_SEEDS.get(), ItemRegistry.POPCORN.get(), 0.5F, consumer);
        foodSmeltingRecipes("cornbread", ItemRegistry.CORNBREAD_BATTER.get(), ItemRegistry.CORNBREAD.get(), 0.5F, consumer);
        foodSmeltingRecipes("tortilla", ItemRegistry.RAW_TORTILLA.get(), ItemRegistry.TORTILLA.get(), 0.5F, consumer);
        
        ShapelessRecipeBuilder.shapeless(ItemRegistry.CORN_SEEDS.get(), 1)
        .requires(CornForgeTags.CROPS_CORN)
        .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORN.get()))
        .save(consumer);
        
        ShapelessRecipeBuilder.shapeless(ItemRegistry.CORNBREAD_BATTER.get(), 3)
            .requires(CornForgeTags.CROPS_CORN)
            .requires(CornForgeTags.CROPS_CORN)
            .requires(ForgeTags.MILK)
            .requires(ForgeTags.EGGS)
            .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORN.get()))
            .save(consumer);
        
        ShapelessRecipeBuilder.shapeless(ItemRegistry.TACO.get(), 1)
        .requires(CornForgeTags.TORTILLA)
        .requires(ForgeTags.SALAD_INGREDIENTS)
        .requires(ForgeTags.CROPS_ONION)
        .requires(Ingredient.fromValues(Stream.of(
                new Ingredient.TagValue(ForgeTags.COOKED_CHICKEN),
                new Ingredient.TagValue(ForgeTags.COOKED_PORK),
                new Ingredient.TagValue(ForgeTags.COOKED_BEEF),
                new Ingredient.TagValue(ForgeTags.COOKED_MUTTON)
        )))
        .unlockedBy("has_tortilla", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.TORTILLA.get()))
        .save(consumer);
        
        ShapedRecipeBuilder.shaped(ItemRegistry.RAW_TORTILLA.get(), 3)
        .pattern("www")
        .pattern(" b ")
        .define('w', CornForgeTags.CROPS_CORN)
        .define('b', Items.WATER_BUCKET)
        .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORN.get()))
        .save(consumer);
        
        ShapedRecipeBuilder.shaped(ItemRegistry.CORN_CRATE.get(), 1)
        .pattern("www")
        .pattern("www")
        .pattern("www")
        .define('w', CornForgeTags.CROPS_CORN)
        .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORN.get()))
        .save(consumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.CORN.get(), 9)
        .requires(ItemRegistry.CORN_CRATE.get())
        .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORN.get()))
        .save(consumer,"corn_from_crate");
        ShapedRecipeBuilder.shaped(ItemRegistry.CORN_KERNAL_BAG.get(), 1)
        .pattern("www")
        .pattern("www")
        .pattern("www")
        .define('w', CornForgeTags.SEEDS_CORN)
        .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORN.get()))
        .save(consumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.CORN_SEEDS.get(), 9)
        .requires(ItemRegistry.CORN_KERNAL_BAG.get())
        .unlockedBy("has_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORN.get()))
        .save(consumer,"corn_seeds_from_bag");
         
        CookingPotRecipeBuilder.cookingPotRecipe(ItemRegistry.CREAMED_CORN.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
            .addIngredient(CornForgeTags.SEEDS_CORN)
            .addIngredient(CornForgeTags.SEEDS_CORN)
            .addIngredient(ForgeTags.MILK)
            .build(consumer);
        
        CookingPotRecipeBuilder.cookingPotRecipe(ItemRegistry.CREAMY_CORN_DRINK.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
        .addIngredient(CornForgeTags.CROPS_CORN)
        .addIngredient(ForgeTags.MILK)
        .addIngredient(Items.SUGAR)
        .build(consumer);
        
        CookingPotRecipeBuilder.cookingPotRecipe(ItemRegistry.CORN_SOUP.get(), 1, CookingRecipes.NORMAL_COOKING, 0.35F)
        .addIngredient(CornForgeTags.CROPS_CORN)
        .addIngredient(ForgeTags.SALAD_INGREDIENTS)
        .addIngredient(Ingredient.fromValues(Stream.of(
                new Ingredient.TagValue(ForgeTags.RAW_CHICKEN),
                new Ingredient.TagValue(ForgeTags.RAW_PORK),
                new Ingredient.TagValue(ForgeTags.RAW_BEEF),
                new Ingredient.ItemValue(new ItemStack(Items.BROWN_MUSHROOM))
        )))
        .addIngredient(ForgeTags.MILK)
        .build(consumer);
        
    }
    
    private void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
        String namePrefix = new ResourceLocation(CornDelight.MODID, name).toString();
        smeltingRecipe(result, ingredient, experience).save(consumer);
        campfireRecipe(result, ingredient, experience).save(consumer, namePrefix + "_from_campfire_cooking");
        smokingRecipe(result, ingredient, experience).save(consumer, namePrefix + "_from_smoking");
    }
}
