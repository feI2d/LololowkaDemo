package com.storyteam.custom;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.LololowkaEntity;
import com.storyteam.custom.entity.WatcherEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomEntityManager {

    public static final EntityType<WatcherEntity> WATCHER = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(StoryTeam.MOD_ID, "watcher"),
            EntityType.Builder.create(WatcherEntity::new, SpawnGroup.CREATURE).build("watcher")
    );

    public static final EntityType<LololowkaEntity> LOLOLOWKA = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(StoryTeam.MOD_ID, "lololowka"),
            EntityType.Builder.create(LololowkaEntity::new, SpawnGroup.CREATURE).build("lololowka")
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(WATCHER, WatcherEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1000));
        FabricDefaultAttributeRegistry.register(LOLOLOWKA, LololowkaEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.5f).add(EntityAttributes.GENERIC_ATTACK_SPEED, 2));
    }

}
