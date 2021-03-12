package com.theaemogie.learnmod.core.items;

import com.theaemogie.learnmod.References;
import com.theaemogie.learnmod.common.item.Hammer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = References.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegister {

    private static final Logger LOGGER = References.LOGGER;

    public static Item register(ResourceLocation name, Hammer hammerItem) {
        hammerItem.setRegistryName(name);
        if (hammerItem.getRegistryName() != null) {
            ItemLists.HAMMERS.add(hammerItem);
        } else {
            LOGGER.error(new IllegalArgumentException("Invalid registry name:" + name));
            hammerItem.setRegistryName(ItemNames.INVALID_LOCATION);
        }
        return hammerItem;
    }

    @SubscribeEvent
    public static void registerItemsEvent(final RegistryEvent.Register<Item> event) {
        ItemLists.HAMMERS.forEach(hammer -> event.getRegistry().register(hammer));
        ItemLists.HAMMERS.clear();
    }

}
