package com.storyteam.custom.renderer.render;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.SparkEntity;
import com.storyteam.custom.renderer.model.SparkModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

import static com.storyteam.MinecraftWrapper.mc;

public class SparkRenderer extends GeoReplacedEntityRenderer<ExperienceOrbEntity, SparkEntity> {

    public SparkRenderer(EntityRendererFactory.Context renderManager, SparkEntity animatable) {
        super(renderManager, new SparkModel(), animatable);
    }

    @Override
    public void render(ExperienceOrbEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.push();
        poseStack.translate(0.0F, 0.1F, 0.0F);
        poseStack.multiply(this.dispatcher.getRotation());
        poseStack.scale(0.25F, 0.25F, 0.25F);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.pop();
    }

    @Override
    public Identifier getTextureLocation(SparkEntity animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/models/entities/spark.png");
    }

}
