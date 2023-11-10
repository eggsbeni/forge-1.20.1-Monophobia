package net.eggs.monophobia.block;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.custom.HerbalPurityCropBlock;
import net.eggs.monophobia.block.custom.Infuser;
import net.eggs.monophobia.block.custom.ModFlammableRotatedPillarBlock;
import net.eggs.monophobia.block.custom.OpaqueIlluminator;
import net.eggs.monophobia.items.Moditems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;
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

    public static final RegistryObject<Block> OPAQUE_ILLUMINATOR = registerBlock("opaque_illuminator",
            () -> new OpaqueIlluminator(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.SLIME_BLOCK)
                    .lightLevel(state -> state.getValue(OpaqueIlluminator.CLICKED) ? 12 : 0)));

    public static final RegistryObject<Block> INFUSER = registerBlock("infuser",
            () -> new Infuser(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE).noOcclusion()));

public static final RegistryObject<Block> INVASIVE_ROCK_STAIRS = registerBlock("invasive_rock_stairs",
        () -> new StairBlock(() -> ModBlocks.INVASIVE_ROCK.get().defaultBlockState(),
                BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS)));

public static final RegistryObject<Block> INVASIVE_ROCK_SLAB = registerBlock("invasive_rock_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB)));

    public static final RegistryObject<Block> INVASIVE_ROCK_PRESSURE_PLATE = registerBlock("invasive_rock_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE).sound(SoundType.STONE), BlockSetType.STONE));

    public static final RegistryObject<Block> INVASIVE_ROCK_BUTTON = registerBlock("invasive_rock_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.STONE), BlockSetType.STONE, 10, false));

    public static final RegistryObject<Block> INVASIVE_ROCK_WALL = registerBlock("invasive_rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));


    public static final RegistryObject<Block> SILENT_MOCKERY = registerBlock("silent_mockery",
            () -> new FlowerBlock(() -> MobEffects.HARM, 1, BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)));
    public static final RegistryObject<Block> POTTED_SILENT_MOCKERY = BLOCKS.register("potted_silent_mockery",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), SILENT_MOCKERY, BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH)));

    public static final RegistryObject<Block> HERBAL_PURITY = BLOCKS.register("herbal_purity",
            () -> new HerbalPurityCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));


    public static final RegistryObject<Block> INVASIVE_LOG = registerBlock("invasive_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LOG)));
    public static final RegistryObject<Block> INVASIVE_WOOD = registerBlock("invasive_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_INVASIVE_LOG = registerBlock("stripped_invasive_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_INVASIVE_WOOD = registerBlock("stripped_invasive_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final RegistryObject<Block> INVASIVE_PLANKS = registerBlock("invasive_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

            });

    public static final RegistryObject<Block> INVASIVE_LEAVES = registerBlock("invasive_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LEAVES)) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }


            });

    public static final RegistryObject<Block> INVASIVE_STAIRS = registerBlock("invasive_stairs",
            () -> new StairBlock(() -> ModBlocks.INVASIVE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> INVASIVE_SLAB = registerBlock("invasive_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));


    public static final RegistryObject<Block> INVASIVE_SAPLING = registerBlock("invasive_sapling",
            () -> new SaplingBlock(null, BlockBehaviour.Properties.copy(Blocks.DARK_OAK_SAPLING)));

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
