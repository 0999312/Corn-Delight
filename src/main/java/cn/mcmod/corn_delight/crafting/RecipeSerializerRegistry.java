package cn.mcmod.corn_delight.crafting;

import cn.mcmod.corn_delight.CornDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipeSerializerRegistry {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, CornDelight.MODID);

    public static final Supplier<SimpleCraftingRecipeSerializer<?>> TORTILLA =
            RECIPE_SERIALIZERS.register("tortilla", () -> new SimpleCraftingRecipeSerializer<>(TortillaRecipe::new));
}