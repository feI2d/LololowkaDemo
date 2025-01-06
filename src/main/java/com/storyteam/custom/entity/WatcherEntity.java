package com.storyteam.custom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Arm;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


public class WatcherEntity extends PathAwareEntity implements GeoEntity {

    private final AnimatableInstanceCache instanceCache = GeckoLibUtil.createInstanceCache(this);
    private final RawAnimation woohAnim = RawAnimation.begin().then("extended_hand", Animation.LoopType.HOLD_ON_LAST_FRAME);

    public WatcherEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);

    }

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    private <E extends GeoEntity> PlayState predicate(AnimationState<E> event) {
        return event.setAndContinue(woohAnim);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.instanceCache;
    }

}
