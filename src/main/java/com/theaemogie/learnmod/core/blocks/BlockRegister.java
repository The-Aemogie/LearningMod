package com.theaemogie.learnmod.core.blocks;

import com.theaemogie.learnmod.References;
import com.theaemogie.learnmod.util.LoggerFormat;
import com.theaemogie.learnmod.util.StringModifier;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

/**
 * Class used for registering Blocks and relevant BlockItems.
 * @author <a href="mailto:theaemogie@gmail.com">Aemogie.</a>
 */
@Mod.EventBusSubscriber(modid = References.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegister {

    private static final Logger LOGGER = References.LOGGER;

    @SuppressWarnings("unused")
    public static Block register(ResourceLocation name, Block block) {
        return register(
                name,
                block,
                References.MISC_GROUP
        );
    }

    /**
     * @param name  {@link ResourceLocation} - Name of block to be added.
     * @param block {@link Block} - Block specific properties.
     * @return {@link Block}
     */
    public static Block register(ResourceLocation name, Block block, ItemGroup group) {
        return register(
                name,
                block,
                group,
                "opaque"
        );
    }

    /**
     * @param render_mode {@link String} - Render Mode to be used. Possible inputs (Invalid inputs will result in the BlockItem being renamed to "Invalid Render Mode"): {
     *                    "opaque"
     *                    "translucent"
     *                    }
     * @return {@link Block}
     */
    public static Block register(ResourceLocation name, Block block, ItemGroup group, String render_mode) {
        return register(
                name,
                block,
                render_mode,
                new BlockItem(
                        block,
                        new Item.Properties()
                                .tab(group)
                )
        );
    }

    /**
     * @param blockItem {@link BlockItem} - BlockItem to be registered with the block.
     * @return {@link Block}
     */
    public static Block register(ResourceLocation name, Block block, String render_mode, BlockItem blockItem) {
        block.setRegistryName(name);
        switch (render_mode) {
            case "translucent":
                BlockLists.TRANSLUCENT_BLOCKS.add(block);
                break;
            case "opaque":
                BlockLists.OPAQUE_BLOCKS.add(block);
                break;
        }
        if (block.getRegistryName() != null) {
            blockItem.setRegistryName(name);
            BlockLists.BLOCK_ITEMS.add(blockItem);
        }
        return block;
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        BlockLists.OPAQUE_BLOCKS.forEach(block -> {
            event.getRegistry().register(block);
            LOGGER.info(new LoggerFormat(
                    modifyString(
                            "Successfully added block ",
                            35, 1
                    ),
                    modifyString(
                            Objects.requireNonNull(block.getRegistryName()).toString(), 32
                    )).get());
        });
        BlockLists.TRANSLUCENT_BLOCKS.forEach(block -> {
            event.getRegistry().register(block);
            LOGGER.info(new LoggerFormat(
                    modifyString(
                            "Successfully added block "
                    ),
                    modifyString(
                            Objects.requireNonNull(block.getRegistryName()).toString(), 32, 1
                    )).get());
        });
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        BlockLists.BLOCK_ITEMS.forEach(blockItem -> event.getRegistry().register(blockItem));
        BlockLists.BLOCK_ITEMS.clear();
    }

    private static String modifyString(String input, int... modifiers) {
        return new StringModifier().modifyString(input, modifiers);
    }
}