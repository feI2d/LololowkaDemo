package com.storyteam.custom.renderer.render;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.LololowkaEntity;
import com.storyteam.custom.renderer.model.LololowkaModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LololowkaRenderer extends GeoEntityRenderer<LololowkaEntity> {

    public LololowkaRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new LololowkaModel());
    }

    @Override
    public @Nullable RenderLayer getRenderType(LololowkaEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
//        return RenderLayer.getEntityTranslucent(texture);
    }

    @Override
    public Identifier getTextureLocation(LololowkaEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "entity/texture/lololoshka.png");
    }

}
