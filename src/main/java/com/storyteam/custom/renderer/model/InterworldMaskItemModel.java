package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.interworld.InterworldMask;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class InterworldMaskItemModel extends GeoModel<InterworldMask> {

    @Override
    public Identifier getModelResource(InterworldMask interworldMask) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/interworld_mask_item.geo.json");
    }

    @Override
    public Identifier getTextureResource(InterworldMask interworldMask) {
        return switch (interworldMask.getTypeMask()) {
            case VIOLET -> Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/interworld_violet_mask.png");
            case JDH -> Identifier.of(StoryTeam.MOD_ID, "textures/models/armor/jdh_mask.png");
        };
    }

    @Override
    public Identifier getAnimationResource(InterworldMask interworldMask) {
        return null;
    }

}
