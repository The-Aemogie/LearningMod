package com.theaemogie.learnmod.core.blocks;

import com.theaemogie.learnmod.References;
import com.theaemogie.learnmod.common.block.ChairBlock;
import com.theaemogie.learnmod.common.block.GlassLightBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;

/**
 * Class used for adding the Blocks to the relevant ArrayLists for registration.
 */
@SuppressWarnings("unused")
public class BlockLists {
    //region ArrayLists for the Blocks depending on their render type.
    public static final ArrayList<Block> OPAQUE_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> TRANSLUCENT_BLOCKS = new ArrayList<>();
    //endregion
    //region ArrayLists for the relevant BlockItems.
    public static final ArrayList<BlockItem> BLOCK_ITEMS = new ArrayList<>();
    //endregion
    private static final ItemGroup MISC_GROUP = References.MISC_GROUP;
    private static final ItemGroup GLASS_LIGHT_GROUP = References.GLASS_LIGHT_GROUP;
    private static final ItemGroup CHAIR_GROUP = References.CHAIR_GROUP;

    //region Adding the Blocks to the relevant ArrayList for registration. (Done using BlockRegister.register() method)

    public static final Block WHITE_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.WHITE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block ORANGE_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.ORANGE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block MAGENTA_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.MAGENTA_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block LIGHT_BLUE_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.LIGHT_BLUE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block YELLOW_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.YELLOW_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block LIME_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.LIME_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block PINK_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.PINK_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block GRAY_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.GRAY_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block LIGHT_GRAY_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.LIGHT_GRAY_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block CYAN_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.CYAN_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block PURPLE_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.PURPLE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block BLUE_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.BLUE_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block BROWN_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.BROWN_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block GREEN_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.GREEN_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block RED_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.RED_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");
    public static final Block BLACK_GLASS_LIGHT = BlockRegister.register(BlockNames.GlassLightName.BLACK_GLASS_LIGHT, new GlassLightBlock(), GLASS_LIGHT_GROUP, "translucent");

    public static final Block SPRUCE_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.SPRUCE_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block OAK_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.OAK_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block BIRCH_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.BIRCH_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block JUNGLE_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.JUNGLE_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block ACACIA_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.ACACIA_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block DARK_OAK_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.DARK_OAK_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block STRIPPED_OAK_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.STRIPPED_OAK_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block STRIPPED_SPRUCE_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.STRIPPED_SPRUCE_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block STRIPPED_BIRCH_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.STRIPPED_BIRCH_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block STRIPPED_JUNGLE_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.STRIPPED_JUNGLE_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block STRIPPED_ACACIA_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.STRIPPED_ACACIA_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block STRIPPED_DARK_OAK_LOG_CHAIR = BlockRegister.register(BlockNames.ChairNames.STRIPPED_DARK_OAK_LOG_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block OAK_PLANK_CHAIR = BlockRegister.register(BlockNames.ChairNames.OAK_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block SPRUCE_PLANK_CHAIR = BlockRegister.register(BlockNames.ChairNames.SPRUCE_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block BIRCH_PLANK_CHAIR = BlockRegister.register(BlockNames.ChairNames.BIRCH_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block JUNGLE_PLANK_CHAIR = BlockRegister.register(BlockNames.ChairNames.JUNGLE_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block ACACIA_PLANK_CHAIR = BlockRegister.register(BlockNames.ChairNames.ACACIA_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block DARK_OAK_PLANK_CHAIR = BlockRegister.register(BlockNames.ChairNames.DARK_OAK_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block CRIMSON_STEM_CHAIR = BlockRegister.register(BlockNames.ChairNames.CRIMSON_STEM_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block STRIPPED_CRIMSON_STEM_CHAIR = BlockRegister.register(BlockNames.ChairNames.STRIPPED_CRIMSON_STEM_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block CRIMSON_PLANK_CHAIR = BlockRegister.register(BlockNames.ChairNames.CRIMSON_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block WARPED_STEM_CHAIR = BlockRegister.register(BlockNames.ChairNames.WARPED_STEM_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block STRIPPED_WARPED_STEM_CHAIR = BlockRegister.register(BlockNames.ChairNames.STRIPPED_WARPED_STEM_CHAIR, new ChairBlock(), CHAIR_GROUP);
    public static final Block WARPED_PLANK_CHAIR = BlockRegister.register(BlockNames.ChairNames.WARPED_PLANK_CHAIR, new ChairBlock(), CHAIR_GROUP);

    //endregion
}