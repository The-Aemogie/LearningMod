package com.theaemogie.learnmod.common.block.interfaces;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public interface IDoubleBlock {

    EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    default void preventDropFromOppositePart(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClientSide()) {
            DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
            BlockPos secondPos;

            if (doubleblockhalf == DoubleBlockHalf.UPPER) {
                secondPos = pos.below();
            } else {
                secondPos = pos.above();
            }

            BlockState secondState = world.getBlockState(secondPos);

            if (secondState.getBlock() == state.getBlock() && secondState.getValue(HALF) != state.getValue(HALF)) {
                world.setBlock(secondPos, Blocks.AIR.defaultBlockState(), 35);
                world.levelEvent(player, 2001, secondPos, Block.getId(secondState));
            }
        }
    }

    default BlockState canPlace(BlockItemUseContext context, BlockState defaultState) {
        BlockPos pos = context.getClickedPos();
        World world = context.getLevel();
        int worldHeight = world.dimensionType().logicalHeight() - 1;
        BlockState blockAbove = world.getBlockState(pos.above());
        if (pos.getY() < worldHeight) {
            if (blockAbove.canBeReplaced(context)) {
                return defaultState;
            }
        }
        return null;
    }

    default void setOppositeHalf(World world, BlockPos pos, BlockState state) {
        DoubleBlockHalf currentHalf = state.getValue(HALF);
        DoubleBlockHalf nextHalf;
        BlockPos nextPos;
        if (currentHalf == DoubleBlockHalf.UPPER) {
            nextPos = pos.below();
            nextHalf = DoubleBlockHalf.LOWER;
        } else {
            nextPos = pos.above();
            nextHalf = DoubleBlockHalf.UPPER;
        }
        world.setBlock(
                nextPos,
                state.setValue(HALF,nextHalf),
                3
        );
    }
}
