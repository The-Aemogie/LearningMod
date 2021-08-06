package io.github.aemogie.learnmod.client.entity.renderer;

import io.github.aemogie.learnmod.client.entity.models.TestModel;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import static io.github.aemogie.learnmod.References.MOD_ID;

@SuppressWarnings("NullableProblems")
public class TestEntityRenderer extends MobRenderer<TestEntity, TestModel> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/entities/test.png");
	
	public TestEntityRenderer(EntityRendererManager rendererManager) {
		super(rendererManager, new TestModel(), 0.3f);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TestEntity p_110775_1_) {
		return TEXTURE;
	}
}