package io.github.aemogie.learnmod.core.blocks;

import io.github.aemogie.learnmod.common.block.ChairBlock;
import io.github.aemogie.learnmod.common.block.GlassLightBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import java.util.ArrayList;

import static io.github.aemogie.learnmod.References.CHAIR_GROUP;
import static io.github.aemogie.learnmod.References.GLASS_LIGHT_GROUP;
import static io.github.aemogie.learnmod.core.blocks.BlockRegister.register;

/**
 * Class used for adding the Blocks to the relevant ArrayLists for registration.
 */
@SuppressWarnings("unused")
public class BlockLists {
	public static final ArrayList<Block> OPAQUE_BLOCKS = new ArrayList<>();
	public static final ArrayList<Block> TRANSLUCENT_BLOCKS = new ArrayList<>();
	public static final ArrayList<BlockItem> BLOCK_ITEMS = new ArrayList<>();
	public static final Block
	//Chairs
	OAK_LOG_CHAIR, SPRUCE_LOG_CHAIR, BIRCH_LOG_CHAIR, JUNGLE_LOG_CHAIR, ACACIA_LOG_CHAIR, DARK_OAK_LOG_CHAIR, CRIMSON_STEM_CHAIR, WARPED_STEM_CHAIR, STRIPPED_OAK_LOG_CHAIR, STRIPPED_SPRUCE_LOG_CHAIR, STRIPPED_BIRCH_LOG_CHAIR, STRIPPED_JUNGLE_LOG_CHAIR, STRIPPED_ACACIA_LOG_CHAIR, STRIPPED_DARK_OAK_LOG_CHAIR, STRIPPED_CRIMSON_STEM_CHAIR, STRIPPED_WARPED_STEM_CHAIR, OAK_PLANK_CHAIR, SPRUCE_PLANK_CHAIR, BIRCH_PLANK_CHAIR, JUNGLE_PLANK_CHAIR, ACACIA_PLANK_CHAIR, DARK_OAK_PLANK_CHAIR, CRIMSON_PLANK_CHAIR, WARPED_PLANK_CHAIR,
	//GLass Lights
	WHITE_GLASS_LIGHT, ORANGE_GLASS_LIGHT, MAGENTA_GLASS_LIGHT, LIGHT_BLUE_GLASS_LIGHT, YELLOW_GLASS_LIGHT, LIME_GLASS_LIGHT, PINK_GLASS_LIGHT, GRAY_GLASS_LIGHT, LIGHT_GRAY_GLASS_LIGHT, CYAN_GLASS_LIGHT, PURPLE_GLASS_LIGHT, BLUE_GLASS_LIGHT, BROWN_GLASS_LIGHT, GREEN_GLASS_LIGHT, RED_GLASS_LIGHT, BLACK_GLASS_LIGHT;
	
	static {
		OAK_LOG_CHAIR = register(BlockNames.ChairNames.OAK_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		SPRUCE_LOG_CHAIR = register(BlockNames.ChairNames.SPRUCE_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		BIRCH_LOG_CHAIR = register(BlockNames.ChairNames.BIRCH_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		JUNGLE_LOG_CHAIR = register(BlockNames.ChairNames.JUNGLE_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		ACACIA_LOG_CHAIR = register(BlockNames.ChairNames.ACACIA_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		DARK_OAK_LOG_CHAIR = register(BlockNames.ChairNames.DARK_OAK_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		CRIMSON_STEM_CHAIR = register(BlockNames.ChairNames.CRIMSON_STEM_CHAIR, new ChairBlock(), CHAIR_GROUP);
		WARPED_STEM_CHAIR = register(BlockNames.ChairNames.WARPED_STEM_CHAIR, new ChairBlock(), CHAIR_GROUP);
		STRIPPED_OAK_LOG_CHAIR = register(BlockNames.ChairNames.STRIPPED_OAK_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		STRIPPED_SPRUCE_LOG_CHAIR = register(BlockNames.ChairNames.STRIPPED_SPRUCE_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		STRIPPED_BIRCH_LOG_CHAIR = register(BlockNames.ChairNames.STRIPPED_BIRCH_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		STRIPPED_JUNGLE_LOG_CHAIR = register(BlockNames.ChairNames.STRIPPED_JUNGLE_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		STRIPPED_ACACIA_LOG_CHAIR = register(BlockNames.ChairNames.STRIPPED_ACACIA_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		STRIPPED_DARK_OAK_LOG_CHAIR = register(BlockNames.ChairNames.STRIPPED_DARK_OAK_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
		STRIPPED_CRIMSON_STEM_CHAIR = register(BlockNames.ChairNames.STRIPPED_CRIMSON_STEM_CHAIR, new ChairBlock(), CHAIR_GROUP);
		STRIPPED_WARPED_STEM_CHAIR = register(BlockNames.ChairNames.STRIPPED_WARPED_STEM_CHAIR, new ChairBlock(), CHAIR_GROUP);
		OAK_PLANK_CHAIR = register(BlockNames.ChairNames.OAK_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
		SPRUCE_PLANK_CHAIR = register(BlockNames.ChairNames.SPRUCE_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
		BIRCH_PLANK_CHAIR = register(BlockNames.ChairNames.BIRCH_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
		JUNGLE_PLANK_CHAIR = register(BlockNames.ChairNames.JUNGLE_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
		ACACIA_PLANK_CHAIR = register(BlockNames.ChairNames.ACACIA_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
		DARK_OAK_PLANK_CHAIR = register(BlockNames.ChairNames.DARK_OAK_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
		CRIMSON_PLANK_CHAIR = register(BlockNames.ChairNames.CRIMSON_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
		WARPED_PLANK_CHAIR = register(BlockNames.ChairNames.WARPED_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
		WHITE_GLASS_LIGHT = register(BlockNames.GlassLightName.WHITE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		ORANGE_GLASS_LIGHT = register(BlockNames.GlassLightName.ORANGE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		MAGENTA_GLASS_LIGHT = register(BlockNames.GlassLightName.MAGENTA_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		LIGHT_BLUE_GLASS_LIGHT = register(BlockNames.GlassLightName.LIGHT_BLUE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		YELLOW_GLASS_LIGHT = register(BlockNames.GlassLightName.YELLOW_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		LIME_GLASS_LIGHT = register(BlockNames.GlassLightName.LIME_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		PINK_GLASS_LIGHT = register(BlockNames.GlassLightName.PINK_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		GRAY_GLASS_LIGHT = register(BlockNames.GlassLightName.GRAY_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		LIGHT_GRAY_GLASS_LIGHT = register(BlockNames.GlassLightName.LIGHT_GRAY_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		CYAN_GLASS_LIGHT = register(BlockNames.GlassLightName.CYAN_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		PURPLE_GLASS_LIGHT = register(BlockNames.GlassLightName.PURPLE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		BLUE_GLASS_LIGHT = register(BlockNames.GlassLightName.BLUE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		BROWN_GLASS_LIGHT = register(BlockNames.GlassLightName.BROWN_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		GREEN_GLASS_LIGHT = register(BlockNames.GlassLightName.GREEN_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		RED_GLASS_LIGHT = register(BlockNames.GlassLightName.RED_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
		BLACK_GLASS_LIGHT = register(BlockNames.GlassLightName.BLACK_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
	}
}