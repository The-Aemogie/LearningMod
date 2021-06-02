package io.github.aemogie.learnmod.client.renderer.entity;

import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class Test extends EntityRenderer<TestEntity> {
	public Test(EntityRendererManager manager) {
		super(manager);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TestEntity entity) {
		return null;
	}
}