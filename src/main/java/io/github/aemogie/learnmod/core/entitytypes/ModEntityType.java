package io.github.aemogie.learnmod.core.entitytypes;

import com.google.common.collect.ImmutableSet;
import io.github.aemogie.learnmod.client.renderer.entity.DefaultEntityRenderer;
import io.github.aemogie.learnmod.common.entity.ModEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.Mod;

public class ModEntityType<T extends ModEntity<?>> extends EntityType<T> {
	private final IRenderFactory<T> renderFactory;
	
	public ModEntityType(IFactory<T> factory, EntityClassification category, boolean serialize, boolean summon, boolean fireImmune, boolean canSpawnFarFromPlayer, ImmutableSet<Block> immuneTo, EntitySize dimensions, int clientTrackingRange, int updateInterval, IRenderFactory<T> renderFactory) {
		super(factory, category, serialize, summon, fireImmune, canSpawnFarFromPlayer, immuneTo, dimensions, clientTrackingRange, updateInterval);
		this.renderFactory = renderFactory;
	}
	
	public IRenderFactory<?> getRenderFactory() {
		return renderFactory;
	}
	
	@SuppressWarnings("unused")
	public static class Builder<T extends ModEntity<?>> {
		private final EntityType.IFactory<T> factory;
		private final EntityClassification category;
		private ImmutableSet<Block> immuneTo = ImmutableSet.of();
		private boolean serialize = true;
		private boolean summon = true;
		private boolean fireImmune;
		private boolean canSpawnFarFromPlayer;
		private int clientTrackingRange = 5;
		private int updateInterval = 3;
		private EntitySize dimensions = EntitySize.scalable(0.6F, 1.8F);
		private final IRenderFactory<T> renderFactory;
		
		private Builder(IFactory<T> factory, EntityClassification category, IRenderFactory<T> renderFactory) {
			this.factory = factory;
			this.category = category;
			this.renderFactory = renderFactory;
			canSpawnFarFromPlayer = category == EntityClassification.CREATURE || category == EntityClassification.MISC;
		}
		
		public static <T extends ModEntity<?>> ModEntityType.Builder<T> of(IFactory<T> factory, EntityClassification category, IRenderFactory<T> renderFactory) {
			return new Builder<T>(factory, category, renderFactory);
		}
		
		@SuppressWarnings("ConstantConditions")
		public static <T extends ModEntity<?>> Builder<T> createNothing(EntityClassification category) {
			return new Builder<T>((entityType, world) -> null, category, DefaultEntityRenderer::new);
		}
		
		public Builder<T> sized(float x, float y) {
			dimensions = EntitySize.scalable(x, y);
			return this;
		}
		
		public Builder<T> noSummon() {
			summon = false;
			return this;
		}
		
		public Builder<T> noSave() {
			serialize = false;
			return this;
		}
		
		public Builder<T> fireImmune() {
			fireImmune = true;
			return this;
		}
		
		public Builder<T> immuneTo(Block... blocks) {
			immuneTo = ImmutableSet.copyOf(blocks);
			return this;
		}
		
		public Builder<T> canSpawnFarFromPlayer() {
			canSpawnFarFromPlayer = true;
			return this;
		}
		
		public Builder<T> clientTrackingRange(int clientTrackingRange) {
			this.clientTrackingRange = clientTrackingRange;
			return this;
		}
		
		public Builder<T> updateInterval(int updateInterval) {
			this.updateInterval = updateInterval;
			return this;
		}
		
		public ModEntityType<T> build(ResourceLocation resourceLocation) {
			if (serialize) {
				Util.fetchChoiceType(TypeReferences.ENTITY_TREE, resourceLocation.getPath());
			}
			return new ModEntityType<T>(factory, category, serialize, summon, fireImmune, canSpawnFarFromPlayer, immuneTo, dimensions, clientTrackingRange, updateInterval, renderFactory);
		}
	}
}
