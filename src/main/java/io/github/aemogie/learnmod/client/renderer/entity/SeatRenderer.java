package io.github.aemogie.learnmod.client.renderer.entity;

import io.github.aemogie.learnmod.common.entity.SeatEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SeatRenderer extends EntityRenderer<SeatEntity> {
	
	public SeatRenderer(EntityRendererManager renderManager) {
		super(renderManager);
	}
	
	@Override
	public ResourceLocation getTextureLocation(SeatEntity entity) {
		return null;
	}
}