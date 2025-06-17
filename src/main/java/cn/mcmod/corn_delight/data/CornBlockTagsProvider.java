package cn.mcmod.corn_delight.data;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import cn.mcmod.corn_delight.CornDelight;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CornBlockTagsProvider extends BlockTagsProvider {

	public CornBlockTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, CornDelight.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		// TODO Auto-generated method stub

	}

}
