package dev.feid1337.content.entity.lololowka;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.hammeranims.api.animsys.layer.AnimationLayer;
import org.zeith.hammeranims.api.tile.IAnimatedEntity;

public class LololowkaEntity extends PathfinderMob implements IAnimatedEntity {

    private final AnimationSystem animationSystem = AnimationSystem.create(this);

    public LololowkaEntity(EntityType<? extends PathfinderMob> type, Level world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3, 1));
    }

    @Override
    public void tick() {
        super.tick();
        animationSystem.tick();
    }

    @Override
    public void setupSystem(AnimationSystem.Builder builder) {
        builder.autoSync();
    }

    @Override
    public AnimationSystem getAnimationSystem() {
        return animationSystem;
    }

}
