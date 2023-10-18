package net.eggs.monophobia.items;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Monophobiamod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MONOPHOBIA_TAB = CREATIVE_MODE_TABS.register("monophobia_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.RAWOPAQUE.get()))

            .title(Component.translatable("creative.monophobia_tab")).displayItems((displayParameters, output) -> {

                output.accept(Moditems.RAWOPAQUE.get());
                output.accept(Moditems.OPAQUE_INGOT.get());
                output.accept(Moditems.CORRUPTEDFRUIT.get());
                output.accept(Moditems.MEMORY_ESSENCE.get());


                output.accept(ModBlocks.OPAQUE_BLOCK.get());
                output.accept(ModBlocks.INVASIVE_ROCK.get());
                output.accept(ModBlocks.INVASIVE_BRICK.get());
                output.accept(ModBlocks.SOLIDIFIED_INVASIVE_ROCK.get());
                output.accept(ModBlocks.OPAQUE_ORE.get());

                }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
}
