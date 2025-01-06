package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.combat.SpearsOfTheFather;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class SpearsModel extends GeoModel<SpearsOfTheFather> {
    @Override
    public Identifier getModelResource(SpearsOfTheFather animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/spears_of_the_father.geo.json");
    }

    @Override
    public Identifier getTextureResource(SpearsOfTheFather animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/item/spears_of_the_father.png");
    }

    @Override
    public Identifier getAnimationResource(SpearsOfTheFather animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "animations/spears_of_the_father.animation.json");
    }
}
