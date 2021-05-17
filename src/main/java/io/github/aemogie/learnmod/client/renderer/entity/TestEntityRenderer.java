package io.github.aemogie.learnmod.client.renderer.entity;

import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import static io.github.aemogie.learnmod.References.MOD_ID;

public class TestEntityRenderer extends EntityRenderer<TestEntity> {
	public final ResourceLocation TEST_SKIN_LOCATION = new ResourceLocation(MOD_ID, "light_source.png");
	
	public TestEntityRenderer(EntityRendererManager rendererManager) {
		super(rendererManager);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TestEntity entity) {
		return TEST_SKIN_LOCATION;
	}
	
	@Override
	protected int getBlockLightLevel(TestEntity entity, BlockPos pos) {
		return 15;
	}
	
	@Override
	protected int getSkyLightLevel(TestEntity entity, BlockPos pos) {
		return 15;
	}
	
	@Override
	public boolean shouldRender(TestEntity entity, ClippingHelper clippingHelper, double x, double y, double z) {
		return true;
	}
	
	@Override
	protected boolean shouldShowName(TestEntity entity) {
		return true;
	}
}