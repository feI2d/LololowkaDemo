package com.storyteam.mixin;

import com.storyteam.custom.CustomEntityManager;
import com.storyteam.custom.CustomItemsManager;
import com.storyteam.custom.entity.BigSparkEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.storyteam.MinecraftWrapper.mc;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow
    public int experienceLevel;
    @Shadow
    public float experienceProgress;
    @Shadow
    public int totalExperience;
    @Shadow
    public int experiencePickUpDelay;

    @Shadow public abstract HungerManager getHungerManager();

    @Inject(method = "addExperienceLevels", at = @At("HEAD"), cancellable = true)
    public void addExperienceLevels(int levels, CallbackInfo ci) {
        ci.cancel();
        this.experienceLevel += levels;
        if (this.experienceLevel < 0) {
            this.experienceLevel = 0;
            this.experienceProgress = 0.0F;
            this.totalExperience = 0;
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        experiencePickUpDelay = 0;
        this.getHungerManager().setFoodLevel(8);
        this.getHungerManager().setSaturationLevel(0);
        this.getHungerManager().setExhaustion(0);
    }

}
