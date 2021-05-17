package io.github.aemogie.learnmod.common.entity;

import io.github.aemogie.learnmod.client.renderer.entity.DefaultEntityRenderer;
import io.github.aemogie.learnmod.core.entitytypes.EntityTypesList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.IForgeRegistryEntry;

@SuppressWarnings("NullableProblems")
public abstract class ModEntity<T extends ModEntity<?>> extends Entity {
	
	private final IRenderFactory<T> RENDER_FACTORY;
	
	protected ModEntity(World world) {
		super(EntityTypesList.DEFAULT_ENTITY, world);
		this.RENDER_FACTORY = DefaultEntityRenderer::new;
	}
	
	protected ModEntity(EntityType<?> entityType, World world, IRenderFactory<T> renderFactory) {
		super(entityType, world);
		this.RENDER_FACTORY = renderFactory;
	}
	
	@Override
	protected void defineSynchedData() {
	
	}
	
	@Override
	protected void readAdditionalSaveData(CompoundNBT nbt) {
	
	}
	
	@Override
	protected void addAdditionalSaveData(CompoundNBT nbt) {
	
	}
	
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	public IRenderFactory<T> getRenderFactory() {
		return RENDER_FACTORY;
	}
}
