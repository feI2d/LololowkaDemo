package com.storyteam.custom;

import lombok.Getter;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

@Getter
public enum CustomArmorMaterial implements ArmorMaterial {
    LO_ARMOR(10000, 4, 26, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, Ingredient.EMPTY, "Одежда Ло", 5, 0),
    JDH_ARMOR(10000, 4, 26, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, Ingredient.EMPTY, "Одежда Джона", 5, 0);
    private final int durability;
    private final int protection;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Ingredient repairIngredient;
    private final String name;
    private final float toughness;
    private final float knockbackResistance;

    CustomArmorMaterial(final int durability, final int protection, final int enchantability, final SoundEvent equipSound, final Ingredient repairIngredient, final String name, final float toughness, final float knockbackResistance) {
        this.durability = durability;
        this.protection = protection;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.repairIngredient = repairIngredient;
        this.name = name;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return durability;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protection;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
