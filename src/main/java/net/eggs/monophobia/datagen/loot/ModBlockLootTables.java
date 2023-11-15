package net.eggs.monophobia.datagen.loot;

import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.block.custom.HerbalPurityCropBlock;
import net.eggs.monophobia.items.Moditems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());

    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.OPAQUE_BLOCK.get());
        this.dropSelf(ModBlocks.INVASIVE_BRICK.get());
        this.dropSelf(ModBlocks.INVASIVE_ROCK.get());
        this.dropSelf(ModBlocks.SOLIDIFIED_INVASIVE_ROCK.get());
        this.dropSelf(ModBlocks.OPAQUE_ILLUMINATOR.get());

        this.dropSelf(ModBlocks.INFUSER.get());

        this.add(ModBlocks.OPAQUE_ORE.get(),
                block -> createOreDrop(ModBlocks.OPAQUE_ORE.get(), Moditems.RAWOPAQUE.get()));

        this.dropSelf(ModBlocks.INVASIVE_ROCK_STAIRS.get());
        this.add(ModBlocks.INVASIVE_ROCK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INVASIVE_ROCK_SLAB.get()));
        this.dropSelf(ModBlocks.INVASIVE_ROCK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.INVASIVE_ROCK_BUTTON.get());
        this.dropSelf(ModBlocks.INVASIVE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.INVASIVE_BUTTON.get());
        this.dropSelf(ModBlocks.INVASIVE_ROCK_WALL.get());

        this.dropSelf(ModBlocks.SILENT_MOCKERY.get());
        this.add(ModBlocks.POTTED_SILENT_MOCKERY.get(),
                createPotFlowerItemTable(ModBlocks.SILENT_MOCKERY.get()));

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.HERBAL_PURITY.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HerbalPurityCropBlock.AGE, 6));
        this.add(ModBlocks.HERBAL_PURITY.get(), this.createCropDrops(ModBlocks.HERBAL_PURITY.get(), Moditems.HERBAL_PURITY.get(), Moditems.HERBAL_PURITY_SEEDS.get(), lootitemcondition$builder1));


        this.dropSelf(ModBlocks.INVASIVE_LOG.get());
        this.dropSelf(ModBlocks.INVASIVE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_INVASIVE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_INVASIVE_WOOD.get());
        this.dropSelf(ModBlocks.INVASIVE_PLANKS.get());
        this.dropSelf(ModBlocks.INVASIVE_FENCE.get());
        this.dropSelf(ModBlocks.INVASIVE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.INVASIVE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.INVASIVE_SAPLING.get());

        this.add(ModBlocks.INVASIVE_DOOR.get(),
                block -> createDoorTable(ModBlocks.INVASIVE_DOOR.get()));

        this.dropSelf(ModBlocks.INVASIVE_STAIRS.get());
        this.add(ModBlocks.INVASIVE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INVASIVE_SLAB.get()));

        this.add(ModBlocks.INVASIVE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.INVASIVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }
        @Override
        protected Iterable<Block> getKnownBlocks () {
            return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
        }
    }

