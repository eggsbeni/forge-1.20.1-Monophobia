package net.eggs.monophobia.items;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.eggs.monophobia.potion.ModPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
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
                output.accept(Moditems.DIVINE_SCULPTURE.get());
                output.accept(Moditems.CRYSTAL_GROWTH_SHARD.get());
                output.accept(Moditems.CORRUPTEDFRUIT.get());

                output.accept(Moditems.HERBAL_PURITY.get());
                output.accept(Moditems.HERBAL_PURITY_SEEDS.get());
                output.accept(Moditems.MEMORY_ESSENCE.get());
                output.accept(ModBlocks.SILENT_MOCKERY.get());

                output.accept(Moditems.OPAQUE_SWORD.get());
                output.accept(Moditems.OPAQUE_PICKAXE.get());
                output.accept(Moditems.OPAQUE_AXE.get());
                output.accept(Moditems.OPAQUE_SHOVEL.get());
                output.accept(Moditems.OPAQUE_HOE.get());
                output.accept(Moditems.OPAQUE_BOW.get());

                output.accept(Moditems.DESOLATE_SLAMMER.get());
                output.accept(Moditems.DESOLATE_SHIELD.get());
                output.accept(Moditems.DESOLATE_PLATING.get());
                output.accept(Moditems.CONSUMED_STAFF.get());

                output.accept(Moditems.OPAQUE_HELMET.get());
                output.accept(Moditems.OPAQUE_CHESTPLATE.get());
                output.accept(Moditems.OPAQUE_LEGGINGS.get());
                output.accept(Moditems.OPAQUE_BOOTS.get());


                output.accept(ModBlocks.OPAQUE_BLOCK.get());

                output.accept(ModBlocks.INVASIVE_ROCK.get());
                output.accept(ModBlocks.INVASIVE_BRICK.get());
                output.accept(ModBlocks.INVASIVE_ROCK_STAIRS.get());
                output.accept(ModBlocks.INVASIVE_ROCK_SLAB.get());
                output.accept(ModBlocks.INVASIVE_ROCK_PRESSURE_PLATE.get());
                output.accept(ModBlocks.INVASIVE_ROCK_BUTTON.get());
                output.accept(ModBlocks.INVASIVE_ROCK_WALL.get());
                output.accept(ModBlocks.SOLIDIFIED_INVASIVE_ROCK.get());

                output.accept(ModBlocks.INVASIVE_LOG.get());
                output.accept(ModBlocks.INVASIVE_WOOD.get());
                output.accept(ModBlocks.STRIPPED_INVASIVE_LOG.get());
                output.accept(ModBlocks.STRIPPED_INVASIVE_WOOD.get());
                output.accept(ModBlocks.INVASIVE_PLANKS.get());
                output.accept(ModBlocks.INVASIVE_STAIRS.get());
                output.accept(ModBlocks.INVASIVE_SLAB.get());
                output.accept(ModBlocks.INVASIVE_PRESSURE_PLATE.get());
                output.accept(ModBlocks.INVASIVE_BUTTON.get());
                output.accept(ModBlocks.INVASIVE_FENCE.get());
                output.accept(ModBlocks.INVASIVE_FENCE_GATE.get());
                output.accept(ModBlocks.INVASIVE_DOOR.get());
                output.accept(ModBlocks.INVASIVE_TRAPDOOR.get());
                output.accept(ModBlocks.INVASIVE_LEAVES.get());
                output.accept(ModBlocks.INVASIVE_SAPLING.get());

                output.accept(ModBlocks.OPAQUE_ORE.get());


                output.accept(ModBlocks.OPAQUE_ILLUMINATOR.get());
                output.accept(ModBlocks.INFUSER.get());

                }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
}
