package com.theaemogie.learnmod.common.block;

import com.theaemogie.learnmod.common.block.interfaces.IRotatable;
import com.theaemogie.learnmod.common.block.interfaces.ISittable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public abstract class AbstractSeatBlock extends Block implements ISittable, IRotatable, IWaterLoggable {

    protected final double OFFSET;

    public AbstractSeatBlock(Properties properties, final double OFFSET) {
        super(properties.noOcclusion());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HORIZONTAL_FACING, Direction.NORTH)
        );
        this.OFFSET = OFFSET;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return rotateOnPlace(context, this.defaultBlockState(), true);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult subBlockPos) {
        return sit(world, pos, player, OFFSET);
    }
}
