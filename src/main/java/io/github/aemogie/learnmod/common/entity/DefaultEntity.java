package io.github.aemogie.learnmod.common.entity;

import io.github.aemogie.learnmod.client.renderer.entity.DefaultEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class DefaultEntity extends ModEntity<DefaultEntity> {
	private DefaultEntity(World world) {
		super(world);
	}
	
	public DefaultEntity(EntityType<DefaultEntity> entityType, World world) {
		super(entityType, world, DefaultEntityRenderer::new);
	}
}
