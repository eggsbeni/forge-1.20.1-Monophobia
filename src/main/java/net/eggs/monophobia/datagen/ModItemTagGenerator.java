package net.eggs.monophobia.datagen;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.items.Moditems;
import net.eggs.monophobia.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, Monophobiamod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Add Item Tags Here
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(Moditems.OPAQUE_HELMET.get(),
                  Moditems.OPAQUE_CHESTPLATE.get(),
                  Moditems.OPAQUE_LEGGINGS.get(),
                  Moditems.OPAQUE_BOOTS.get());

        this.tag(ModTags.Items.BOSS_ITEMS)
                .add(Moditems.DESOLATE_SHIELD.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.INVASIVE_LOG.get().asItem())
                .add(ModBlocks.INVASIVE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_INVASIVE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_INVASIVE_LOG.get().asItem());
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.INVASIVE_PLANKS.get().asItem());
    }


    @Override
    public String getName() {
        return "Item Tags";
    }
}
