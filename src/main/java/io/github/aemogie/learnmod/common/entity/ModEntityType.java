package io.github.aemogie.learnmod.common.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;

public class ModEntityType<T extends Entity> extends EntityType<T> {
	
	public final Class<T> ENTITY_CLASS;
	public final IRenderFactory<? super T> RENDERER;
	
	public ModEntityType(IFactory<T> factory, EntityClassification category, boolean serialize, boolean summon, boolean fireImmune, boolean canSpawnFarFromPlayer, ImmutableSet<Block> immuneTo, EntitySize dimensions, int clientTrackingRange, int updateInterval, final Class<T> entityClass, final IRenderFactory<? super T> renderer) {
		super(factory, category, serialize, summon, fireImmune, canSpawnFarFromPlayer, immuneTo, dimensions, clientTrackingRange, updateInterval);
		this.ENTITY_CLASS = entityClass;
		this.RENDERER = renderer;
	}
	
	@SuppressWarnings("NullableProblems")
	public static class Builder<T extends Entity> extends EntityType.Builder<T> {
		private final Class<T> entityClass;
		private IRenderFactory<? super T> renderer;
		
		private Builder(IFactory<T> factory, EntityClassification category, Class<T> entityClass, IRenderFactory<? super T> renderer) {
			super(factory, category);
			this.entityClass = entityClass;
			this.renderer = renderer;
		}
		
		public static <T extends Entity> Builder<T> of(IFactory<T> factory, EntityClassification category, Class<T> entityClass, IRenderFactory<? super T> renderer) {
			return new Builder<>(factory, category, entityClass, renderer);
		}
		
		public Builder<T> sized(float p_220321_1_, float p_220321_2_) {
			return (Builder<T>) super.sized(p_220321_1_, p_220321_2_);
		}
		
		public Builder<T> noSummon() {
			return (Builder<T>) super.noSummon();
		}
		
		public Builder<T> noSave() {
			return (Builder<T>) super.noSave();
		}
		
		public Builder<T> fireImmune() {
			return (Builder<T>) super.fireImmune();
		}
		
		public Builder<T> immuneTo(@NotNull Block... p_233607_1_) {
			return (Builder<T>) super.immuneTo(p_233607_1_);
		}
		
		public Builder<T> canSpawnFarFromPlayer() {
			return (Builder<T>) super.canSpawnFarFromPlayer();
		}
		
		public Builder<T> clientTrackingRange(int p_233606_1_) {
			return (Builder<T>) super.clientTrackingRange(p_233606_1_);
		}
		
		public Builder<T> updateInterval(int p_233608_1_) {
			return (Builder<T>) super.updateInterval(p_233608_1_);
		}
		
		public Builder<T> setUpdateInterval(int p_setUpdateInterval_1_) {
			return (Builder<T>) super.setUpdateInterval(p_setUpdateInterval_1_);
		}
		
		public Builder<T> setTrackingRange(int p_setTrackingRange_1_) {
			return (Builder<T>) super.setTrackingRange(p_setTrackingRange_1_);
		}
		
		public Builder<T> setShouldReceiveVelocityUpdates(boolean p_setShouldReceiveVelocityUpdates_1_) {
			return (Builder<T>) super.setShouldReceiveVelocityUpdates(p_setShouldReceiveVelocityUpdates_1_);
		}
		
		public Builder<T> setCustomClientFactory(@NotNull BiFunction<SpawnEntity, World, T> p_setCustomClientFactory_1_) {
			return (Builder<T>) super.setCustomClientFactory(p_setCustomClientFactory_1_);
		}
		
		public Builder<T> setRenderer(IRenderFactory<? super T> renderer) {
			this.renderer = renderer;
			return this;
		}
		
		public ModEntityType<T> build(@NotNull String id) {
			if (this.serialize) Util.fetchChoiceType(TypeReferences.ENTITY_TREE, id);
			return new ModEntityType<>(factory, category, serialize, summon, fireImmune, canSpawnFarFromPlayer, immuneTo, dimensions, clientTrackingRange, updateInterval, entityClass, renderer);
		}
	}
	
}
