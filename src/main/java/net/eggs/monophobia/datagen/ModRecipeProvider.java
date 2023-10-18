package net.eggs.monophobia.datagen;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.items.Moditems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Moditems.OPAQUE_INGOT.get(), 9)
                .requires(ModBlocks.OPAQUE_BLOCK.get())
                .unlockedBy("has_opaque_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.OPAQUE_BLOCK.get()).build()))
                        .save(pWriter);


        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, Moditems.RAWOPAQUE.get(), RecipeCategory.MISC, ModBlocks.OPAQUE_ORE.get(),
                "monophobia:rawopaque", "opaque_ingot","monophobia:opaque_ore", "opaque_ingot");
        oreSmelting(pWriter, OPAQUE_SMELTABLES, RecipeCategory.MISC, Moditems.OPAQUE_INGOT.get(), 0.25f, 200, "opaque_ingot");
        oreBlasting(pWriter, OPAQUE_SMELTABLES, RecipeCategory.MISC, Moditems.OPAQUE_INGOT.get(), 0.25f, 100, "opaque_ingot");

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
