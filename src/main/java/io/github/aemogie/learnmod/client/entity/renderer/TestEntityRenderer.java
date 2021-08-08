package io.github.aemogie.learnmod.client.entity.renderer;

import io.github.aemogie.learnmod.client.entity.models.GeoEntityModel;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TestEntityRenderer extends GeoEntityRenderer<TestEntity> {
	public TestEntityRenderer(EntityRendererManager rendererManager) {
		super(rendererManager, new GeoEntityModel<>("test_entity"));
	}
}