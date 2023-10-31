package net.eggs.monophobia.effect;

import net.eggs.monophobia.Monophobiamod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Monophobiamod.MOD_ID);

    public static final RegistryObject<MobEffect> INVASIVE_CONSCIOUS = MOB_EFFECTS.register("invasive_conscious",
            () -> new InvasiveConscious(MobEffectCategory.NEUTRAL, 0x605052).addAttributeModifier(Attributes.MAX_HEALTH,
                    "f9d63ef4-73bb-11ee-b962-0242ac120002", -0.20, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, "99c03302-73bc-11ee-b962-0242ac120002", -0.33, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, "06425596-73bd-11ee-b962-0242ac120002", 0.20, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final RegistryObject<MobEffect> INVASIVE_CONSCIOUS_STAGE_2 = MOB_EFFECTS.register("invasive_conscious_stage_2",
            () -> new InvasiveConscious(MobEffectCategory.NEUTRAL, 0x514445).addAttributeModifier(Attributes.MAX_HEALTH,
                            "91801d94-73bf-11ee-b962-0242ac120002", -0.30, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, "91802078-73bf-11ee-b962-0242ac120002", -0.66, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, "918021c2-73bf-11ee-b962-0242ac120002", 0.40, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, "91802366-73bf-11ee-b962-0242ac120002", -0.10, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final RegistryObject<MobEffect> INVASIVE_CONSCIOUS_STAGE_3 = MOB_EFFECTS.register("invasive_conscious_stage_3",
            () -> new InvasiveConscious(MobEffectCategory.NEUTRAL, 0x282122).addAttributeModifier(Attributes.MAX_HEALTH,
                            "91802546-73bf-11ee-b962-0242ac120002", -0.35, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, "9180274e-73bf-11ee-b962-0242ac120002", -0.70, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, "91802870-73bf-11ee-b962-0242ac120002", 1, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, "9180297e-73bf-11ee-b962-0242ac120002", -0.15, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "91802aaa-73bf-11ee-b962-0242ac120002", 1, AttributeModifier.Operation.MULTIPLY_TOTAL));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);

    }
}
