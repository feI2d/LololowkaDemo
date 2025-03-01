package com.storyteam.custom.items.other.vial;

import lombok.Getter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Rarity;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

@Getter
public class Vial extends HoneyBottleItem {

    private final VialType type;

    public Vial(VialType type) {
        super(new Settings().maxCount(1).rarity(Rarity.EPIC));
        this.type = type;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient) {
            user.removeStatusEffect(StatusEffects.POISON);
        }

        if (user instanceof PlayerEntity playerEntity) {
            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 140));
            if (!playerEntity.isCreative()) {
                ItemStack itemStack = new ItemStack(type.nextType());
                playerEntity.getInventory().setStack(playerEntity.getInventory().selectedSlot, itemStack);
            }
        }

        return stack;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        if (this.type == VialType.EMPTY) return UseAction.BLOCK;
        else return super.getUseAction(stack);
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return switch (type) {
            case FULL -> 40;
            case SUB_MEDIUM -> 30;
            case MEDIUM -> 20;
            case EMPTY -> 0;
        };
    }

}
