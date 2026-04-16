package dev.feid1337.content.entity.lololowka;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.feid1337.Mod;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.zeith.hammeranims.api.geometry.model.IGeometricModel;
import org.zeith.hammeranims.api.geometry.model.IRenderableBone;
import org.zeith.hammeranims.core.client.render.entity.BedrockEntityRenderer;
import org.zeith.hammeranims.core.client.render.entity.proc.HeadLookProcessor;

public class LololowkaRenderer extends BedrockEntityRenderer<LololowkaEntity> {

    private final ResourceLocation texture = new ResourceLocation(Mod.ID, "textures/entity/lololowka.png");

    public LololowkaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, LololowkaGeo.geo, 0f);
        getModel().addProcessor(new HeadLookProcessor<>("Head"));
    }

    @Override
    public ResourceLocation getTextureLocation(LololowkaEntity lololowkaEntity) {
        return texture;
    }

    @Override
    protected RenderType getRenderType(ResourceLocation texture) {
        return RenderType.entityTranslucent(texture);
    }
}
