package net.eggs.monophobia.datagen;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.items.Moditems;
import net.eggs.monophobia.util.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {

        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(Moditems.RAWOPAQUE.get()),
                        Component.literal("Altered"), Component.literal("Find a metal tainted by the sickness."),
                        new ResourceLocation(Monophobiamod.MOD_ID, "textures/item/rawopaque.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_rawopaque", InventoryChangeTrigger.TriggerInstance.hasItems(Moditems.RAWOPAQUE.get()))
                .save(saver, new ResourceLocation(Monophobiamod.MOD_ID, "monophobia"), existingFileHelper);

        //revisit this lecture when you want to add more, mainly due to the working of the branching path thing.



    }
}