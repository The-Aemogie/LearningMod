package io.github.aemogie.learnmod.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TestEntity extends VillagerEntity implements IAnimatable {
	
	AnimationFactory factory = new AnimationFactory(this);
	
	public TestEntity(EntityType<TestEntity> type, World world) {
		super(type, world);
	}
	
	private static PlayState predicate(AnimationEvent<TestEntity> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.test_entity.walk", true));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}
	
	@Override
	public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		return ActionResultType.PASS;
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "walk", 0, TestEntity::predicate));
	}
	
	@Override
	public AnimationFactory getFactory() {
		return factory;
	}
}