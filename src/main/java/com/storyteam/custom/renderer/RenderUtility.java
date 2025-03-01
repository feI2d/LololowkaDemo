package com.storyteam.custom.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.experimental.UtilityClass;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

@UtilityClass
public class RenderUtility {

    public void drawTexture(Identifier texture, float x, float y, float u, float v, float width, float height, float textureWidth, int textureHeight, MatrixStack matrices) {
        drawTexture(texture, x, y, width, height, u, v, width, height, textureWidth, textureHeight, matrices);
    }

    public void drawTexture(Identifier texture, float x, float y, float width, float height, float u, float v, float regionWidth, float regionHeight, float textureWidth, int textureHeight, MatrixStack matrices) {
        drawTexture(texture, x, x + width, y, y + height, 0, regionWidth, regionHeight, u, v, textureWidth, textureHeight, matrices);
    }

    void drawTexture(Identifier texture, float x1, float x2, float y1, float y2, float z, float regionWidth, float regionHeight, float u, float v, float textureWidth, int textureHeight, MatrixStack matrices) {
        drawTexturedQuad(texture, x1, x2, y1, y2, z, (u + 0.0F) / (float)textureWidth, (u + (float)regionWidth) / (float)textureWidth, (v + 0.0F) / (float)textureHeight, (v + (float)regionHeight) / (float)textureHeight, matrices);
    }

    void drawTexturedQuad(Identifier texture, float x1, float x2, float y1, float y2, float z, float u1, float u2, float v1, float v2, MatrixStack matrices) {
        RenderSystem.setShaderTexture(0, texture);
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrix4f, (float)x1, (float)y1, (float)z).texture(u1, v1).next();
        bufferBuilder.vertex(matrix4f, (float)x1, (float)y2, (float)z).texture(u1, v2).next();
        bufferBuilder.vertex(matrix4f, (float)x2, (float)y2, (float)z).texture(u2, v2).next();
        bufferBuilder.vertex(matrix4f, (float)x2, (float)y1, (float)z).texture(u2, v1).next();
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
    }

}
