package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.LololowkaEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;

public class LololowkaModel extends GeoModel<LololowkaEntity> {

    @Override
    public @Nullable RenderLayer getRenderType(LololowkaEntity animatable, Identifier texture) {
        return super.getRenderType(animatable, texture);
    }

    @Override
    public Identifier getModelResource(LololowkaEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/lololoshka.geo.json");
    }

    @Override
    public Identifier getTextureResource(LololowkaEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "entity/texture/lololoshka.png");
    }

    @Override
    public Identifier getAnimationResource(LololowkaEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "animations/lololoshka.animation.json");
    }

}
