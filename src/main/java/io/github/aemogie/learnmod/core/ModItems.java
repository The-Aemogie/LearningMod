package io.github.aemogie.learnmod.core;

import io.github.aemogie.learnmod.References;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static io.github.aemogie.learnmod.References.MISC_GROUP;

@SuppressWarnings("unused")
public class ModItems {
	
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, References.MOD_ID);
	
	public static final RegistryObject<Item> PIZZA_SLICE = register("pizza_slice", new Item(new Item.Properties().food(new Food.Builder().nutrition(6).saturationMod(1.2f).build()).tab(MISC_GROUP)));
	
	public static <T extends Item> RegistryObject<T> register(String name, T item) {
		return REGISTRY.register(name, () -> item);
	}
}
