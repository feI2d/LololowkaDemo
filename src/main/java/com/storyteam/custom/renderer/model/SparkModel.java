package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.SparkEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class SparkModel extends GeoModel<SparkEntity> {

    @Override
    public Identifier getModelResource(SparkEntity sparkEntity) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/spark.geo.json");
    }

    @Override
    public Identifier getTextureResource(SparkEntity sparkEntity) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/models/entities/spark.png");
    }

    @Override
    public Identifier getAnimationResource(SparkEntity sparkEntity) {
        return null;
    }

}
