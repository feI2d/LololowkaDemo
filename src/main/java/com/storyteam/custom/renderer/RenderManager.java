package com.storyteam.custom.renderer;

import com.storyteam.custom.CustomEntityManager;
import com.storyteam.custom.entity.SparkEntity;
import com.storyteam.custom.renderer.render.BigSparkRenderer;
import com.storyteam.custom.renderer.render.LololowkaRenderer;
import com.storyteam.custom.renderer.render.SparkRenderer;
import com.storyteam.custom.renderer.render.WatcherRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

public class RenderManager {

    public static void register() {
        EntityRendererRegistry.register(CustomEntityManager.WATCHER, WatcherRenderer::new);
        EntityRendererRegistry.register(CustomEntityManager.LOLOLOWKA, LololowkaRenderer::new);
        EntityRendererRegistry.register(CustomEntityManager.BIG_SPARK, BigSparkRenderer::new);
        EntityRendererRegistry.register(EntityType.EXPERIENCE_ORB, context -> new SparkRenderer(context, new SparkEntity()));
    }

}
