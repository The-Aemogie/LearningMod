package com.theaemogie.learnmod.common.block.voxels;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.stream.Stream;

@SuppressWarnings({"CodeBlock2Expr", "OctalInteger"})
public class ChairVoxel {
    public static final VoxelShape COMMON;
    public static final VoxelShape NORTH;
    public static final VoxelShape EAST;
    public static final VoxelShape SOUTH;
    public static final VoxelShape WEST;

    static {
        COMMON = Stream.of(
                Block.box(0, 11, 0, 16, 15, 16),
                Block.box(12, 0, 1, 15, 11, 4),
                Block.box(1, 0, 1, 4, 11, 4),
                Block.box(12, 0, 12, 15, 11, 15),
                Block.box(1, 0, 12, 4, 11, 15)
        ).reduce((v1, v2) -> {
            return VoxelShapes.join(v1, v2, IBooleanFunction.OR);
        }).get();
    } //COMMON

    static {
        NORTH = Stream.of(
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
    } //NORTH

    static {
        EAST = Stream.of(
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
    } //EAST

    static {
        SOUTH = Stream.of(
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
    } //SOUTH

    static {
        WEST = Stream.of(
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
    } //WEST
}
