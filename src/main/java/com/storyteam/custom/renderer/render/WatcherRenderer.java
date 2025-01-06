package com.storyteam.custom.renderer.render;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.WatcherEntity;
import com.storyteam.custom.renderer.model.WatcherModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WatcherRenderer extends GeoEntityRenderer<WatcherEntity> {

    public WatcherRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WatcherModel());

    }

    @Override
    public Identifier getTextureLocation(WatcherEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "entity/texture/watcher.png");
    }

}
