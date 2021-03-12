package com.theaemogie.learnmod.common.block;

import com.theaemogie.learnmod.common.block.voxels.ChairVoxel;
import com.theaemogie.learnmod.common.entity.SeatEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import java.util.Arrays;

public class ChairBlock extends Block {

    private static final double offset = 0.75;
    public static DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ChairBlock() {
        super(Properties.of(Material.WOOD)
                .sound(SoundType.WOOD)
                .dynamicShape()
                .strength(2.0f)
                .harvestTool(ToolType.AXE)
        );
        this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH));
    }

    @SuppressWarnings({"deprecation", "NullableProblems"})
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shapeProvider(state.getValue(HORIZONTAL_FACING));
    }

    private VoxelShape shapeProvider(Direction direction) {
        switch (direction) {
            case NORTH:
                return shapeBuilder(ChairVoxel.COMMON, ChairVoxel.NORTH);
            case EAST:
                return shapeBuilder(ChairVoxel.COMMON, ChairVoxel.EAST);
//                return Rotate.rotateShape(Direction.NORTH, Direction.EAST, ChairVoxel.GET);
            case SOUTH:
                return shapeBuilder(ChairVoxel.COMMON, ChairVoxel.SOUTH);
//                return Rotate.rotateShape(Direction.NORTH, Direction.SOUTH, ChairVoxel.GET);
            case WEST:
                return shapeBuilder(ChairVoxel.COMMON, ChairVoxel.WEST);
            default:
                return null;
        }
    }

    private VoxelShape shapeBuilder(VoxelShape... shapes) {
        return Arrays.stream(shapes).reduce((v1, v2) -> {
            return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
        }).get();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HORIZONTAL_FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }


    @Override
    @SuppressWarnings({"deprecation", "NullableProblems"})
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        return SeatEntity.create(world, pos, offset, player);
    }
}