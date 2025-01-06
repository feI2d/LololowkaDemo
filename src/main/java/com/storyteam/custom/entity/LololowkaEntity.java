package com.storyteam.custom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LololowkaEntity extends PathAwareEntity implements GeoEntity {

    private final AnimatableInstanceCache instanceCache = GeckoLibUtil.createInstanceCache(this);

    public LololowkaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(1, new MeleeAttackGoal(this, 0.5D, false));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, SheepEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
        super.initGoals();
    }

    protected <E extends LololowkaEntity> PlayState idleController(final AnimationState<E> event) {
        if (event.isMoving()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.lololoshka.move"));
        }

        return event.setAndContinue(RawAnimation.begin().thenPlay("animation.lololoshka.idle"));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 1, this::idleController));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return instanceCache;
    }

}
