package net.eggs.monophobia.recipe;

import net.eggs.monophobia.Monophobiamod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Monophobiamod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<InfuserRecipe>> INFUSER_SERIALIZER =
            SERIALIZERS.register("infusing", () -> InfuserRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}