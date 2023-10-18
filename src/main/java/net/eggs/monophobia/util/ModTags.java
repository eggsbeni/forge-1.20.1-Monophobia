package net.eggs.monophobia.util;

import net.eggs.monophobia.Monophobiamod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Monophobiamod.MOD_ID, name));


        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));


        }

    }



    public static class Blocks {
        public static final TagKey<Block> INVASIVE_BLOCKS = tag("invasive_blocks");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Monophobiamod.MOD_ID, name));


        }

        private static TagKey<Block> forgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge", name));


        }

    }

}
