package io.github.aemogie.learnmod.util;

import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.Arrays;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public class VoxelUtils {
	
	@SuppressWarnings("OptionalGetWithoutIsPresent")
	public static VoxelShape shapeBuilder(VoxelShape... shapes) {
		return Arrays.stream(shapes).reduce(
				(v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)
		).get();
	}
}
