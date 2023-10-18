package net.eggs.monophobia.datagen;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.items.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        simpleItem(Moditems.MEMORY_ESSENCE);


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Monophobiamod.MOD_ID, "item/" + item.getId().getPath()));

    }

}


