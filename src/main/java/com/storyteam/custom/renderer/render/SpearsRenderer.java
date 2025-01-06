package com.storyteam.custom.renderer.render;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.combat.SpearsOfTheFather;
import com.storyteam.custom.renderer.model.SpearsModel;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SpearsRenderer extends GeoItemRenderer<SpearsOfTheFather> {
    public SpearsRenderer() {
        super(new SpearsModel());
    }

    @Override
    public Identifier getTextureLocation(SpearsOfTheFather animatable) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/item/spears_of_the_father.png");
    }

}
