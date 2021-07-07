package io.github.aemogie.learnmod.core;

import io.github.aemogie.learnmod.common.block.ChairBlock;
import io.github.aemogie.learnmod.common.block.GlassLightBlock;
import io.github.aemogie.learnmod.common.block.ModBlock;
import io.github.aemogie.learnmod.common.block.PizzaBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

import static io.github.aemogie.learnmod.References.*;
import static net.minecraft.client.renderer.RenderType.solid;
import static net.minecraft.client.renderer.RenderTypeLookup.setRenderLayer;
import static net.minecraftforge.registries.ForgeRegistries.BLOCKS;

@SuppressWarnings("unused")
public class ModBlocks {
	
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BLOCKS, MOD_ID);
	
	public static final RegistryObject<ModBlock> OAK_LOG_CHAIR = register("oak_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> SPRUCE_LOG_CHAIR = register("spruce_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> BIRCH_LOG_CHAIR = register("birch_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> JUNGLE_LOG_CHAIR = register("jungle_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> ACACIA_LOG_CHAIR = register("acacia_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> DARK_OAK_LOG_CHAIR = register("dark_oak_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> CRIMSON_STEM_CHAIR = register("crimson_stem_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> WARPED_STEM_CHAIR = register("warped_stem_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> STRIPPED_OAK_LOG_CHAIR = register("stripped_oak_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> STRIPPED_SPRUCE_LOG_CHAIR = register("stripped_spruce_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> STRIPPED_BIRCH_LOG_CHAIR = register("stripped_birch_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> STRIPPED_JUNGLE_LOG_CHAIR = register("stripped_jungle_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> STRIPPED_ACACIA_LOG_CHAIR = register("stripped_acacia_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> STRIPPED_DARK_OAK_LOG_CHAIR = register("stripped_dark_oak_log_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> STRIPPED_CRIMSON_STEM_CHAIR = register("stripped_crimson_stem_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> STRIPPED_WARPED_STEM_CHAIR = register("stripped_warped_stem_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> OAK_PLANK_CHAIR = register("oak_plank_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> SPRUCE_PLANK_CHAIR = register("spruce_plank_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> BIRCH_PLANK_CHAIR = register("birch_plank_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> JUNGLE_PLANK_CHAIR = register("jungle_plank_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> ACACIA_PLANK_CHAIR = register("acacia_plank_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> DARK_OAK_PLANK_CHAIR = register("dark_oak_plank_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> CRIMSON_PLANK_CHAIR = register("crimson_plank_chair", new ChairBlock(solid()), CHAIR_GROUP);
	public static final RegistryObject<ModBlock> WARPED_PLANK_CHAIR = register("warped_plank_chair", new ChairBlock(solid()), CHAIR_GROUP);
	
	public static final RegistryObject<ModBlock> WHITE_GLASS_LIGHT = register("white_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> ORANGE_GLASS_LIGHT = register("orange_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> MAGENTA_GLASS_LIGHT = register("magenta_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> LIGHT_BLUE_GLASS_LIGHT = register("light_blue_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> YELLOW_GLASS_LIGHT = register("yellow_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> LIME_GLASS_LIGHT = register("lime_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> PINK_GLASS_LIGHT = register("pink_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> GRAY_GLASS_LIGHT = register("gray_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> LIGHT_GRAY_GLASS_LIGHT = register("light_gray_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> CYAN_GLASS_LIGHT = register("cyan_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> PURPLE_GLASS_LIGHT = register("purple_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> BLUE_GLASS_LIGHT = register("blue_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> BROWN_GLASS_LIGHT = register("brown_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> GREEN_GLASS_LIGHT = register("green_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> RED_GLASS_LIGHT = register("red_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	public static final RegistryObject<ModBlock> BLACK_GLASS_LIGHT = register("black_glass_light", new GlassLightBlock(), GLASS_LIGHT_GROUP);
	
	public static final RegistryObject<ModBlock> PIZZA_4 = register("pizza_4", PizzaBlock.createPizza(4), MISC_GROUP);
	public static final RegistryObject<ModBlock> PIZZA_8 = register("pizza_8", PizzaBlock.createPizza(8), MISC_GROUP);
	
	public static <T extends ModBlock> RegistryObject<T> register(String name, T block, ItemGroup group) {
		return group != null ? register(name, block, new BlockItem(block, new Item.Properties().tab(group))) : register(name, block, () -> null);
	}
	
	public static <T extends ModBlock> RegistryObject<T> register(String name, T block, BlockItem blockItem) {
		RegistryObject<T> ro = REGISTRY.register(name, () -> block);
//		if (block.RENDER_MODE.equals("translucent")) BlockLists.TRANSLUCENT_BLOCKS.add(ro.get());
		if (blockItem != null) ModItems.REGISTRY.register(name, () -> blockItem);
		return ro;
	}
	
	public static <T extends ModBlock> RegistryObject<T> register(String name, T block, Supplier<? extends BlockItem> itemSupply) {
		RegistryObject<T> ro = REGISTRY.register(name, () -> block);
		if (itemSupply.get() != null) ModItems.REGISTRY.register(name, itemSupply);
		return ro;
	}
	
	public static <T extends ModBlock> RegistryObject<T> register(String name, T block, Function<Block, ? extends BlockItem> itemFunc) {
		RegistryObject<T> ro = REGISTRY.register(name, () -> block);
		if (itemFunc.apply(block) != null) ModItems.REGISTRY.register(name, () -> itemFunc.apply(block));
		return ro;
	}
	
	public static void setupRenderers() {
		for (RegistryObject<Block> block : REGISTRY.getEntries()) {
			ModBlock modBlock = (ModBlock) block.get();
			setRenderLayer(modBlock, modBlock.RENDER_MODE);
		}
	}
}