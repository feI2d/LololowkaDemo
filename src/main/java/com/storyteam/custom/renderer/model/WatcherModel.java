package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.WatcherEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class WatcherModel extends GeoModel<WatcherEntity> {

    @Override
    public Identifier getModelResource(WatcherEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/watcher.geo.json");
    }

    @Override
    public Identifier getTextureResource(WatcherEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "entity/texture/watcher.png");
    }

    @Override
    public Identifier getAnimationResource(WatcherEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "animations/watcher.animation.json");
    }
}
