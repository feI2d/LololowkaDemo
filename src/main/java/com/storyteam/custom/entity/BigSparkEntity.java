package com.storyteam.custom.entity;

import com.storyteam.StoryTeam;
import com.storyteam.custom.CustomEntityManager;
import lombok.Getter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtInt;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import static com.storyteam.MinecraftWrapper.mc;

@Getter
public class BigSparkEntity extends PathAwareEntity implements GeoEntity {

    private final AnimatableInstanceCache instanceCache = GeckoLibUtil.createInstanceCache(this);
    private int sparksIn = 0;

    public BigSparkEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public BigSparkEntity setSparks(int value) {
        this.sparksIn = value;
        return this;
    }

    @Override
    public void pushAwayFrom(Entity entity) {

    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        return false;
    }

    protected <E extends BigSparkEntity> PlayState idleController(final AnimationState<E> event) {
        return event.setAndContinue(RawAnimation.begin().thenPlay("animation.model.big_spark"));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, 1, this::idleController));
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        player.addExperience(sparksIn);
        StoryTeam.LOGGER.debug("удалил");
        this.discard();
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.put("Sparks", NbtInt.of(sparksIn));
        return super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        this.sparksIn = nbt.getInt("Sparks");
        super.readNbt(nbt);
    }

    public static void spawn(ServerWorld world, Vec3d pos) {
        if (mc.player.totalExperience > 0) world.spawnEntity(CustomEntityManager.BIG_SPARK.spawn(world, new BlockPos((int) pos.getX(), (int) pos.getY(), (int) pos.getZ()), SpawnReason.EVENT).setSparks(mc.player.totalExperience));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return instanceCache;
    }
}
