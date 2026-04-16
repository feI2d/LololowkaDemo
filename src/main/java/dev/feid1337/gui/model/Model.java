package dev.feid1337.gui.model;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.zeith.hammeranims.api.geometry.IGeometryContainer;
import org.zeith.hammeranims.api.geometry.event.RefreshStaleModelsEvent;
import org.zeith.hammeranims.api.geometry.model.IGeometricModel;
import org.zeith.hammeranims.api.geometry.model.RenderData;

public class Model {

    private final IGeometryContainer container;
    private IGeometricModel model = IGeometricModel.EMPTY;
    private final ResourceLocation texture;

    public Model(IGeometryContainer container, ResourceLocation texture) {
        this.container = container;
        this.texture = texture;
    }

    public void updateModel(RefreshStaleModelsEvent event) {
        model = container.createModel();
    }

    public void draw(GuiGraphics context, float partialTicks) {
        if (model == null || model == IGeometricModel.EMPTY) return;

        model.resetPose();
        RenderData renderData = new RenderData().apply(context.pose(), context.bufferSource().getBuffer(getRenderType()), -1, -1);
        model.renderModel(renderData);
    }

    private RenderType getRenderType() {
        return RenderType.entityTranslucent(texture);
    }

}
