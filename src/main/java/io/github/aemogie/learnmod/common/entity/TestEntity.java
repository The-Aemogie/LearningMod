package io.github.aemogie.learnmod.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TestEntity extends VillagerEntity {
	public TestEntity(EntityType<TestEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		return ActionResultType.PASS;
	}
}