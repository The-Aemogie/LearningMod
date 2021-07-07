package io.github.aemogie.learnmod.util;

import net.minecraft.util.math.vector.Vector2f;

import static java.lang.Math.*;

public class Math {
	public static int getSectionIndex(Vector2f pos, final int noOfSections) throws IndexOutOfBoundsException {
		return getSectionIndex(pos, noOfSections, false);
	}
	
	public static int getSectionIndex(Vector2f pos, final int noOfSections, boolean throwError) throws IndexOutOfBoundsException {
		float x = pos.x, y = pos.y;
		//region Get the angle between lines {center}-{xAxis} and {center}-{pos}
		double angleRadians = atan2(y, x);
		//endregion
		//region Convert it to degrees and make the angle start from {yAxis} instead
		double angleDegrees = toDegrees(angleRadians) - 90;
		//endregion
		//region Make sure the angle wraps around
		if (angleDegrees > 0) angleDegrees = 360 - angleDegrees;
		//endregion
		//region Remove the sign of angle because previous 2 calculations made it negative
		angleDegrees = abs(angleDegrees);
		//endregion
		//region Get the index of the section {pos} lands in.
		int sectionIndex = (int) (angleDegrees / (360f / noOfSections));
		//endregion
		//region If it is an invalid value, set it to 0 or thrown an error.
		if (sectionIndex > noOfSections || sectionIndex < 0) {
			if (throwError) {
				throw new IndexOutOfBoundsException("Output section index \"" + sectionIndex + "\" is out of bounds.");
			} else {
				sectionIndex = 0;
			}
		}
		//endregion
		return sectionIndex;
	}
	
	public static Vector2f fromBlockCenter(Vector2f vec2) {
		return new Vector2f(vec2.x - 0.5f, vec2.y - 0.5f);
	}
}
