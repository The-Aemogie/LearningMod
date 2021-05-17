package io.github.aemogie.learnmod.common.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ItemTier implements IItemTier {
	OBSIDIAN(4, 2031, 9.0F, 4.0F, 15, () -> {
		return Ingredient.of(Items.OBSIDIAN);
	});
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantmentValue;
	private final LazyValue<Ingredient> repairMaterial;
	
	ItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantmentValueIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantmentValue = enchantmentValueIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}
	
	
	public int getUses() {
		return this.maxUses;
	}
	
	public float getSpeed() {
		return this.efficiency;
	}
	
	public float getAttackDamageBonus() {
		return this.attackDamage;
	}
	
	public int getLevel() {
		return this.harvestLevel;
	}
	
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}
}
