package net.eggs.monophobia.block.entity;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Monophobiamod.MOD_ID);

    public static final RegistryObject<BlockEntityType<InfuserBlockEntity>> INFUSER_BE =
        BLOCK_ENTITIES.register("infuser_block_entitiy", () ->
                BlockEntityType.Builder.of(InfuserBlockEntity::new,
                        ModBlocks.INFUSER.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
