package io.github.aemogie.learnmod.common.block.interfaces;

import io.github.aemogie.learnmod.common.entity.SeatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public interface ISittable {
	
	default ActionResultType sit(World world, BlockPos pos, PlayerEntity player, double offset) {
		return SeatEntity.create(world, pos, offset, player);
	}
	
	default ActionResultType sit(World world, BlockPos pos, PlayerEntity player, double offset, DoubleBlockHalf half) {
		if (half == DoubleBlockHalf.UPPER) {
			pos = pos.below();
		}
		return sit(world, pos, player, offset);
	}
	
}
