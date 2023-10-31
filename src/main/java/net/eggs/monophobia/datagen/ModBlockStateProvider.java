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

        stairsBlock((StairBlock) ModBlocks.INVASIVE_ROCK_STAIRS.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()));
        slabBlock((SlabBlock) ModBlocks.INVASIVE_ROCK_SLAB.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()), blockTexture(ModBlocks.INVASIVE_ROCK.get()));



        buttonBlock((ButtonBlock) ModBlocks.INVASIVE_ROCK_BUTTON.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.INVASIVE_ROCK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()));
        wallBlock((WallBlock) ModBlocks.INVASIVE_ROCK_WALL.get(), blockTexture(ModBlocks.INVASIVE_ROCK.get()));

        blockItem(ModBlocks.INVASIVE_ROCK_STAIRS);
        blockItem(ModBlocks.INVASIVE_ROCK_SLAB);
        blockItem(ModBlocks.INVASIVE_ROCK_PRESSURE_PLATE);

        customLamp();

        makeCrop(((HerbalPurityCropBlock) ModBlocks.HERBAL_PURITY.get()), "herbal_purity_stage", "herbal_purity_stage");

        simpleBlock(ModBlocks.SILENT_MOCKERY.get(),
                models().cross(blockTexture(ModBlocks.SILENT_MOCKERY.get()).getPath(), blockTexture(ModBlocks.SILENT_MOCKERY.get())).renderType("cutout"));

        horizontalBlock(ModBlocks.INFUSER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/infuser")));

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
}
