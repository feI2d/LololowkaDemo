package dev.feid1337;

import com.mojang.logging.LogUtils;
import dev.feid1337.gui.screen.TestScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.zeith.hammeranims.api.HammerAnimationsApi;

@net.minecraftforge.fml.common.Mod(Mod.ID)
public class Mod {

    public static final String ID = "test";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Mod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onKeyboard(ScreenEvent.KeyPressed event) {
        if (event.getKeyCode() == GLFW.GLFW_KEY_RIGHT_SHIFT) {
            Minecraft.getInstance().setScreen(TestScreen.INSTANCE);
        }
    }

}
