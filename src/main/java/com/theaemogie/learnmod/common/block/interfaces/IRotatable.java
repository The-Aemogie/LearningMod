package com.theaemogie.learnmod.common.block.interfaces;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;


/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public interface IRotatable {

    DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    DirectionProperty FACING = BlockStateProperties.FACING;

    default BlockState rotateOnPlace(BlockItemUseContext context, BlockState defaultState, Boolean horizontalOnly) {
        BlockPos pos = context.getClickedPos();
        World world = context.getLevel();
        if (horizontalOnly) {
            return defaultState.setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
        } else {
            return defaultState.setValue(FACING, context.getClickedFace());
        }
    }

    default Direction getRotation(Entity entity){
        return Objects.requireNonNull(entity).getDirection().getOpposite();
    }
}
