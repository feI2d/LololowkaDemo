package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.lo.LoArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class LoArmorModel<T> extends GeoModel<LoArmorItem> {
    @Override
    public Identifier getModelResource(LoArmorItem animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/lo_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(LoArmorItem animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/lo_armor.png");
    }

    @Override
    public Identifier getAnimationResource(LoArmorItem animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "animations/lo_armor.animation.json");
    }
}
