package com.storyteam.spark;

import com.mojang.blaze3d.systems.RenderSystem;
import com.storyteam.MinecraftWrapper;
import com.storyteam.StoryTeam;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Setter
@Getter
@UtilityClass
public class SparkUtility implements MinecraftWrapper {

    private final Identifier texture = Identifier.of(StoryTeam.MOD_ID, "textures/gui/spark_background.png");
    @Setter
    @Getter
    private int lastSparks = 1;

    public int getSparks() {
        assert mc.player != null;
        return mc.player.totalExperience;
    }

    public void draw(DrawContext context, int sparks) {
        int textWidth = mc.textRenderer.getWidth(String.valueOf(sparks));
        int x = mc.getWindow().getScaledWidth() - textWidth - 10;
        int y = mc.getWindow().getScaledHeight() - 20;

        int textureWidth = 200;
        int textureHeight = 200;
        float scale = 1.0F;
        int scaledWidth = (int)((float)textureWidth * scale);
        int scaledHeight = (int)((float)textureHeight * scale);

        RenderSystem.setShaderTexture(0, texture);
        context.drawTexture(texture, x - 15, y - 70, 0, 0, scaledWidth, scaledHeight);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        context.drawText(mc.textRenderer, String.valueOf(sparks),  x + 5, y - 63, 16777215, true);
    }

}
