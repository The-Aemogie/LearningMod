package io.github.aemogie.learnmod.client.renderer.entity.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

@SuppressWarnings("NullableProblems")
public class CubeModel extends EntityModel<TestEntity> {
	
	private static ModelRenderer cube;
	
	public CubeModel() {
		cube = new ModelRenderer(this);
		System.out.println(this.texHeight);
		System.out.println(this.texWidth);
		cube.addBox(0, 0, 0, 100, 100, 100);
	}
	
	@Override
	public void setupAnim(TestEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	
	@Override
	public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float r, float g, float b, float a) {
		cube.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}
}
