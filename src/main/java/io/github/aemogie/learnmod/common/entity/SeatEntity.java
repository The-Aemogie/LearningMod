package io.github.aemogie.learnmod.common.entity;

import io.github.aemogie.learnmod.client.renderer.entity.SeatRenderer;
import io.github.aemogie.learnmod.core.entitytypes.EntityTypesList;
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
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class SeatEntity extends ModEntity<SeatEntity> {
	private BlockPos source;
	
	private SeatEntity(World world, BlockPos source, double offset) {
		this(EntityTypesList.SEAT_ENTITY, world);
		this.source = source;
		this.setPos(
				this.source.getX() + 0.5d,
				this.source.getY() + offset,
				this.source.getZ() + 0.5d
		);
	}
	
	private SeatEntity(World world) {
		super(world);
	}
	
	public SeatEntity(EntityType<SeatEntity> entityType, World world) {
		super(entityType, world, SeatRenderer::new);
	}
	
	public static ActionResultType create(World world, BlockPos pos, double offset, PlayerEntity player) {
		if (!world.isClientSide()) {
			List<SeatEntity> seats = world.getEntitiesOfClass(SeatEntity.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 2.0, pos.getZ() + 1.0));
			if (seats.isEmpty()) {
				SeatEntity seat = new SeatEntity(world, pos, offset);
				world.addFreshEntity(seat);
				player.startRiding(seat, false);
			}
		}
		return ActionResultType.SUCCESS;
	}
	
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
}
