package com.storyteam.custom;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.BigSparkEntity;
import com.storyteam.custom.entity.LololowkaEntity;
import com.storyteam.custom.entity.WatcherEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
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

    public static final EntityType<BigSparkEntity> BIG_SPARK = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(StoryTeam.MOD_ID, "big_spark"),
            EntityType.Builder.create(BigSparkEntity::new, SpawnGroup.CREATURE).setDimensions(0.25f, 0.25f).build("big_spark")
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(WATCHER, WatcherEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1000));
        FabricDefaultAttributeRegistry.register(BIG_SPARK, WatcherEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1000));
        FabricDefaultAttributeRegistry.register(LOLOLOWKA, LololowkaEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.5f).add(EntityAttributes.GENERIC_ATTACK_SPEED, 2));
    }

}
