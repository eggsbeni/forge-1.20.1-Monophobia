package net.eggs.monophobia.datagen;

import net.eggs.monophobia.Monophobiamod;

import net.eggs.monophobia.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import net.eggs.monophobia.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Monophobiamod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.INVASIVE_BLOCKS)
                .add(ModBlocks.INVASIVE_ROCK.get(), ModBlocks.INVASIVE_BRICK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.OPAQUE_BLOCK.get())
                .add(ModBlocks.OPAQUE_ORE.get())
                .add(ModBlocks.INVASIVE_ROCK.get())
                .add(ModBlocks.INVASIVE_BRICK.get())
                .add(ModBlocks.SOLIDIFIED_INVASIVE_ROCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.MINEABLE_WITH_HOE);




        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.OPAQUE_ORE.get(),
                        ModBlocks.OPAQUE_BLOCK.get());










    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
