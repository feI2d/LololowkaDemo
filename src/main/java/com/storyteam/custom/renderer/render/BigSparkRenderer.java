package com.storyteam.custom.renderer.render;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.BigSparkEntity;
import com.storyteam.custom.renderer.model.BigSparkModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import static com.storyteam.MinecraftWrapper.mc;
import static com.storyteam.StoryTeam.MOD_ID;

public class BigSparkRenderer extends GeoEntityRenderer<BigSparkEntity> {

    public BigSparkRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new BigSparkModel());
    }

    @Override
    public void render(BigSparkEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.push();
//        mc.player.sendMessage(mc.player.getInventory().getArmorStack(3).getName());
        poseStack.scale(1.75f, 1.75f, 1.75f);
        poseStack.translate(0, 0.25f, 0);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.pop();
    }

    @Override
    public Identifier getTextureLocation(BigSparkEntity armorItem) {
        return Identifier.of(MOD_ID, "textures/models/entities/big_spark_glowmask.png");
    }
}
