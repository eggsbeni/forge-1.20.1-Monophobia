package net.eggs.monophobia.items;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.items.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Monophobiamod.MOD_ID);

    public static final RegistryObject<Item> RAWOPAQUE = ITEMS.register("rawopaque",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OPAQUE_INGOT = ITEMS.register("opaque_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CORRUPTEDFRUIT = ITEMS.register("corruptedfruit",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CORRUPTEDFRUIT)));

    public static final RegistryObject<Item> MEMORY_ESSENCE = ITEMS.register("memory_essence",
            () -> new FuelItem(new Item.Properties(), 1000));


    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);

    }


}
