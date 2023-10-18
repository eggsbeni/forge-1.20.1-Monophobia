package net.eggs.monophobia.block;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.items.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Monophobiamod.MOD_ID);





public static final RegistryObject<Block> INVASIVE_BRICK = registerBlock("invasive_brick",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
public static final RegistryObject<Block> INVASIVE_ROCK = registerBlock("invasive_rock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
public static final RegistryObject<Block> SOLIDIFIED_INVASIVE_ROCK = registerBlock("solidified_invasive_rock",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
public static final RegistryObject<Block> OPAQUE_BLOCK = registerBlock("opaque_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
public static final RegistryObject<Block> OPAQUE_ORE = registerBlock("opaque_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE),
                UniformInt.of(2, 5)));


//NOTE TO EGG, for custom block properties, please refer to the course "adding custom blokcs at around 5:40
    //use that for when the blocks dont match with vanilla



    private static  <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
