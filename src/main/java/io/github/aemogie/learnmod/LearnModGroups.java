package io.github.aemogie.learnmod;

import io.github.aemogie.learnmod.core.ModBlocks;
import io.github.aemogie.learnmod.core.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class LearnModGroups {
	
	public static class LightingAndDecor extends ItemGroup {
		public LightingAndDecor(String label) {
			super(label);
		}
		
		@SuppressWarnings("NullableProblems")
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlocks.MAGENTA_GLASS_LIGHT.get());
		}
	}
	
	public static class Furniture extends ItemGroup {
		public Furniture(String label) {
			super(label);
		}
		
		@SuppressWarnings("NullableProblems")
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlocks.ACACIA_LOG_CHAIR.get());
		}
	}
	
	public static class MiscGroup extends ItemGroup {
		public MiscGroup(String label) {
			super(label);
		}
		
		@SuppressWarnings("NullableProblems")
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.OBSIDIAN_HAMMER.get());
		}
	}
}
