package net.eggs.monophobia.datagen;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.block.custom.HerbalPurityCropBlock;
import net.eggs.monophobia.block.custom.OpaqueIlluminator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Monophobiamod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.OPAQUE_BLOCK);
        blockWithItem(ModBlocks.OPAQUE_ORE);

        blockWithItem(ModBlocks.INVASIVE_BRICK);
        blockWithItem(ModBlocks.INVASIVE_ROCK);
        blockWithItem(ModBlocks.SOLIDIFIED_INVASIVE_ROCK);

        blockWithItem(ModBlocks.INVASIVE_PLANKS);

        stairsBlock((StairBlock) ModBlocks.INVASIVE_ROCK_STAIRS.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()));
        slabBlock((SlabBlock) ModBlocks.INVASIVE_ROCK_SLAB.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()), blockTexture(ModBlocks.INVASIVE_ROCK.get()));

        stairsBlock((StairBlock) ModBlocks.INVASIVE_STAIRS.get(), blockTexture(ModBlocks.INVASIVE_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.INVASIVE_SLAB.get(), blockTexture(ModBlocks.INVASIVE_PLANKS.get()), blockTexture(ModBlocks.INVASIVE_PLANKS.get()));

        buttonBlock((ButtonBlock) ModBlocks.INVASIVE_ROCK_BUTTON.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.INVASIVE_ROCK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()));
        buttonBlock((ButtonBlock) ModBlocks.INVASIVE_BUTTON.get(), blockTexture(ModBlocks.INVASIVE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.INVASIVE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.INVASIVE_PLANKS.get()));
        wallBlock((WallBlock) ModBlocks.INVASIVE_ROCK_WALL.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()));

        fenceBlock((FenceBlock) ModBlocks.INVASIVE_FENCE.get(), blockTexture(ModBlocks.INVASIVE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.INVASIVE_FENCE_GATE.get(), blockTexture(ModBlocks.INVASIVE_PLANKS.get()));

        doorBlockWithRenderType((DoorBlock)ModBlocks.INVASIVE_DOOR.get(), modLoc("block/invasive_door_bottom"), modLoc("block/invasive_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.INVASIVE_TRAPDOOR.get(), modLoc("block/invasive_trapdoor"), true, "cutout");

        blockItem(ModBlocks.INVASIVE_ROCK_STAIRS);
        blockItem(ModBlocks.INVASIVE_ROCK_SLAB);
        blockItem(ModBlocks.INVASIVE_ROCK_PRESSURE_PLATE);
        blockItem(ModBlocks.INVASIVE_FENCE_GATE);

        blockItem(ModBlocks.INVASIVE_PRESSURE_PLATE);
        blockItem(ModBlocks.INVASIVE_STAIRS);
        blockItem(ModBlocks.INVASIVE_SLAB);
        blockItem(ModBlocks.INVASIVE_TRAPDOOR, "_bottom");

        customLamp();

        makeCrop(((HerbalPurityCropBlock) ModBlocks.HERBAL_PURITY.get()), "herbal_purity_stage", "herbal_purity_stage");

        simpleBlock(ModBlocks.SILENT_MOCKERY.get(),
                models().cross(blockTexture(ModBlocks.SILENT_MOCKERY.get()).getPath(), blockTexture(ModBlocks.SILENT_MOCKERY.get())).renderType("cutout"));

        horizontalBlock(ModBlocks.INFUSER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/infuser")));

        logBlock(((RotatedPillarBlock) ModBlocks.INVASIVE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.INVASIVE_WOOD.get()), blockTexture(ModBlocks.INVASIVE_LOG.get()), blockTexture(ModBlocks.INVASIVE_LOG.get()));

        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_INVASIVE_LOG.get(), new ResourceLocation(Monophobiamod.MOD_ID, "block/stripped_invasive_log"),
                new ResourceLocation(Monophobiamod.MOD_ID, "block/stripped_invasive_log_top"));

        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_INVASIVE_WOOD.get(), new ResourceLocation(Monophobiamod.MOD_ID, "block/stripped_invasive_log"),
                new ResourceLocation(Monophobiamod.MOD_ID, "block/stripped_invasive_log"));

        blockItem(ModBlocks.INVASIVE_LOG);
        blockItem(ModBlocks.INVASIVE_WOOD);
        blockItem(ModBlocks.STRIPPED_INVASIVE_LOG);
        blockItem(ModBlocks.STRIPPED_INVASIVE_WOOD);



        leavesBlock(ModBlocks.INVASIVE_LEAVES);
        saplingBlock(ModBlocks.INVASIVE_SAPLING);


    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((HerbalPurityCropBlock) block).getAgeProperty()),
                new ResourceLocation(Monophobiamod.MOD_ID, "block/" + textureName + state.getValue(((HerbalPurityCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;

    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.OPAQUE_ILLUMINATOR.get()).forAllStates(state -> {
            if(state.getValue(OpaqueIlluminator.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("opaque_illuminator_on",
                        new ResourceLocation(Monophobiamod.MOD_ID, "block/" + "opaque_illuminator_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("opaque_illuminato_off",
                        new ResourceLocation(Monophobiamod.MOD_ID, "block/" +"opaque_illuminator_off")))};
            }
        });
        simpleBlockItem(ModBlocks.OPAQUE_ILLUMINATOR.get(), models().cubeAll("opaque_illuminato_on",
                new ResourceLocation(Monophobiamod.MOD_ID, "block/" +"opaque_illuminator_on")));
    }


    private void blockItem(RegistryObject<Block> blockRegistryObject) {

        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("monophobia:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));


    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
