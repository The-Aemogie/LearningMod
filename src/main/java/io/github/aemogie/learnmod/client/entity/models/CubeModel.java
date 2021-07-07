package io.github.aemogie.learnmod.client.entity.models;

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
		cube.addBox(-8, -8, -8, 8, 8, 8);
		cube.addBox(-6, 8, -6, 6, 16, 6);
	}
	
	@Override
	public void setupAnim(TestEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	
	@Override
	public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float r, float g, float b, float a) {
		matrixStackIn.pushPose();
		System.out.println(cube.visible);
		cube.visible = true;
		cube.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, r, g, b, a);
		matrixStackIn.popPose();
	}
}
