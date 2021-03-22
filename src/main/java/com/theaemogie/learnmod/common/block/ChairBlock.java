package com.theaemogie.learnmod.common.block;

import com.theaemogie.learnmod.common.block.voxels.ChairVoxel;
import com.theaemogie.learnmod.common.entity.SeatEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Arrays;
import java.util.Objects;

public class ChairBlock extends Block {

    public static DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private static BlockPos offset = new BlockPos(0.5, 0.75, 0.5);

    public ChairBlock() {
        super(Properties.of(Material.WOOD)
                .sound(SoundType.WOOD)
                .strength(2.0f)
                .harvestTool(ToolType.AXE)
                .noOcclusion()
        );
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HORIZONTAL_FACING, Direction.NORTH)
                .setValue(HALF, DoubleBlockHalf.LOWER)
        );
    }

    protected static void preventCreativeDropFromBottomPart(World world, BlockPos pos, BlockState state, PlayerEntity player) {

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

    @SuppressWarnings({"deprecation", "NullableProblems"})
    @Override
    public VoxelShape getOcclusionShape(BlockState state, IBlockReader world, BlockPos pos) {
        return occlusionShapeProvider(state.getValue(HORIZONTAL_FACING), state.getValue(HALF));
    }

    @SuppressWarnings({"deprecation", "NullableProblems"})
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return occlusionShapeProvider(state.getValue(HORIZONTAL_FACING), state.getValue(HALF));
    }

    private VoxelShape occlusionShapeProvider(Direction direction, DoubleBlockHalf half) {
        if (half == DoubleBlockHalf.LOWER) {
            switch (direction) {
                case NORTH:
                    return shapeBuilder(ChairVoxel.COMMON_LOWER, ChairVoxel.Occlusion.NORTH_LOWER);
                case EAST:
                    return shapeBuilder(ChairVoxel.COMMON_LOWER, ChairVoxel.Occlusion.EAST_LOWER);
                //                return Rotate.rotateShape(Direction.NORTH, Direction.EAST, ChairVoxel.GET);
                case SOUTH:
                    return shapeBuilder(ChairVoxel.COMMON_LOWER, ChairVoxel.Occlusion.SOUTH_LOWER);
                //                return Rotate.rotateShape(Direction.NORTH, Direction.SOUTH, ChairVoxel.GET);
                case WEST:
                    return shapeBuilder(ChairVoxel.COMMON_LOWER, ChairVoxel.Occlusion.WEST_LOWER);
                default:
                    return null;
            }
        } else {
            switch (direction) {
                case NORTH:
                    return shapeBuilder(ChairVoxel.COMMON_UPPER, ChairVoxel.Occlusion.NORTH_UPPER);
                case EAST:
                    return shapeBuilder(ChairVoxel.COMMON_UPPER, ChairVoxel.Occlusion.EAST_UPPER);
                //                return Rotate.rotateShape(Direction.NORTH, Direction.EAST, ChairVoxel.GET);
                case SOUTH:
                    return shapeBuilder(ChairVoxel.COMMON_UPPER, ChairVoxel.Occlusion.SOUTH_UPPER);
                //                return Rotate.rotateShape(Direction.NORTH, Direction.SOUTH, ChairVoxel.GET);
                case WEST:
                    return shapeBuilder(ChairVoxel.COMMON_UPPER, ChairVoxel.Occlusion.WEST_UPPER);
                default:
                    return null;
            }
        }
    }
    
    private VoxelShape collisionShapeProvider(Direction direction, DoubleBlockHalf half) {
        if (half == DoubleBlockHalf.LOWER) {
            switch (direction) {
                case NORTH:
                    return shapeBuilder(ChairVoxel.COMMON_LOWER, ChairVoxel.Collision.NORTH_LOWER);
                case EAST:
                    return shapeBuilder(ChairVoxel.COMMON_LOWER, ChairVoxel.Collision.EAST_LOWER);
                //                return Rotate.rotateShape(Direction.NORTH, Direction.EAST, ChairVoxel.GET);
                case SOUTH:
                    return shapeBuilder(ChairVoxel.COMMON_LOWER, ChairVoxel.Collision.SOUTH_LOWER);
                //                return Rotate.rotateShape(Direction.NORTH, Direction.SOUTH, ChairVoxel.GET);
                case WEST:
                    return shapeBuilder(ChairVoxel.COMMON_LOWER, ChairVoxel.Collision.WEST_LOWER);
                default:
                    return null;
            }
        } else {
            switch (direction) {
                case NORTH:
                    return shapeBuilder(ChairVoxel.COMMON_UPPER, ChairVoxel.Collision.NORTH_UPPER);
                case EAST:
                    return shapeBuilder(ChairVoxel.COMMON_UPPER, ChairVoxel.Collision.EAST_UPPER);
                //                return Rotate.rotateShape(Direction.NORTH, Direction.EAST, ChairVoxel.GET);
                case SOUTH:
                    return shapeBuilder(ChairVoxel.COMMON_UPPER, ChairVoxel.Collision.SOUTH_UPPER);
                //                return Rotate.rotateShape(Direction.NORTH, Direction.SOUTH, ChairVoxel.GET);
                case WEST:
                    return shapeBuilder(ChairVoxel.COMMON_UPPER, ChairVoxel.Collision.WEST_UPPER);
                default:
                    return null;
            }
        }
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private VoxelShape shapeBuilder(VoxelShape... shapes) {
        return Arrays.stream(shapes).reduce(
                (v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)
        ).get();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HORIZONTAL_FACING);
        builder.add(HALF);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos pos = context.getClickedPos();
        World world = context.getLevel();
        int worldHeight = world.dimensionType().logicalHeight() - 1;
        BlockState blockAbove = world.getBlockState(pos.above());
        if (pos.getY() < worldHeight) {
            if (blockAbove.canBeReplaced(context)) {
                return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
            }
        }
        return null;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClientSide && player.isCreative()) {
            preventCreativeDropFromBottomPart(world, pos, state, player);
        }

        super.playerWillDestroy(world, pos, state, player);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = world.getBlockState(blockpos);

        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return blockstate.isFaceSturdy(world, blockpos, Direction.UP);
        } else {
            return blockstate.is(this);
        }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState blockState, LivingEntity entity, ItemStack blockItemStack) {
        world.setBlock(pos.above(), this.defaultBlockState()
                        .setValue(HALF, DoubleBlockHalf.UPPER)
                        .setValue(HORIZONTAL_FACING, Objects.requireNonNull(entity).getDirection().getOpposite())
                , 3
        );
    }

    @Override
    @SuppressWarnings({"deprecation", "NullableProblems"})
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            offset = new BlockPos(
                    offset.getX(),
                    offset.getY() - 1,
                    offset.getZ());
        }
        return SeatEntity.create(world, pos, offset, player);
    }
}