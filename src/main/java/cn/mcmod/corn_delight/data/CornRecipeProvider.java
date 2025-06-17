package cn.mcmod.corn_delight.data;

import java.util.concurrent.CompletableFuture;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod_mmf.mmlib.data.AbstractRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;

public class CornRecipeProvider extends AbstractRecipeProvider {

	public CornRecipeProvider(PackOutput generator, CompletableFuture<Provider> completableFuture) {
		super(generator, CornDelight.MODID, completableFuture);
	}

	@Override
	protected void buildRecipes(RecipeOutput consumer, Provider holderLookup) {
	}
	
	
}
