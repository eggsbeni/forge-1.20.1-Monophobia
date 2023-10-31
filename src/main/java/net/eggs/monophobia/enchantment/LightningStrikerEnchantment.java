package net.eggs.monophobia.enchantment;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningStrikerEnchantment extends Enchantment {
    protected LightningStrikerEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {

        if(!pAttacker.level().isClientSide()) {
            ServerLevel level = ((ServerLevel) pAttacker.level());
            BlockPos position = pTarget.blockPosition();

            if (pLevel == 1) {
                EntityType.LIGHTNING_BOLT.spawn(level, (ItemStack) null, null, position,
                        MobSpawnType.TRIGGERED, true, true);

            }

            if (pLevel == 1) {
                EntityType.LIGHTNING_BOLT.spawn(level, (ItemStack) null, null, position,
                        MobSpawnType.TRIGGERED, true, true);

                EntityType.LIGHTNING_BOLT.spawn(level, (ItemStack) null, null, position,
                        MobSpawnType.TRIGGERED, true, true);
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
    @Override
    public int getMaxLevel(){
        return 2;

    }

}
