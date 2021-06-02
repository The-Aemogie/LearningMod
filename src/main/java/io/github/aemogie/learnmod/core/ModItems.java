package io.github.aemogie.learnmod.core;

import io.github.aemogie.learnmod.References;
import io.github.aemogie.learnmod.common.item.HammerItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, References.MOD_ID);
	
	public static final RegistryObject<Item> OBSIDIAN_HAMMER = ModItems.register("obsidian_hammer", new HammerItem());
	
	public static <T extends Item> RegistryObject<T> register(String name, T item) {
		return REGISTRY.register(name, () -> item);
	}
}
