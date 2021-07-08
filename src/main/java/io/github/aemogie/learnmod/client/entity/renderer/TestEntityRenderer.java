package io.github.aemogie.learnmod.client.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.aemogie.learnmod.client.entity.models.TestModel;
import io.github.aemogie.learnmod.client.entity.models.TestModel;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.util.ResourceLocation;

import static io.github.aemogie.learnmod.References.MOD_ID;
import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;

@SuppressWarnings("NullableProblems")
public class TestEntityRenderer extends EntityRenderer<TestEntity> implements IEntityRenderer<TestEntity, TestModel> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/entities/test.png");
	TestModel model = new TestModel();
	public TestEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager);
		this.shadowRadius = 0.3f;
	}
	
	@Override
	public TestModel getModel() {
		return model;
	}
	
	@Override
	public void render(TestEntity pEntity, float pEntityYaw, float pPartialTicks, MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight) {
		pMatrixStack.pushPose();
		model.setupAnim(pEntity, 1, 0.001f, 0, pEntityYaw, 0);
		model.renderToBuffer(pMatrixStack, pBuffer.getBuffer(model.renderType(getTextureLocation(pEntity))), pPackedLight, NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		pMatrixStack.popPose();
		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
	
	@Override
	public ResourceLocation getTextureLocation(TestEntity entity) {
		return TEXTURE;
	}
}