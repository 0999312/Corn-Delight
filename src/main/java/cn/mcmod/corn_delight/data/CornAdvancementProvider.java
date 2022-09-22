package cn.mcmod.corn_delight.data;

import java.util.function.Consumer;
import org.slf4j.Logger;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import cn.mcmod_mmf.mmlib.data.advancement.AbstractAdvancementProvider;
import cn.mcmod_mmf.mmlib.data.advancement.AbstractAdvancements;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModItems;

public class CornAdvancementProvider extends AbstractAdvancementProvider {

    public CornAdvancementProvider(DataGenerator gen, ExistingFileHelper fileHelperIn) {
        super(gen, fileHelperIn);
    }

    @Override
    public Consumer<Consumer<Advancement>>[] getAdvancementTabs() {
        return new AbstractAdvancements[] {new CornAdvancements()};
    }

    @Override
    public Logger getLogger() {
        return CornDelight.getLogger();
    }

    public static class CornAdvancements extends AbstractAdvancements {
        @Override
        public void accept(Consumer<Advancement> comsumer) {
            Advancement kernal = findItem(Advancement.Builder.advancement().display(
                    ItemRegistry.CORN_SEEDS.get().getDefaultInstance(),
                    new TranslatableComponent(ItemRegistry.CORN.getId().getNamespace() + ".advancement.root"),
                    new TranslatableComponent(ItemRegistry.CORN.getId().getNamespace() + ".advancement.root.desc"),
                    new ResourceLocation("minecraft:textures/block/bricks.png"), FrameType.TASK, true, false, false),
                    ItemRegistry.CORN_SEEDS.get().getDefaultInstance()).save(comsumer, "corn_delight:root");
            
            Advancement corn = findItem(getAdvancement(kernal, ItemRegistry.CORN.get().getDefaultInstance(), "corn",
                    FrameType.TASK, true, false, false), ItemRegistry.CORN.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:corn");
            
            Advancement tortilla = findItem(getAdvancement(corn, ItemRegistry.TORTILLA.get().getDefaultInstance(), "tortilla",
                    FrameType.TASK, true, false, false), ItemRegistry.TORTILLA.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:tortilla");
            
            Advancement cornbread = findItem(getAdvancement(corn, ItemRegistry.CORNBREAD.get().getDefaultInstance(), "cornbread",
                    FrameType.TASK, true, false, false), ItemRegistry.CORNBREAD.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:cornbread");
            
            Advancement corndog = findItem(getAdvancement(corn, ItemRegistry.CORN_DOG.get().getDefaultInstance(), "corndog",
                    FrameType.TASK, true, false, false), ItemRegistry.CORN_DOG.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:corndog");
            
            Advancement popcorn = findItem(getAdvancement(corn, ItemRegistry.POPCORN.get().getDefaultInstance(), "popcorn",
                    FrameType.TASK, true, false, false), ItemRegistry.POPCORN.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:popcorn");
            
            findItem(getAdvancement(corndog, ItemRegistry.CLASSIC_CORN_DOG.get().getDefaultInstance(), "classic_corndog",
                    FrameType.TASK, true, false, false), ItemRegistry.CLASSIC_CORN_DOG.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:classic_corndog");
            
            findItem(getAdvancement(popcorn, ItemRegistry.POPCORN_BOX.get().getDefaultInstance(), "popcorn_party",
                    FrameType.GOAL, true, true, false), ItemRegistry.POPCORN_BOX.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:popcorn_party");
            
            findItem(getAdvancement(tortilla, ItemRegistry.TACO.get().getDefaultInstance(), "taco",
                    FrameType.GOAL, true, false, false), ItemRegistry.TACO.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:taco");
            
            findItem(getAdvancement(tortilla, ItemRegistry.NACHOS.get().getDefaultInstance(), "nachos",
                    FrameType.GOAL, true, true, false), ItemRegistry.NACHOS_BLOCK.get().getDefaultInstance())
                    .save(comsumer, "corn_delight:nachos");
            
            getAdvancement(cornbread, ItemRegistry.CORNBREAD_STUFFING.get().getDefaultInstance(), "stuffing_chef",
                    FrameType.GOAL, true, true, false)
                    .addCriterion("cornbread_stuffing", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORNBREAD_STUFFING.get()))
                    .addCriterion("pumpkin_stuffing", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.STUFFED_PUMPKIN_BLOCK.get()))
                    .save(comsumer, "corn_delight:stuffing_chef");
            
            getAdvancement(corn, ItemRegistry.CORN_CRATE.get().getDefaultInstance(), "corn_knowleage",
                    FrameType.CHALLENGE, true, true, false)
                    .addCriterion("classic_corndog", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CLASSIC_CORN_DOG.get()))
                    .addCriterion("taco", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.TACO.get()))
                    .addCriterion("nachos", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.NACHOS.get()))
                    .addCriterion("corn_soup", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORN_SOUP.get()))
                    .addCriterion("creamed_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CREAMED_CORN.get()))
                    .addCriterion("boiled_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.BOILED_CORN.get()))
                    .addCriterion("grilled_corn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.GRILLED_CORN.get()))
                    .addCriterion("corn_drink", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CREAMY_CORN_DRINK.get()))
                    .addCriterion("popcorn", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CARAMEL_POPCORN.get()))
                    .addCriterion("cornbread", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORNBREAD.get()))
                    .addCriterion("cornbread_stuffing", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CORNBREAD_STUFFING.get()))
                    .save(comsumer, "corn_delight:corn_knowleage");
        }
    }
}
