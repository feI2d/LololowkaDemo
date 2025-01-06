package com.storyteam.mixin;

import lombok.Getter;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientPlayerEntity.class)
public interface ClientPlayerEntityMixin {

    @Accessor("ticksSinceLastPositionPacketSent")
    int getTicksSinceLastPositionPacketSent();

}
