package io.github.aemogie.learnmod.core.items;

import io.github.aemogie.learnmod.common.item.HammerItem;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ItemLists {
	public static final ArrayList<HammerItem> HAMMERS = new ArrayList<>();
	
	public static final Item OBSIDIAN_HAMMER = ItemRegister.register(ItemNames.OBSIDIAN_HAMMER, new HammerItem());
}
