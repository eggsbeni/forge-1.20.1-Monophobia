package net.eggs.monophobia.items;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.items.custom.DesolateSlammer;
import net.eggs.monophobia.items.custom.FuelItem;
import net.minecraft.world.item.*;
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
    public static final RegistryObject<Item> DIVINE_SCULPTURE = ITEMS.register("divine_sculpture",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRYSTAL_GROWTH_SHARD= ITEMS.register("crystal_growth_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CORRUPTEDFRUIT = ITEMS.register("corruptedfruit",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CORRUPTEDFRUIT)));

    public static final RegistryObject<Item> HERBAL_PURITY = ITEMS.register("herbal_purity",
            () -> new Item(new Item.Properties().food(ModFoodProperties.HERBAL_PURITY)));

    public static final RegistryObject<Item> MEMORY_ESSENCE = ITEMS.register("memory_essence",
            () -> new FuelItem(new Item.Properties(), 1000));

    public static final RegistryObject<Item> OPAQUE_SWORD = ITEMS.register("opaque_sword",
            () -> new SwordItem(ModToolTiers.OPAQUE, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> OPAQUE_PICKAXE = ITEMS.register("opaque_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OPAQUE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> OPAQUE_AXE = ITEMS.register("opaque_axe",
            () -> new AxeItem(ModToolTiers.OPAQUE,6.5F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> OPAQUE_SHOVEL = ITEMS.register("opaque_shovel",
            () -> new ShovelItem(ModToolTiers.OPAQUE,1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> OPAQUE_HOE = ITEMS.register("opaque_hoe",
            () -> new HoeItem(ModToolTiers.OPAQUE,-2, -1.0F, new Item.Properties()));

    public static final RegistryObject<Item> OPAQUE_BOW = ITEMS.register("opaque_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> DESOLATE_SHIELD = ITEMS.register("desolate_shield",
            () -> new ShieldItem(new Item.Properties().durability(1200)));

    // revisit custom items and particles lectures to add particles to the shield and make it do things

    public static final RegistryObject<Item> DESOLATE_PLATING = ITEMS.register("desolate_plating",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OPAQUE_HELMET = ITEMS.register("opaque_helmet",
            () -> new ArmorItem(ModArmorMaterials.OPAQUE,ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OPAQUE_CHESTPLATE = ITEMS.register("opaque_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OPAQUE,ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OPAQUE_LEGGINGS = ITEMS.register("opaque_leggings",
            () -> new ArmorItem(ModArmorMaterials.OPAQUE,ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OPAQUE_BOOTS = ITEMS.register("opaque_boots",
            () -> new ArmorItem(ModArmorMaterials.OPAQUE,ArmorItem.Type.BOOTS, new Item.Properties()));


    public static final RegistryObject<Item> DESOLATE_SLAMMER = ITEMS.register("desolate_slammer",
            () -> new DesolateSlammer(ModToolTiers.OPAQUE, 6, -3.4F, new Item.Properties()));

    public static final RegistryObject<Item> CONSUMED_STAFF = ITEMS.register("consumed_staff",
            () -> new Item(new Item.Properties().durability(1024)));


    public static final RegistryObject<Item> HERBAL_PURITY_SEEDS = ITEMS.register("herbal_purity_seeds",
            () -> new ItemNameBlockItem(ModBlocks.HERBAL_PURITY.get(), new Item.Properties()));
    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);

    }


}
