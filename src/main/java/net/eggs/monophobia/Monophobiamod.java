package net.eggs.monophobia;

import com.mojang.logging.LogUtils;
import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.block.entity.ModBlockEntities;
import net.eggs.monophobia.effect.ModEffects;
import net.eggs.monophobia.enchantment.ModEnchantments;
import net.eggs.monophobia.items.ModCreativeModeTabs;
import net.eggs.monophobia.items.ModItemProperties;
import net.eggs.monophobia.items.Moditems;
import net.eggs.monophobia.loot.ModLootModifiers;
import net.eggs.monophobia.painting.ModPaintings;
import net.eggs.monophobia.particle.ModParticles;
import net.eggs.monophobia.potion.BetterBrewingRecipe;
import net.eggs.monophobia.potion.ModPotions;
import net.eggs.monophobia.recipe.ModRecipes;
import net.eggs.monophobia.screen.InfuserScreen;
import net.eggs.monophobia.screen.ModMenuTypes;
import net.eggs.monophobia.villager.ModVillagers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Monophobiamod.MOD_ID)
public class Monophobiamod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "monophobia";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Monophobiamod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        Moditems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEnchantments.register(modEventBus);

        ModPaintings.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModParticles.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(Moditems.HERBAL_PURITY.get(), 0.80f);
            ComposterBlock.COMPOSTABLES.put(Moditems.HERBAL_PURITY_SEEDS.get(), 0.20f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SILENT_MOCKERY.getId(), ModBlocks.POTTED_SILENT_MOCKERY);

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Moditems.RAWOPAQUE.get(), ModPotions.INVASIVE_CONSCIOUS_STAGE_1_SIMULANT.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Moditems.OPAQUE_INGOT.get(), ModPotions.INVASIVE_CONSCIOUS_STAGE_1_SIMULANT.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Moditems.MEMORY_ESSENCE.get(), ModPotions.INVASIVE_CONSCIOUS_STAGE_1_SIMULANT.get()));

        });

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(Moditems.RAWOPAQUE);
            event.accept(Moditems.OPAQUE_INGOT);
            event.accept(Moditems.MEMORY_ESSENCE);
            event.accept(Moditems.DIVINE_SCULPTURE);
            event.accept(Moditems.CRYSTAL_GROWTH_SHARD);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.INVASIVE_ROCK);
            event.accept(ModBlocks.INVASIVE_BRICK);
            event.accept(ModBlocks.OPAQUE_BLOCK);
            event.accept(ModBlocks.OPAQUE_ORE);
            event.accept(ModBlocks.SOLIDIFIED_INVASIVE_ROCK);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {

            event.accept(Moditems.OPAQUE_SWORD);
            event.accept(Moditems.OPAQUE_AXE);
            event.accept(Moditems.DESOLATE_SLAMMER);

            event.accept(Moditems.OPAQUE_HELMET.get());
            event.accept(Moditems.OPAQUE_CHESTPLATE.get());
            event.accept(Moditems.OPAQUE_LEGGINGS.get());
            event.accept(Moditems.OPAQUE_BOOTS.get());

        }

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

            event.accept(Moditems.OPAQUE_PICKAXE);
            event.accept(Moditems.OPAQUE_AXE);
            event.accept(Moditems.OPAQUE_SHOVEL);
            event.accept(Moditems.OPAQUE_HOE);


        }


    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            event.enqueueWork(() -> {
                ModItemProperties.addCustomItemProperties();

                MenuScreens.register(ModMenuTypes.INFUSER_MENU.get(), InfuserScreen::new);

            });
        }
    }
}
