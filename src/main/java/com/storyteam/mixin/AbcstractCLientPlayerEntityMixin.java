package com.storyteam.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.storyteam.StoryTeam.MOD_ID;

@Mixin(AbstractClientPlayerEntity.class)
public class AbcstractCLientPlayerEntityMixin {

    @Inject(method = "getSkinTexture", at = @At("RETURN"), cancellable = true)
    public void getSkinTextures(CallbackInfoReturnable<Identifier> cir) {
        cir.setReturnValue(Identifier.of(MOD_ID, "entity/texture/lololowka.png"));
    }

}
