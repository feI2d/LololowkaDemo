package com.storyteam.custom.renderer.render;

import com.storyteam.custom.items.lo.LoArmorItem;
import com.storyteam.custom.renderer.model.LoArmorModel;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import static com.storyteam.StoryTeam.MOD_ID;

public class LoArmorRenderer extends GeoArmorRenderer<LoArmorItem> {

    public LoArmorRenderer() {
        super(new LoArmorModel());
    }

    @Override
    public Identifier getTextureLocation(LoArmorItem armorItem) {
        return Identifier.of(MOD_ID, "textures/models/armor/lo_armor.png");
    }

}
