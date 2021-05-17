package io.github.aemogie.learnmod.common.block;

import io.github.aemogie.learnmod.common.block.interfaces.IDoubleBlock;
import io.github.aemogie.learnmod.common.block.voxels.ChairVoxel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

@SuppressWarnings({"NullableProblems", "deprecation"})
public class ChairBlock extends AbstractSeatBlock implements IDoubleBlock {
	
	public ChairBlock() {
		super(
				Properties
						.of(Material.WOOD)
						.sound(SoundType.WOOD)
						.strength(2.0f)
						.harvestTool(ToolType.AXE),
				0.75d
		);
		this.registerDefaultState(this.stateDefinition.any()
				.setValue(HORIZONTAL_FACING, Direction.NORTH)
				.setValue(HALF, DoubleBlockHalf.LOWER)
		);
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(HALF);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		DoubleBlockHalf half = state.getValue(HALF);
		Direction direction = state.getValue(HORIZONTAL_FACING);
		if (half == DoubleBlockHalf.LOWER) {
			switch (direction) {
				case NORTH:
					return ChairVoxel.Occlusion.NORTH_LOWER_FULL;
				case EAST:
					return ChairVoxel.Occlusion.EAST_LOWER_FULL;
				//                return Rotate.rotateShape(Direction.NORTH, Direction.EAST, ChairVoxel.GET);
				case SOUTH:
					return ChairVoxel.Occlusion.SOUTH_LOWER_FULL;
				//                return Rotate.rotateShape(Direction.NORTH, Direction.SOUTH, ChairVoxel.GET);
				case WEST:
					return ChairVoxel.Occlusion.WEST_LOWER_FULL;
				default:
					return null;
			}
		} else {
			switch (direction) {
				case NORTH:
					return ChairVoxel.Occlusion.NORTH_UPPER_FULL;
				case EAST:
					return ChairVoxel.Occlusion.EAST_UPPER_FULL;
				//                return Rotate.rotateShape(Direction.NORTH, Direction.EAST, ChairVoxel.GET);
				case SOUTH:
					return ChairVoxel.Occlusion.SOUTH_UPPER_FULL;
				//                return Rotate.rotateShape(Direction.NORTH, Direction.SOUTH, ChairVoxel.GET);
				case WEST:
					return ChairVoxel.Occlusion.WEST_UPPER_FULL;
				default:
					return null;
			}
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return canPlace(context, super.getStateForPlacement(context));
	}
	
	@Override
	public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		preventDropFromOppositePart(world, pos, state, player);
		super.playerWillDestroy(world, pos, state, player);
	}
	
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
	
	@Override
	public void setPlacedBy(World world, BlockPos pos, BlockState blockState, LivingEntity entity, ItemStack blockItemStack) {
		setOppositeHalf(world, pos, this.defaultBlockState().setValue(HORIZONTAL_FACING, getRotation(entity)));
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult subBlockPos) {
		return sit(world, pos, player, OFFSET, state.getValue(HALF));
	}
}