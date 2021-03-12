package com.theaemogie.learnmod;

import com.theaemogie.learnmod.core.blocks.BlockLists;
import com.theaemogie.learnmod.core.items.ItemLists;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class LearnModGroups {

    public static class GlassLightGroup extends ItemGroup {
        public GlassLightGroup(String label) {
            super(label);
        }

        @SuppressWarnings("NullableProblems")
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockLists.MAGENTA_GLASS_LIGHT);
        }
    }

    public static class ChairGroup extends ItemGroup {
        public ChairGroup(String label) {
            super(label);
        }

        @SuppressWarnings("NullableProblems")
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockLists.ACACIA_LOG_CHAIR);
        }
    }

    public static class MiscGroup extends ItemGroup {
        public MiscGroup(String label) {
            super(label);
        }

        @SuppressWarnings("NullableProblems")
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemLists.OBSIDIAN_HAMMER);
        }
    }
}
