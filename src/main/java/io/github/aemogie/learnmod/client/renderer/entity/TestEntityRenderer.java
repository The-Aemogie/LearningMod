package io.github.aemogie.learnmod.client.renderer.entity;

import io.github.aemogie.learnmod.client.renderer.entity.models.CubeModel;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.util.ResourceLocation;

import static io.github.aemogie.learnmod.References.MOD_ID;

@SuppressWarnings("NullableProblems")
public class TestEntityRenderer extends EntityRenderer<TestEntity> implements IEntityRenderer<TestEntity, CubeModel> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/blocks/black_glass_light_1.png");
	
	public TestEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager);
		this.shadowRadius = 0.3f;
	}
	
	@Override
	protected boolean shouldShowName(TestEntity entity) {
		return true;
	}
	
	@Override
	public CubeModel getModel() {
		return new CubeModel();
	}
	
	@Override
	public ResourceLocation getTextureLocation(TestEntity entity) {
		return TEXTURE;
	}
}