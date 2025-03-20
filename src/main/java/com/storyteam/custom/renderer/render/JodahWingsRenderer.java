package com.storyteam.custom.renderer.render;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.other.JodahWings;
import com.storyteam.custom.renderer.model.JodahWingsModel;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class JodahWingsRenderer extends GeoArmorRenderer<JodahWings> {

    public JodahWingsRenderer() {
        super(new JodahWingsModel());
    }

    @Override
    public Identifier getTextureLocation(JodahWings jodahWings) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/jodah_wings.png");
    }

}
