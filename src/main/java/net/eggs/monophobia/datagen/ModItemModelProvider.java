package net.eggs.monophobia.datagen;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.items.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Monophobiamod.MOD_ID, existingFileHelper);


    }

    @Override
    protected void registerModels() {

        simpleItem(Moditems.OPAQUE_INGOT);
        simpleItem(Moditems.RAWOPAQUE);
        simpleItem(Moditems.CORRUPTEDFRUIT);
        simpleItem(Moditems.HERBAL_PURITY);
        simpleItem(Moditems.DIVINE_SCULPTURE);
        simpleItem(Moditems.CRYSTAL_GROWTH_SHARD);
        simpleItem(Moditems.HERBAL_PURITY_SEEDS);
        simpleItem(Moditems.MEMORY_ESSENCE);
        simpleItem(Moditems.DESOLATE_PLATING);


         //simpleItem(Moditems.OPAQUE_HELMET);
        //simpleItem(Moditems.OPAQUE_CHESTPLATE);
       //simpleItem(Moditems.OPAQUE_LEGGINGS);
        // simpleItem(Moditems.OPAQUE_BOOTS);

        buttonItem(ModBlocks.INVASIVE_ROCK_BUTTON, ModBlocks.INVASIVE_ROCK);
        wallItem(ModBlocks.INVASIVE_ROCK_WALL, ModBlocks.INVASIVE_ROCK);

        handheldItem(Moditems.OPAQUE_SWORD);
        handheldItem(Moditems.OPAQUE_PICKAXE);
        handheldItem(Moditems.OPAQUE_AXE);
        handheldItem(Moditems.OPAQUE_SHOVEL);
        handheldItem(Moditems.OPAQUE_HOE);

        handheldItem(Moditems.DESOLATE_SLAMMER);

        simpleBlockItem(ModBlocks.SILENT_MOCKERY);

        complexBlock(ModBlocks.INFUSER.get());

        saplingItem(ModBlocks.INVASIVE_SAPLING);





    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Monophobiamod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(Monophobiamod.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(Monophobiamod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));



    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Monophobiamod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Monophobiamod.MOD_ID, "item/" + item.getId().getPath()));

    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Monophobiamod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Monophobiamod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Monophobiamod.MOD_ID,"item/" + item.getId().getPath()));
    }


}


