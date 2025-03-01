package com.storyteam.mixin;

import com.storyteam.MinecraftWrapper;
import com.storyteam.custom.CustomEntityManager;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin implements MinecraftWrapper {

    @Inject(method = "onPlayerCollision", at = @At("HEAD"))
    public void onPlayerCollision(PlayerEntity player, CallbackInfo ci) {
        player.experiencePickUpDelay = 0;
    }

    @Inject(method = "spawn", at = @At("HEAD"), cancellable = true)
    private static void spawn(ServerWorld world, Vec3d pos, int amount, CallbackInfo ci) {
//        ci.cancel();
//        if (mc.player.totalExperience > 0) world.spawnEntity(CustomEntityManager.BIG_SPARK.spawn(world, new BlockPos((int) pos.getX(), (int) pos.getY(), (int) pos.getZ()), SpawnReason.EVENT).setSparks(mc.player.totalExperience));
    }

}
