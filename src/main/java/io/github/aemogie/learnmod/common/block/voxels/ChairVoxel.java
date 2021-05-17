package io.github.aemogie.learnmod.common.block.voxels;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.stream.Stream;

import static io.github.aemogie.learnmod.util.VoxelUtils.shapeBuilder;

@SuppressWarnings({"CodeBlock2Expr"})
public class ChairVoxel {
    public static final VoxelShape COMMON_LOWER;
    public static final VoxelShape COMMON_UPPER;

    static {
        COMMON_LOWER = Stream.of(
                Block.box(0, 11, 0, 16, 15, 16),
                Block.box(12, 0, 1, 15, 11, 4),
                Block.box(1, 0, 1, 4, 11, 4),
                Block.box(12, 0, 12, 15, 11, 15),
                Block.box(1, 0, 12, 4, 11, 15)
        ).reduce((v1, v2) -> {
            return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
        }).get();
        COMMON_UPPER = Stream.of(
                Block.box(0, -5, 0, 16, -1, 16),
                Block.box(12, -16, 1, 15, -5, 4),
                Block.box(1, -16, 1, 4, -5, 4),
                Block.box(12, -16, 12, 15, -5, 15),
                Block.box(1, -16, 12, 4, -5, 15)
        ).reduce((v1, v2) -> {
            return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
        }).get();
    } //COMMON

    public static class Collision {
        public static final VoxelShape NORTH_LOWER;
        public static final VoxelShape EAST_LOWER;
        public static final VoxelShape SOUTH_LOWER;
        public static final VoxelShape WEST_LOWER;
        public static final VoxelShape NORTH_UPPER;
        public static final VoxelShape EAST_UPPER;
        public static final VoxelShape SOUTH_UPPER;
        public static final VoxelShape WEST_UPPER;
        static {
            NORTH_LOWER = Block.box(0, 15, 12, 16, 32, 16);
            NORTH_UPPER = Block.box(0, -1, 12, 16, 16, 16);
        } //NORTH

		static {
			EAST_LOWER = Block.box(0, 15, 0, 4, 32, 16);
			EAST_UPPER = Block.box(0, -1, 0, 4, 16, 16);
		} //EAST

		static {
			SOUTH_LOWER = Block.box(0, 15, 0, 16, 32, 4);
			SOUTH_UPPER = Block.box(0, -1, 0, 16, 16, 4);
		} //SOUTH

        static {
            WEST_LOWER = Block.box(12, 15, 0, 16, 32, 16);
            WEST_UPPER = Block.box(12, -1, 0, 16, 16, 16);
        } //WEST

        public static final VoxelShape NORTH_LOWER_FULL = shapeBuilder(COMMON_LOWER, NORTH_LOWER);
        public static final VoxelShape EAST_LOWER_FULL = shapeBuilder(COMMON_LOWER, EAST_LOWER);
        public static final VoxelShape SOUTH_LOWER_FULL = shapeBuilder(COMMON_LOWER, SOUTH_LOWER);
        public static final VoxelShape WEST_LOWER_FULL = shapeBuilder(COMMON_LOWER, WEST_LOWER);
        public static final VoxelShape NORTH_UPPER_FULL = shapeBuilder(COMMON_UPPER, NORTH_UPPER);
        public static final VoxelShape EAST_UPPER_FULL = shapeBuilder(COMMON_UPPER, EAST_UPPER);
        public static final VoxelShape SOUTH_UPPER_FULL = shapeBuilder(COMMON_UPPER, SOUTH_UPPER);
        public static final VoxelShape WEST_UPPER_FULL = shapeBuilder(COMMON_UPPER, WEST_UPPER);
    }

    public static class Occlusion {

        public static final VoxelShape NORTH_LOWER;
        public static final VoxelShape EAST_LOWER;
        public static final VoxelShape SOUTH_LOWER;
        public static final VoxelShape WEST_LOWER;
        public static final VoxelShape NORTH_UPPER;
        public static final VoxelShape EAST_UPPER;
        public static final VoxelShape SOUTH_UPPER;
        public static final VoxelShape WEST_UPPER;

