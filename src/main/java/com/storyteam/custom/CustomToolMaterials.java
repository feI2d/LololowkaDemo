package com.storyteam.custom;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum CustomToolMaterials implements ToolMaterial {
    SPEARS_OF_THE_FATHER(-1, 0.2f, 70, 26, 0, Ingredient.EMPTY);

    private final int durability;
    private final float miningSpeedMultiplier;
    private final float attackDamage;
    private final int enchantability;
    private final int miningLevel;
    private final Ingredient repairIngridient;

    CustomToolMaterials(final int durability, final float miningSpeedMultiplier, final float attackDamage, final int enchantability, final int miningLevel, Ingredient repairIngridient) {
        this.durability = durability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.miningLevel = miningLevel;
        this.repairIngridient = repairIngridient;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getMiningLevel() {return miningLevel;}

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngridient;
    }
}
