package dev.feid1337.init;

import dev.feid1337.content.entity.lololowka.LololowkaEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.zeith.hammerlib.annotations.RegistryName;
import org.zeith.hammerlib.annotations.SimplyRegister;

@SimplyRegister
public interface EntitiesRegistry {

    @RegistryName("lololowka")
    EntityType<LololowkaEntity> lololowka = EntityType.Builder.of(LololowkaEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).build("lololowka");



}
