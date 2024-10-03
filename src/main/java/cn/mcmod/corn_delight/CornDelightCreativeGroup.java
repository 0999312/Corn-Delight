package cn.mcmod.corn_delight;

import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CornDelightCreativeGroup {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, CornDelight.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CORN_DELIGHT = CREATIVE_MODE_TABS.register("corn_delight",
            () -> CreativeModeTab.builder().icon(ItemRegistry.CORN.get()::getDefaultInstance)
                    .title(Component.translatable("itemGroup.corn_delight")).displayItems((features, output) -> {
                        ItemRegistry.ITEMS.getEntries().forEach(item -> {
                            output.accept(item.get());
                        });
                    }).build());

}
