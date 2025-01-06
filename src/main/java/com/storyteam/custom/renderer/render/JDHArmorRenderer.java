package com.storyteam.custom.renderer.render;

import com.storyteam.custom.items.jdh.JDHArmorItem;
import com.storyteam.custom.renderer.model.JDHArmorModel;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import static com.storyteam.StoryTeam.MOD_ID;

public class JDHArmorRenderer extends GeoArmorRenderer<JDHArmorItem> {

    public JDHArmorRenderer() {
        super(new JDHArmorModel());
    }

    @Override
    public Identifier getTextureLocation(JDHArmorItem armorItem) {
        return Identifier.of(MOD_ID, "textures/models/armor/jdh_armor.png");
    }
}
