package dev.feid1337.content.entity.lololowka;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.feid1337.Mod;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.zeith.hammeranims.api.geometry.model.IGeometricModel;
import org.zeith.hammeranims.api.geometry.model.IRenderableBone;
import org.zeith.hammeranims.core.client.render.entity.BedrockEntityRenderer;

public class LololowkaRenderer extends BedrockEntityRenderer<LololowkaEntity> {

    private final ResourceLocation texture = new ResourceLocation(Mod.ID, "textures/entity/lololowka.png");

    public LololowkaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, LololowkaGeo.geo, 0f);
        getModel().addProcessor(this::process);
    }

    private void process(LololowkaEntity entity, IGeometricModel model, float partialTicks) {
        IRenderableBone bone = model.getBone("Head");
        if (bone == null) return;
        bone.getRotation().y = (float) -Math.toRadians(entity.yHeadRot - entity.yBodyRot);
        bone.getRotation().x = (float) -Math.toRadians(entity.getXRot());
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
