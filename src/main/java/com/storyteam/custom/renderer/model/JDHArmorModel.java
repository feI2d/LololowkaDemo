package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.jdh.JDHArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class JDHArmorModel extends GeoModel<JDHArmorItem> {

    @Override
    public Identifier getModelResource(JDHArmorItem animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/jdh_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(JDHArmorItem animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/jdh_armor.png");
    }

    @Override
    public Identifier getAnimationResource(JDHArmorItem animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "animations/jdh_armor.animation.json");
    }

}
