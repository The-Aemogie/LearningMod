package io.github.aemogie.learnmod.core.items;

import io.github.aemogie.learnmod.References;
import io.github.aemogie.learnmod.common.item.HammerItem;
import io.github.aemogie.learnmod.util.LoggerFormat;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.util.StringModifier.*;

@Mod.EventBusSubscriber(modid = References.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegister {
	
	public static Item register(ResourceLocation name, HammerItem hammerItem) {
		hammerItem.setRegistryName(name);
		if (hammerItem.getRegistryName() != null) {
			ItemLists.HAMMERS.add(hammerItem);
		} else {
			LOGGER.error(new IllegalArgumentException("Invalid registry name: " + name));
			System.exit(-1);
		}
		LOGGER.info(new LoggerFormat(
				modifyString("Successfully added item: "),
				modifyString(hammerItem.getRegistryName().toString(), GREEN, BOLD))
		);
		return hammerItem;
	}
	
	@SubscribeEvent
	public static void registerItemsEvent(final RegistryEvent.Register<Item> event) {
		ItemLists.HAMMERS.forEach(hammer -> event.getRegistry().register(hammer));
		ItemLists.HAMMERS.clear();
	}
	
}
