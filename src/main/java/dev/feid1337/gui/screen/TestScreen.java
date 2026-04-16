package dev.feid1337.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.feid1337.Mod;
import dev.feid1337.content.entity.lololowka.LololowkaGeo;
import dev.feid1337.gui.model.Model;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.zeith.hammeranims.api.HammerAnimationsApi;
import org.zeith.hammeranims.api.geometry.event.RefreshStaleModelsEvent;

public class TestScreen extends Screen {

    public static TestScreen INSTANCE = new TestScreen();

    private final Model model;

    private TestScreen() {
        super(Component.empty());
        HammerAnimationsApi.EVENT_BUS.register(this);
        this.model = new Model(LololowkaGeo.geo, new ResourceLocation(Mod.ID, "textures/entity/lololowka.png"));
    }

    @SubscribeEvent
    public void updateModel(RefreshStaleModelsEvent event) {
        model.updateModel(event);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        PoseStack stack = guiGraphics.pose();

        stack.pushPose();
        model.draw(guiGraphics, partialTick);
        stack.popPose();
    }
}
