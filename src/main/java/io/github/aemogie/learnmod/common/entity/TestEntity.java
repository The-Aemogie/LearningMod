package io.github.aemogie.learnmod.common.entity;

import io.github.aemogie.learnmod.client.renderer.entity.TestEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TestEntity extends ModEntity<TestEntity> {
	
	private TestEntity(World world) {
		super(world);
	}
	
	public TestEntity(EntityType<TestEntity> entityType, World world) {
		super(entityType, world, TestEntityRenderer::new);
	}
}
