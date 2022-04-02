package cn.mcmod.corn_delight.data;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.block.BlockRegistry;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractLangProvider;
import net.minecraft.data.DataGenerator;

public class CornLanguageProvider extends AbstractLangProvider {

    public CornLanguageProvider(DataGenerator gen) {
        super(gen, CornDelight.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(BlockRegistry.CORN_CROP.get(), "Corn Crop");
        add(BlockRegistry.CORN_CRATE.get(), "Corn Crate");
        add(BlockRegistry.NACHOS_BLOCK.get(), "Nachos");
        add(BlockRegistry.WILD_CORN.get(), "Wild Corn");
        add(ItemRegistry.CORN.get(), "Maize");
        add(ItemRegistry.GRILLED_CORN.get(), "Grilled Corn");
        add(ItemRegistry.BOILED_CORN.get(), "Boiled Corn");
        add(ItemRegistry.CORN_SEEDS.get(), "Corn Kernel");
        add(ItemRegistry.CORN_SOUP.get(), "Corn Soup");
        add(ItemRegistry.CORNBREAD_BATTER.get(), "Cornbread Batter");
        add(ItemRegistry.CORNBREAD.get(), "Cornbread");
        add(ItemRegistry.POPCORN.get(), "Popcorn");
        add(ItemRegistry.CREAMED_CORN.get(), "Creamed Corn");
        add(ItemRegistry.CREAMY_CORN_DRINK.get(), "Creamy Corn Drink");
        add(ItemRegistry.RAW_TORTILLA.get(), "Raw Tortilla");
        add(ItemRegistry.TORTILLA.get(), "Tortilla");
        add(ItemRegistry.TACO.get(), "Taco");
        add(ItemRegistry.TORTILLA_CHIP.get(), "Tortilla Chip");
        add(ItemRegistry.NACHOS.get(), "Nachos");
    }
}
