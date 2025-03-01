package com.storyteam.mixin;

import com.storyteam.MinecraftWrapper;
import com.storyteam.custom.CustomHealthBar;
import com.storyteam.spark.SparkUtility;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin implements MinecraftWrapper {

    @Inject(method = "renderExperienceBar", at = @At("HEAD"), cancellable = true)
    public void renderExperienceBar(DrawContext context, int x, CallbackInfo info) {
        info.cancel();
    }

    @Unique
    private final CustomHealthBar healthBar = new CustomHealthBar();

    @Inject(method = "render", at = @At("HEAD"))
    public void render(DrawContext context, float tickDelta, CallbackInfo info) {
        assert mc.player != null;
        SparkUtility.draw(context, SparkUtility.getSparks());
        healthBar.render(context);
    }

    @Inject(method = "renderStatusBars", at = @At(value = "HEAD"), cancellable = true)
    public void disableVanillaHealthBar(DrawContext context, CallbackInfo ci) {
        ci.cancel();
    }

    @Redirect(at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(II)I"), method = "renderStatusBars")
    public int rowHeight(int a, int b) {
        return 10;
    }

    @Redirect(at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(FF)F"), method = "renderStatusBars")
    public float fakeHealth(float a, float b) {
        return 20;
    }

    @Redirect(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;getAbsorptionAmount()F"))
    public float fakeAbsorption(PlayerEntity player) {
        return (player.getAbsorptionAmount() > 0) ? 20 : 0;
    }

}
