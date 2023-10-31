package net.eggs.monophobia.potion;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, Monophobiamod.MOD_ID);

    public static final RegistryObject<Potion> INVASIVE_CONSCIOUS_STAGE_1_SIMULANT = POTIONS.register("invasive_conscious_stage_1_simulant",
            () -> new Potion(new MobEffectInstance(ModEffects.INVASIVE_CONSCIOUS.get(), 600, 0)));

    public static final RegistryObject<Potion> INVASIVE_CONSCIOUS_STAGE_2_SIMULANT = POTIONS.register("invasive_conscious_stage_2_simulant",
            () -> new Potion(new MobEffectInstance(ModEffects.INVASIVE_CONSCIOUS_STAGE_2.get(), 600, 0)));

    public static final RegistryObject<Potion> INVASIVE_CONSCIOUS_STAGE_3_SIMULANT = POTIONS.register("invasive_conscious_stage_3_simulant",
            () -> new Potion(new MobEffectInstance(ModEffects.INVASIVE_CONSCIOUS_STAGE_3.get(), 600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}