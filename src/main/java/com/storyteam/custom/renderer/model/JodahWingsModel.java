package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.other.JodahWings;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class JodahWingsModel extends GeoModel<JodahWings> {

    @Override
    public Identifier getModelResource(JodahWings jodahWings) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/jodah_wings.geo.json");
    }

    @Override
    public Identifier getTextureResource(JodahWings jodahWings) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/jodah_wings.png");
    }

    @Override
    public Identifier getAnimationResource(JodahWings jodahWings) {
        return null;
    }
}
