package net.eggs.monophobia.datagen.loot;

import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.items.Moditems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());

    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.OPAQUE_BLOCK.get());
        this.dropSelf(ModBlocks.INVASIVE_BRICK.get());
        this.dropSelf(ModBlocks.INVASIVE_ROCK.get());
        this.dropSelf(ModBlocks.SOLIDIFIED_INVASIVE_ROCK.get());

        this.add(ModBlocks.OPAQUE_ORE.get(),
                block -> createOreDrop(ModBlocks.OPAQUE_ORE.get(), Moditems.RAWOPAQUE.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
