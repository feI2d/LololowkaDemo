package com.storyteam.custom.renderer.render;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.other.JodahWings;
import com.storyteam.custom.renderer.model.JodahWingsItemModel;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class JodahWingsItemRenderer extends GeoItemRenderer<JodahWings> {

    public JodahWingsItemRenderer() {
        super(new JodahWingsItemModel());
    }

    @Override
    public Identifier getTextureLocation(JodahWings animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/jodah_wings.png");
    }
}
