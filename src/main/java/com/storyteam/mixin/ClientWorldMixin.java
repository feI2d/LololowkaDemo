package com.storyteam.mixin;

import com.storyteam.MinecraftWrapper;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class ClientWorldMixin implements MinecraftWrapper {

    @Inject(method = "setTimeOfDay", at = @At("TAIL"), cancellable = true)
    public void setTimeOfDay(long timeOfDay, CallbackInfo ci) {

    }

}
