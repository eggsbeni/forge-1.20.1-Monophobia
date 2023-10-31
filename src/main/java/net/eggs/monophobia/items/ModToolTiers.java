package net.eggs.monophobia.items;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier OPAQUE = TierSortingRegistry.registerTier(
    new ForgeTier(2,600,6.0f,2.5f,18,
            ModTags.Blocks.NEEDS_OPAQUE_TOOL, () -> Ingredient.of(Moditems.OPAQUE_INGOT.get())),
            new ResourceLocation(Monophobiamod.MOD_ID, "opaque"), List.of(Tiers.IRON), List.of());

}
