package com.storyteam.mixin;

import com.storyteam.MinecraftWrapper;
import com.storyteam.custom.entity.BigSparkEntity;
import com.storyteam.custom.renderer.render.BigSparkRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements MinecraftWrapper {
    
    @Inject(method = "dropXp", at = @At("HEAD"), cancellable = true)
    protected void dropXp(CallbackInfo ci) {
        if ((Object) this instanceof PlayerEntity) {
            ci.cancel();
            BigSparkEntity.spawn((ServerWorld) ((Entity) ((Object) this)).getWorld(), new Vec3d((int) mc.player.getX(), (int) mc.player.getY(), (int) mc.player.getZ()));
        }
    }

}