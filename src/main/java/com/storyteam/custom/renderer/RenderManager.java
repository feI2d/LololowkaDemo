package com.storyteam.custom.renderer;

import com.storyteam.custom.CustomEntityManager;
import com.storyteam.custom.renderer.render.LololowkaRenderer;
import com.storyteam.custom.renderer.render.WatcherRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class RenderManager {

    public static void register() {
        EntityRendererRegistry.register(CustomEntityManager.WATCHER, WatcherRenderer::new);
        EntityRendererRegistry.register(CustomEntityManager.LOLOLOWKA, LololowkaRenderer::new);
    }

}
