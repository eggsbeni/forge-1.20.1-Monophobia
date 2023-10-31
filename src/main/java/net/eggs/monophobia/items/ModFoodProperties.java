package net.eggs.monophobia.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CORRUPTEDFRUIT = new FoodProperties.Builder().nutrition(6).saturationMod(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1), 1f).build();

    public static final FoodProperties HERBAL_PURITY = new FoodProperties.Builder().nutrition(8).saturationMod(5f).build();

}
