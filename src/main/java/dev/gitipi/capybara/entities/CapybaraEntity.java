package dev.gitipi.capybara.entities;

import dev.gitipi.capybara.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class CapybaraEntity extends Animal implements IAnimatable {

    public static final Ingredient FOOD_ITEMS = Ingredient.of(Items.APPLE);


    private AnimationFactory factory = new AnimationFactory(this);

    public CapybaraEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);

    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return EntityInit.CAPYBARA.get().create(level);
    }

    @Override
    protected void registerGoals() {

        //this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(4, new FloatGoal(this));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2, FOOD_ITEMS, false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder getMobAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0D).add(Attributes.MOVEMENT_SPEED, 0.15D);
    }

    public static boolean canSpawn(EntityType<CapybaraEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return checkAnimalSpawnRules(entityType, level, spawnType, pos, random) && pos.getY() > 50;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.capybara.walk", true));
        }
        else if (this.level.getFluidState(BlockPos.of(Mth.floor(this.getX()))).is(FluidTags.WATER)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.capybara.seat", true));
        }
        else { // any state that is not event.isMoving() falls here
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.capybara.idle", true));
        }
        return PlayState.CONTINUE;

    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

/*
    static class CapyGoToWaterGoal extends MoveToBlockGoal {
        private static final int GIVE_UP_TICKS = 1200;
        private final Turtle capybara;

        CapyGoToWaterGoal(Turtle turtle, double p_30263_) {
            super(turtle, turtle.isBaby() ? 2.0D : p_30263_, 24);
            this.capybara = turtle;
            this.verticalSearchStart = -1;
        }

        public boolean canContinueToUse() {
            return !this.capybara.isInWater() && this.tryTicks <= 1200 && this.isValidTarget(this.capybara.level, this.blockPos);
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 160 == 0;
        }

        protected boolean isValidTarget(LevelReader p_30270_, BlockPos p_30271_) {
            return p_30270_.getBlockState(p_30271_).is(Blocks.WATER);
        }
    }

 */
}
