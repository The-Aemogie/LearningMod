package io.github.aemogie.learnmod.common.entity;

import io.github.aemogie.learnmod.core.ModEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class SeatEntity extends Entity {
	private BlockPos source;
	
	private SeatEntity(World world, BlockPos source, double offset) {
		this(ModEntities.SEAT_ENTITY.get(), world);
		this.source = source;
		this.setPos(
				this.source.getX() + 0.5d,
				this.source.getY() + offset,
				this.source.getZ() + 0.5d
		);
	}
	
	public SeatEntity(EntityType<SeatEntity> entityType, World world) {
		super(entityType, world);
	}
	
	public static ActionResultType create(World world, BlockPos pos, double offset, PlayerEntity player) {
		if (!world.isClientSide()) {
			List<SeatEntity> seats = world.getEntitiesOfClass(
					SeatEntity.class,
					new AxisAlignedBB(
							pos.getX(), pos.getY(), pos.getZ(),
							pos.getX() + 1.0, pos.getY() + 2.0, pos.getZ() + 1.0
					)
			);
			if (seats.isEmpty()) {
				SeatEntity seat = new SeatEntity(world, pos, offset);
				world.addFreshEntity(seat);
				player.startRiding(seat, false);
			}
		}
		return ActionResultType.SUCCESS;
	}
	
	@Override
	protected void defineSynchedData() {}
	
	@Override
	public void tick() {
		super.tick();
		if (source == null) {
			source = this.getSource();
		}
		if (!this.level.isClientSide()) {
			if (this.getPassengers().isEmpty() || this.level.getBlockState(source).getBlock().equals(Blocks.AIR)) {
				this.remove();
			}
		}
	}
	
	@Override
	protected void readAdditionalSaveData(CompoundNBT p_70037_1_) {}
	
	@Override
	protected void addAdditionalSaveData(CompoundNBT p_213281_1_) {}
	
	@Override
	public double getPassengersRidingOffset() {
		return 0.0;
	}
	
	public BlockPos getSource() {
		return source;
	}
	
	@Override
	protected boolean canRide(Entity p_184228_1_) {
		return true;
	}
	
	@Override
	public IPacket<?> getAddEntityPacket() { return NetworkHooks.getEntitySpawningPacket(this); }
}
