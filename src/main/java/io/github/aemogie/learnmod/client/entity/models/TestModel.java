package io.github.aemogie.learnmod.client.entity.models;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class TestModel extends EntityModel<TestEntity> {
	private final ModelRenderer BODY;
	private final ModelRenderer TOP;
	private final ModelRenderer HEAD;
	private final ModelRenderer RIGHT_ARM;
	private final ModelRenderer RIGHT_FOREARM;
	private final ModelRenderer LEFT_ARM;
	private final ModelRenderer LEFT_FOREARM;
	private final ModelRenderer BOTTOM;
	private final ModelRenderer LEFT_LEG;
	private final ModelRenderer LEFT_LEG_PART_2;
	private final ModelRenderer RIGHT_LEG;
	private final ModelRenderer RIGHT_LEG_PART_2;
	
	public TestModel() {
		texWidth = 64;
		texHeight = 64;
		
		BODY = new ModelRenderer(this);
		
		TOP = new ModelRenderer(this);
		TOP.setPos(0.0F, 12.0F, 0.0F);
		BODY.addChild(TOP);
		TOP.texOffs(0, 16).addBox(-4.0F, 0.0F, -2.5F, 8.0F, 12.0F, 5.0F, 0.0F, false);
		
		HEAD = new ModelRenderer(this);
		HEAD.setPos(0.0F, 12.0F, 0.0F);
		TOP.addChild(HEAD);
		HEAD.texOffs(0, 0).addBox(-3.5F, 0.0F, -4.0F, 7.0F, 8.0F, 8.0F, 0.0F, false);
		
		RIGHT_ARM = new ModelRenderer(this);
		RIGHT_ARM.setPos(-4.0F, 9.5F, 0.0F);
		TOP.addChild(RIGHT_ARM);
		RIGHT_ARM.texOffs(18, 33).addBox(-3.0F, -4.5F, -2.5F, 3.0F, 7.0F, 5.0F, 0.0F, false);
		
		RIGHT_FOREARM = new ModelRenderer(this);
		RIGHT_FOREARM.setPos(-1.5F, -4.5F, 0.0F);
		RIGHT_ARM.addChild(RIGHT_FOREARM);
		RIGHT_FOREARM.texOffs(0, 44).addBox(-1.5F, -6.0F, -2.5F, 3.0F, 6.0F, 5.0F, 0.0F, false);

		LEFT_ARM = new ModelRenderer(this);
		LEFT_ARM.setPos(4.0F, 9.5F, 0.0F);
		TOP.addChild(LEFT_ARM);
		LEFT_ARM.texOffs(34, 33).addBox(0.0F, -4.5F, -2.5F, 3.0F, 7.0F, 5.0F, 0.0F, false);
		
		LEFT_FOREARM = new ModelRenderer(this);
		LEFT_FOREARM.setPos(1.5F, -4.5F, 0.0F);
		LEFT_ARM.addChild(LEFT_FOREARM);
		LEFT_FOREARM.texOffs(44, 6).addBox(-1.5F, -6.0F, -2.5F, 3.0F, 6.0F, 5.0F, 0.0F, false);
		
		BOTTOM = new ModelRenderer(this);
		BODY.addChild(BOTTOM);
		
		RIGHT_LEG = new ModelRenderer(this);
		RIGHT_LEG.setPos(-2.0F, 12.0F, 0.0F);
		BOTTOM.addChild(RIGHT_LEG);
		RIGHT_LEG.texOffs(26, 22).addBox(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, 0.0F, false);
		
		RIGHT_LEG_PART_2 = new ModelRenderer(this);
		RIGHT_LEG_PART_2.setPos(0.0F, -6.0F, 0.0F);
		RIGHT_LEG.addChild(RIGHT_LEG_PART_2);
		RIGHT_LEG_PART_2.texOffs(26, 11).addBox(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, 0.0F, false);
		
		LEFT_LEG = new ModelRenderer(this);
		LEFT_LEG.setPos(2.0F, 12.0F, 0.0F);
		BOTTOM.addChild(LEFT_LEG);
		LEFT_LEG.texOffs(0, 33).addBox(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, 0.0F, false);
		
		LEFT_LEG_PART_2 = new ModelRenderer(this);
		LEFT_LEG_PART_2.setPos(0.0F, -6.0F, 0.0F);
		LEFT_LEG.addChild(LEFT_LEG_PART_2);
		LEFT_LEG_PART_2.texOffs(30, 0).addBox(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, 0.0F, false);
	}
	
	@Override
	public void setupAnim(TestEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		BODY.yRot += limbSwingAmount;
	}
	
	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		BODY.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}