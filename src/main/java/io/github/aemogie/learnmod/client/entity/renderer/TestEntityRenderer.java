package io.github.aemogie.learnmod.client.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import java.util.function.Supplier;

import static io.github.aemogie.learnmod.References.MOD_ID;
import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;

@SuppressWarnings("NullableProblems")
public class TestEntityRenderer<T extends Entity, M extends EntityModel<T>> extends EntityRenderer<T> implements IEntityRenderer<T, M> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/entities/test.png");
	private final M model;
	
	public TestEntityRenderer(EntityRendererManager renderManager, Supplier<M> modelSupplier) {
		super(renderManager);
		this.model = modelSupplier.get();
		this.shadowRadius = 0.3f;
	}
	
	@Override
	public M getModel() {
		return model;
	}
	
	@Override
	public void render(T pEntity, float pEntityYaw, float pPartialTicks, MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight) {
		this.model.setupAnim(pEntity, 1, 0.001f, 0, pEntityYaw, 0);
		this.model.renderToBuffer(pMatrixStack, pBuffer.getBuffer(this.model.renderType(getTextureLocation(pEntity))), pPackedLight, NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
	
	@Override
	public ResourceLocation getTextureLocation(T entity) {
		return TEXTURE;
	}
}