        static {
            NORTH_LOWER = Stream.of(
                    Block.box(14, 15, 12, 16, 32, 16),
                    Block.box(12, 15, 13, 13, 30, 15),
                    Block.box(3, 15, 13, 4, 30, 15),
                    Block.box(5, 15, 13, 6, 30, 15),
                    Block.box(10, 15, 13, 11, 30, 15),
                    Block.box(8, 15, 13, 9, 30, 15),
                    Block.box(7, 15, 13, 8, 30, 15),
                    Block.box(0, 15, 12, 2, 32, 16),
                    Block.box(2, 30, 12, 14, 32, 16)
            ).reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
            }).get();
            NORTH_UPPER = Stream.of(
                    Block.box(14, -1, 12, 16, 16, 16),
                    Block.box(12, -1, 13, 13, 14, 15),
                    Block.box(3, -1, 13, 4, 14, 15),
                    Block.box(5, -1, 13, 6, 14, 15),
                    Block.box(10, -1, 13, 11, 14, 15),
                    Block.box(8, -1, 13, 9, 14, 15),
                    Block.box(7, -1, 13, 8, 14, 15),
                    Block.box(0, -1, 12, 2, 16, 16),
                    Block.box(2, 14, 12, 14, 16, 16)
            ).reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
            }).get();
        } //NORTH

        static {
            EAST_LOWER = Stream.of(
                    Block.box(0, 15, 14, 4, 32, 16),
                    Block.box(1, 15, 12, 3, 30, 13),
                    Block.box(1, 15, 3, 3, 30, 4),
                    Block.box(1, 15, 5, 3, 30, 6),
                    Block.box(1, 15, 10, 3, 30, 11),
                    Block.box(1, 15, 8, 3, 30, 9),
                    Block.box(1, 15, 7, 3, 30, 8),
                    Block.box(0, 15, 0, 4, 32, 2),
                    Block.box(0, 30, 2, 4, 32, 14)
            ).reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
            }).get();
            EAST_UPPER = Stream.of(
                    Block.box(0, -1, 14, 4, 16, 16),
                    Block.box(1, -1, 12, 3, 14, 13),
                    Block.box(1, -1, 3, 3, 14, 4),
                    Block.box(1, -1, 5, 3, 14, 6),
                    Block.box(1, -1, 10, 3, 14, 11),
                    Block.box(1, -1, 8, 3, 14, 9),
                    Block.box(1, -1, 7, 3, 14, 8),
                    Block.box(0, -1, 0, 4, 16, 2),
                    Block.box(0, 14, 2, 4, 16, 14)
            ).reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
            }).get();
        } //EAST

        static {
            SOUTH_LOWER = Stream.of(
                    Block.box(0, 15, 0, 2, 32, 4),
                    Block.box(3, 15, 1, 4, 30, 3),
                    Block.box(12, 15, 1, 13, 30, 3),
                    Block.box(10, 15, 1, 11, 30, 3),
                    Block.box(5, 15, 1, 6, 30, 3),
                    Block.box(7, 15, 1, 8, 30, 3),
                    Block.box(8, 15, 1, 9, 30, 3),
                    Block.box(14, 15, 0, 16, 32, 4),
                    Block.box(2, 30, 0, 14, 32, 4)
            ).reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
            }).get();
            SOUTH_UPPER = Stream.of(
                    Block.box(0, -1, 0, 2, 16, 4),
                    Block.box(3, -1, 1, 4, 14, 3),
                    Block.box(12, -1, 1, 13, 14, 3),
                    Block.box(10, -1, 1, 11, 14, 3),
                    Block.box(5, -1, 1, 6, 14, 3),
                    Block.box(7, -1, 1, 8, 14, 3),
                    Block.box(8, -1, 1, 9, 14, 3),
                    Block.box(14, -1, 0, 16, 16, 4),
                    Block.box(2, 14, 0, 14, 16, 4)
            ).reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
            }).get();
        } //SOUTH

        static {
            WEST_LOWER = Stream.of(
                    Block.box(12, 15, 0, 16, 32, 2),
                    Block.box(13, 15, 3, 15, 30, 4),
                    Block.box(13, 15, 12, 15, 30, 13),
                    Block.box(13, 15, 10, 15, 30, 11),
                    Block.box(13, 15, 5, 15, 30, 6),
                    Block.box(13, 15, 7, 15, 30, 8),
                    Block.box(13, 15, 8, 15, 30, 9),
                    Block.box(12, 15, 14, 16, 32, 16),
                    Block.box(12, 30, 2, 16, 32, 14)
            ).reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
            }).get();
            WEST_UPPER = Stream.of(
                    Block.box(12, -1, 0, 16, 16, 2),
                    Block.box(13, -1, 3, 15, 14, 4),
                    Block.box(13, -1, 12, 15, 14, 13),
                    Block.box(13, -1, 10, 15, 14, 11),
                    Block.box(13, -1, 5, 15, 14, 6),
                    Block.box(13, -1, 7, 15, 14, 8),
                    Block.box(13, -1, 8, 15, 14, 9),
                    Block.box(12, -1, 14, 16, 16, 16),
                    Block.box(12, 14, 2, 16, 16, 14)
            ).reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
            }).get();
        } //WEST

        public static final VoxelShape NORTH_LOWER_FULL = shapeBuilder(COMMON_LOWER, NORTH_LOWER);
        public static final VoxelShape EAST_LOWER_FULL = shapeBuilder(COMMON_LOWER, EAST_LOWER);
        public static final VoxelShape SOUTH_LOWER_FULL = shapeBuilder(COMMON_LOWER, SOUTH_LOWER);
        public static final VoxelShape WEST_LOWER_FULL = shapeBuilder(COMMON_LOWER, WEST_LOWER);
        public static final VoxelShape NORTH_UPPER_FULL = shapeBuilder(COMMON_UPPER, NORTH_UPPER);
        public static final VoxelShape EAST_UPPER_FULL = shapeBuilder(COMMON_UPPER, EAST_UPPER);
        public static final VoxelShape SOUTH_UPPER_FULL = shapeBuilder(COMMON_UPPER, SOUTH_UPPER);
        public static final VoxelShape WEST_UPPER_FULL = shapeBuilder(COMMON_UPPER, WEST_UPPER);
    }


}
