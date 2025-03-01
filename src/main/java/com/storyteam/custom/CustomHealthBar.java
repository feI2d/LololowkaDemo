package com.storyteam.custom;

import com.storyteam.MinecraftWrapper;
import com.storyteam.StoryTeam;
import com.storyteam.custom.renderer.RenderUtility;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class CustomHealthBar implements MinecraftWrapper {

    private final Identifier HEALTH_BAR = Identifier.of(StoryTeam.MOD_ID, "textures/gui/bars/health_bar.png");
    private final Identifier HEALTH_LINE = Identifier.of(StoryTeam.MOD_ID, "textures/gui/bars/health_line.png");
    private final Identifier HEART = Identifier.of(StoryTeam.MOD_ID, "textures/gui/bars/heart.png");

    public void render(DrawContext context) {

        if (mc.cameraEntity instanceof PlayerEntity player && !mc.options.hudHidden && mc.interactionManager != null && mc.interactionManager.hasStatusBars()) {
            int width = mc.getWindow().getScaledWidth();
            int height = mc.getWindow().getScaledHeight();
            float x = (float) width / 2 - 40;
            float y = height - 30;

            renderHealthBar(context, x, y, player);
        }
    }

    private void renderHealthBar(DrawContext context, float x, float y, PlayerEntity player) {
        int totalBarWidth = 80;
        float healthWidth = totalBarWidth * (player.getHealth() / player.getMaxHealth());
        float centerX =  x + totalBarWidth / 2f;
        float healthStartX = centerX - healthWidth / 2f - 1.5f;

        RenderUtility.drawTexture(HEALTH_LINE,
                healthStartX, y,
                0, 0,
                healthWidth, 9,
                totalBarWidth, 9, context.getMatrices());

        RenderUtility.drawTexture(HEALTH_BAR, x, y, 0, 0, totalBarWidth, 11, totalBarWidth, 9, context.getMatrices());
        RenderUtility.drawTexture(HEART, x,  y, 0, 0, totalBarWidth, 9, totalBarWidth, 9, context.getMatrices());
    }

}
