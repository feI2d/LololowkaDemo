package com.storyteam.custom.renderer.render;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.interworld.InterworldMask;
import com.storyteam.custom.renderer.model.InterworldMaskModel;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;


public class InterworldMaskRenderer extends GeoArmorRenderer<InterworldMask> {

    public InterworldMaskRenderer() {
        super(new InterworldMaskModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public Identifier getTextureLocation(InterworldMask interworldMask) {
        return switch (interworldMask.getTypeMask()) {
            case VIOLET -> Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/interworld_violet_mask.png");
            case JDH -> Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/jdh_mask.png");
        };
    }

}
