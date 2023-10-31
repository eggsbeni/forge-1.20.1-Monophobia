package net.eggs.monophobia.event;

import net.eggs.monophobia.Monophobiamod;
import net.eggs.monophobia.particle.DesolateParticles;
import net.eggs.monophobia.particle.ModParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Monophobiamod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.DESOLATE_PARTICLES.get(), DesolateParticles.Provider::new);

    }

}
