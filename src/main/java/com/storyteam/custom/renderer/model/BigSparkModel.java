package com.storyteam.custom.renderer.model;

import com.storyteam.StoryTeam;
import com.storyteam.custom.entity.BigSparkEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BigSparkModel extends GeoModel<BigSparkEntity> {
    @Override
    public Identifier getModelResource(BigSparkEntity bigSparkEntity) {
        return Identifier.of(StoryTeam.MOD_ID, "geo/big_spark.geo.json");
    }

    @Override
    public Identifier getTextureResource(BigSparkEntity bigSparkEntity) {
        return Identifier.of(StoryTeam.MOD_ID, "textures/models/entities/big_spark_glowmask.png");
    }

    @Override
    public Identifier getAnimationResource(BigSparkEntity bigSparkEntity) {
        return Identifier.of(StoryTeam.MOD_ID, "animations/big_spark.animation.json");
    }
}
