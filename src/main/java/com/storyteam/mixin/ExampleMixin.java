package com.storyteam.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.storyteam.MinecraftWrapper.mc;

@Mixin(MinecraftClient.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "tick")
	private void tick(CallbackInfo info) {
		if (mc.player != null) {
			boolean mask_check = mc.player.getInventory().getArmorStack(3).getName().getString().contains("Маска Междумирца");
			mc.options.togglePlayerModelPart(PlayerModelPart.HAT, !mask_check);
			if (mask_check) {
				mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 120));
				mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 120, 2));
			}
		}
	}
}