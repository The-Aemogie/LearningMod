package io.github.aemogie.learnmod.common.entity;

import io.github.aemogie.learnmod.LearnMod;
import io.github.aemogie.learnmod.util.StringUtils.LoggerMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

@SuppressWarnings("NullableProblems")
public class TestEntity extends Entity {
	public TestEntity(EntityType<? extends TestEntity> entityType, World world) {
		super(entityType, world);
		
		this.setBoundingBox(new AxisAlignedBB(
				this.getX() - 0.5D, this.getY()       , this.getZ() - 0.5D,
				this.getX() + 0.5D, this.getY() + 1.0D, this.getZ() + 0.5D
		));
	}
	
	@Override
	public ActionResultType interact(PlayerEntity player, Hand hand) {
		LOGGER.info(new LoggerMessage(player));
		LearnMod.minecraft.gui.getChat().addMessage(new StringTextComponent(String.valueOf(new LoggerMessage(player))));
		player.startRiding(this);
		return ActionResultType.PASS;
	}
	
	@SuppressWarnings("SpellCheckingInspection")
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
}