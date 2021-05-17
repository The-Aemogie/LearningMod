package io.github.aemogie.learnmod.client.renderer.entity;

import io.github.aemogie.learnmod.common.entity.ModEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class DefaultEntityRenderer<T extends ModEntity<?>> extends EntityRenderer<T> {
	public DefaultEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager);
	}
	
	@Override
	public ResourceLocation getTextureLocation(ModEntity entity) {
		return null;
	}
}