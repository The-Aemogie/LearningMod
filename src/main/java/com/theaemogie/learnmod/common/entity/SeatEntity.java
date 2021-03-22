package com.theaemogie.learnmod.common.entity;

import com.theaemogie.learnmod.core.entitytypes.EntityTypesList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
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
    private BlockPos offset;

    public SeatEntity(World world) {
        super(EntityTypesList.SEAT_ENTITY, world);
//        this.noClip = true;
    }

    private SeatEntity(World world, BlockPos source, BlockPos offset) {
        this(world);
        this.source = source;
        this.offset = offset;
        this.setPos(
                this.source.getX() + this.offset.getX(),
                this.source.getY() + this.offset.getY(),
                this.source.getZ() + this.offset.getZ()
        );
    }

    public static ActionResultType create( World world, BlockPos pos, BlockPos offset, PlayerEntity player) {
        if (!world.isClientSide()) {
            List<SeatEntity> seats = world.getEntitiesOfClass(SeatEntity.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0));
            if (seats.isEmpty()) {
                SeatEntity seat = new SeatEntity(world, pos, offset);
                world.addFreshEntity(seat);
                player.startRiding(seat, false);
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    protected void defineSynchedData() {
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
    protected void readAdditionalSaveData(CompoundNBT p_70037_1_) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT p_213281_1_) {
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

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
