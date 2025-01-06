package com.storyteam.mixin;

import com.storyteam.MinecraftWrapper;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class IngameHudMixin implements MinecraftWrapper {

    @Inject(method = "render", at = @At("TAIL"))
    public void render(DrawContext context, float tickDelta, CallbackInfo info) {
        context.drawCenteredTextWithShadow(mc.textRenderer, "Time: " + getFormattedGameTime(mc.world.getTimeOfDay()), 50, 5, -1);
    }

    @Unique
    private static String getFormattedGameTime(long ticks) {
        long totalMinutes = (ticks) / 60;
        long hours = (totalMinutes / 60) % 24;
        long minutes = totalMinutes % 60;

        return String.format("%02d:%02d", hours, minutes);
    }

}
