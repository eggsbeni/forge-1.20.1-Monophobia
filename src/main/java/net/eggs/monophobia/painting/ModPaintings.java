package net.eggs.monophobia.painting;

import net.eggs.monophobia.Monophobiamod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Monophobiamod.MOD_ID);

    public static final RegistryObject<PaintingVariant> RESPITE = PAINTING_VARIANTS.register("respite",
            () -> new PaintingVariant(64, 64));



    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);



        }

    }

