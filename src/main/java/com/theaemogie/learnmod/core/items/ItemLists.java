package com.theaemogie.learnmod.core.items;

import com.theaemogie.learnmod.common.item.Hammer;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ItemLists {
    public static final ArrayList<Hammer> HAMMERS = new ArrayList<>();

    public static final Item OBSIDIAN_HAMMER = ItemRegister.register(ItemNames.OBSIDIAN_HAMMER, new Hammer());
}
