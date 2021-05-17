package io.github.aemogie.learnmod.core.blocks;

import io.github.aemogie.learnmod.References;
import net.minecraft.util.ResourceLocation;

/**
 * Creating the variables for the names of blocks.
 * (This is used mostly in the code and is the value shown when you turn on advanced-tooltips in game.)
 */
public class BlockNames {
	//region Create a local variable for easier usage of the MOD_ID in References
	private static final String MOD_ID = References.MOD_ID;
	//endregion
	
	public static final ResourceLocation INVALID_RENDER_MODE = new ResourceLocation(MOD_ID, "invalid_render_mode");
	
	//region Creating the variables for the names of blocks. (This is used mostly in the code and is the value shown when you turn on advanced-tooltips in game.)
	public static class GlassLightName {
		public static final ResourceLocation GLASS_LIGHT = new ResourceLocation(MOD_ID, "glass_light");
		public static final ResourceLocation WHITE_GLASS_LIGHT = new ResourceLocation(MOD_ID, "white_glass_light");
		public static final ResourceLocation ORANGE_GLASS_LIGHT = new ResourceLocation(MOD_ID, "orange_glass_light");
		public static final ResourceLocation MAGENTA_GLASS_LIGHT = new ResourceLocation(MOD_ID, "magenta_glass_light");
		public static final ResourceLocation LIGHT_BLUE_GLASS_LIGHT = new ResourceLocation(MOD_ID, "light_blue_glass_light");
		public static final ResourceLocation YELLOW_GLASS_LIGHT = new ResourceLocation(MOD_ID, "yellow_glass_light");
		public static final ResourceLocation LIME_GLASS_LIGHT = new ResourceLocation(MOD_ID, "lime_glass_light");
		public static final ResourceLocation PINK_GLASS_LIGHT = new ResourceLocation(MOD_ID, "pink_glass_light");
		public static final ResourceLocation GRAY_GLASS_LIGHT = new ResourceLocation(MOD_ID, "gray_glass_light");
		public static final ResourceLocation LIGHT_GRAY_GLASS_LIGHT = new ResourceLocation(MOD_ID, "light_gray_glass_light");
		public static final ResourceLocation CYAN_GLASS_LIGHT = new ResourceLocation(MOD_ID, "cyan_glass_light");
		public static final ResourceLocation PURPLE_GLASS_LIGHT = new ResourceLocation(MOD_ID, "purple_glass_light");
		public static final ResourceLocation BLUE_GLASS_LIGHT = new ResourceLocation(MOD_ID, "blue_glass_light");
		public static final ResourceLocation BROWN_GLASS_LIGHT = new ResourceLocation(MOD_ID, "brown_glass_light");
		public static final ResourceLocation GREEN_GLASS_LIGHT = new ResourceLocation(MOD_ID, "green_glass_light");
		public static final ResourceLocation RED_GLASS_LIGHT = new ResourceLocation(MOD_ID, "red_glass_light");
		public static final ResourceLocation BLACK_GLASS_LIGHT = new ResourceLocation(MOD_ID, "black_glass_light");
	}
	
	public static class ChairNames {
		public static final ResourceLocation OAK_LOG_CHAIR = new ResourceLocation(MOD_ID, "oak_log_chair");
		public static final ResourceLocation SPRUCE_LOG_CHAIR = new ResourceLocation(MOD_ID, "spruce_log_chair");
		public static final ResourceLocation BIRCH_LOG_CHAIR = new ResourceLocation(MOD_ID, "birch_log_chair");
		public static final ResourceLocation JUNGLE_LOG_CHAIR = new ResourceLocation(MOD_ID, "jungle_log_chair");
		public static final ResourceLocation ACACIA_LOG_CHAIR = new ResourceLocation(MOD_ID, "acacia_log_chair");
		public static final ResourceLocation DARK_OAK_LOG_CHAIR = new ResourceLocation(MOD_ID, "dark_oak_log_chair");
		public static final ResourceLocation STRIPPED_OAK_LOG_CHAIR = new ResourceLocation(MOD_ID, "stripped_oak_log_chair");
		public static final ResourceLocation STRIPPED_SPRUCE_LOG_CHAIR = new ResourceLocation(MOD_ID, "stripped_spruce_log_chair");
		public static final ResourceLocation STRIPPED_BIRCH_LOG_CHAIR = new ResourceLocation(MOD_ID, "stripped_birch_log_chair");
		public static final ResourceLocation STRIPPED_JUNGLE_LOG_CHAIR = new ResourceLocation(MOD_ID, "stripped_jungle_log_chair");
		public static final ResourceLocation STRIPPED_ACACIA_LOG_CHAIR = new ResourceLocation(MOD_ID, "stripped_acacia_log_chair");
		public static final ResourceLocation STRIPPED_DARK_OAK_LOG_CHAIR = new ResourceLocation(MOD_ID, "stripped_dark_oak_log_chair");
		public static final ResourceLocation OAK_PLANK_CHAIR = new ResourceLocation(MOD_ID, "oak_plank_chair");
		public static final ResourceLocation SPRUCE_PLANK_CHAIR = new ResourceLocation(MOD_ID, "spruce_plank_chair");
		public static final ResourceLocation BIRCH_PLANK_CHAIR = new ResourceLocation(MOD_ID, "birch_plank_chair");
		public static final ResourceLocation JUNGLE_PLANK_CHAIR = new ResourceLocation(MOD_ID, "jungle_plank_chair");
		public static final ResourceLocation ACACIA_PLANK_CHAIR = new ResourceLocation(MOD_ID, "acacia_plank_chair");
		public static final ResourceLocation DARK_OAK_PLANK_CHAIR = new ResourceLocation(MOD_ID, "dark_oak_plank_chair");
		public static final ResourceLocation CRIMSON_STEM_CHAIR = new ResourceLocation(MOD_ID, "crimson_stem_chair");
		public static final ResourceLocation STRIPPED_CRIMSON_STEM_CHAIR = new ResourceLocation(MOD_ID, "stripped_crimson_stem_chair");
		public static final ResourceLocation CRIMSON_PLANK_CHAIR = new ResourceLocation(MOD_ID, "crimson_plank_chair");
		public static final ResourceLocation WARPED_STEM_CHAIR = new ResourceLocation(MOD_ID, "warped_stem_chair");
		public static final ResourceLocation STRIPPED_WARPED_STEM_CHAIR = new ResourceLocation(MOD_ID, "stripped_warped_stem_chair");
		public static final ResourceLocation WARPED_PLANK_CHAIR = new ResourceLocation(MOD_ID, "warped_plank_chair");
	}
	//endregion
}
