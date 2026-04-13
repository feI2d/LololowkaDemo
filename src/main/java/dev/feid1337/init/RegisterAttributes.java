package dev.feid1337.init;

import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterAttributes {
    @SubscribeEvent
    public static void addAttributes(EntityAttributeCreationEvent event) {
        System.out.println("Register attributes!");
        event.put(EntitiesRegistry.lololowka, Mob.createMobAttributes().build());
    }
}
