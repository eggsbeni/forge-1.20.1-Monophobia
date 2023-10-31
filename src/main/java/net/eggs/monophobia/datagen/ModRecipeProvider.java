package net.eggs.monophobia.datagen;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.datagen.custom.InfuserRecipeBuilder;
import net.eggs.monophobia.items.Moditems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> OPAQUE_SMELTABLES = List.of(Moditems.RAWOPAQUE.get(),
            ModBlocks.OPAQUE_ORE.get());

    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);

    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OPAQUE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .unlockedBy("has_opaque_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVASIVE_ROCK_STAIRS.get())
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.INVASIVE_ROCK.get())
                .unlockedBy("has_Invasive_Rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.INVASIVE_ROCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVASIVE_ROCK_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("AAA")
                .define('A', ModBlocks.INVASIVE_ROCK.get())
                .unlockedBy("has_Invasive_Rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.INVASIVE_ROCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVASIVE_ROCK_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("AA ")
                .define('A', ModBlocks.INVASIVE_ROCK.get())
                .unlockedBy("has_Invasive_Rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.INVASIVE_ROCK.get()).build()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVASIVE_ROCK_WALL.get())
                .pattern("   ")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.INVASIVE_ROCK.get())
                .unlockedBy("has_Invasive_Rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.INVASIVE_ROCK.get()).build()))
                .save(pWriter);

        //OPAQUE SET

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Moditems.OPAQUE_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_Opaque_Ore", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Moditems.OPAQUE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_Opaque_Ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Moditems.OPAQUE_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_Opaque_Ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Moditems.OPAQUE_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_Opaque_Ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Moditems.OPAQUE_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_Opaque_Ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.OPAQUE_ORE.get()).build()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Moditems.OPAQUE_BOW.get())
                .pattern(" AB")
                .pattern("A B")
                .pattern(" AB")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .define('B', Items.STRING)
                .unlockedBy("has_Opaque_Ore", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Moditems.OPAQUE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .unlockedBy("has_Opaque_Ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Moditems.OPAQUE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .unlockedBy("has_Opaque_Ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Moditems.OPAQUE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .unlockedBy("has_Opaque_Ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Moditems.OPAQUE_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', Moditems.OPAQUE_INGOT.get())
                .unlockedBy("has_Opaque_Ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Moditems.OPAQUE_INGOT.get()).build()))
                .save(pWriter);



        //SHAPELESS


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Moditems.OPAQUE_INGOT.get(), 9)
                .requires(ModBlocks.OPAQUE_BLOCK.get())
                .unlockedBy("has_opaque_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.OPAQUE_BLOCK.get()).build()))
                        .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.INVASIVE_ROCK.get(), 1)
                .requires(ModBlocks.INVASIVE_ROCK_BUTTON.get())
                .unlockedBy("has_opaque_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.INVASIVE_ROCK.get()).build()))
                .save(pWriter);


        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, Moditems.RAWOPAQUE.get(), RecipeCategory.MISC, ModBlocks.OPAQUE_ORE.get(),
                "monophobia:rawopaque", "opaque_ingot","monophobia:opaque_ore", "opaque_ingot");
        oreSmelting(pWriter, OPAQUE_SMELTABLES, RecipeCategory.MISC, Moditems.OPAQUE_INGOT.get(), 0.25f, 200, "opaque_ingot");
        oreBlasting(pWriter, OPAQUE_SMELTABLES, RecipeCategory.MISC, Moditems.OPAQUE_INGOT.get(), 0.25f, 100, "opaque_ingot");


        new InfuserRecipeBuilder(Moditems.CRYSTAL_GROWTH_SHARD.get(), Moditems.OPAQUE_BOW.get(), 1)
                .unlockedBy("has_crystal_growth_shard", has(Moditems.CRYSTAL_GROWTH_SHARD.get())).save(pWriter);

        new InfuserRecipeBuilder(Items.DIAMOND, Moditems.CRYSTAL_GROWTH_SHARD.get(), 1)
                .unlockedBy("has_crystal_growth_shard", has(Moditems.CRYSTAL_GROWTH_SHARD.get())).save(pWriter);
    }



    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                     float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Monophobiamod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

}
