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
import net.minecraftforge.fml.network.FMLPlayMessages;

import java.lang.reflect.InvocationTargetException;
import java.util.function.BiFunction;

public class ModEntityType<T extends Entity> extends EntityType<T> {
	
	public final Class<T> ENTITY_CLASS;
	public final IRenderFactory<? super T> RENDERER;
	
	public ModEntityType(IFactory<T> factory, EntityClassification category, boolean serialize, boolean summon, boolean fireImmune, boolean canSpawnFarFromPlayer, ImmutableSet<Block> immuneTo, EntitySize dimensions, int clientTrackingRange, int updateInterval, final IRenderFactory<? super T> RENDERER, final Class<T> entityClass) {
		super(factory, category, serialize, summon, fireImmune, canSpawnFarFromPlayer, immuneTo, dimensions, clientTrackingRange, updateInterval);
		this.RENDERER = RENDERER;
		this.ENTITY_CLASS = entityClass;
	}
	
	public static class Builder<T extends Entity> {
		private final IFactory<T> factory;
		private final EntityClassification category;
		private final ImmutableSet<Block> immuneTo = ImmutableSet.of();
		private final boolean canSpawnFarFromPlayer;
		private final Class<T> entityClass;
		private boolean serialize = true;
		private boolean summon = true;
		private EntitySize dimensions = EntitySize.scalable(0.6F, 1.8F);
		
		private BiFunction<FMLPlayMessages.SpawnEntity, World, T> customClientFactory;
		private IRenderFactory<? super T> renderer;
		
		private Builder(Class<T> entityClass, EntityClassification category, IRenderFactory<? super T> renderer) {
			this.factory = (entityType, world) -> {
				try {
					return entityClass.getConstructor(
							EntityType.class,
							World.class
					).newInstance(
							entityType,
							world
					);
				} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
					e.printStackTrace();
					throw new IllegalArgumentException("Invalid entity class: \" " + entityClass + " \"!");
				}
			};
			this.entityClass = entityClass;
			this.category = category;
			this.canSpawnFarFromPlayer = category == EntityClassification.CREATURE || category == EntityClassification.MISC;
			this.renderer = renderer;
		}
		
		public static <T extends Entity> Builder<T> of(Class<T> entityClass, EntityClassification category, IRenderFactory<? super T> renderer) {
			return new Builder<T>(entityClass, category, renderer);
		}
		
		public Builder<T> sized(float width, float height) {
			this.dimensions = EntitySize.scalable(width, height);
			return this;
		}
		
		public Builder<T> noSummon() {
			this.summon = false;
			return this;
		}
		
		public Builder<T> noSave() {
			this.serialize = false;
			return this;
		}
		
		public Builder<T> setRenderer(IRenderFactory<? super T> renderer) {
			this.renderer = renderer;
			return this;
		}
		
		public ModEntityType<T> build(String id) {
			if (this.serialize) {
				Util.fetchChoiceType(TypeReferences.ENTITY_TREE, id);
			}
			return new ModEntityType<>(factory, category, serialize, summon, false, canSpawnFarFromPlayer, immuneTo, dimensions, 5, 3, renderer, entityClass);
		}
	}
	
}
