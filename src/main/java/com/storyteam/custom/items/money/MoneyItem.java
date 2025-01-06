package com.storyteam.custom.items.money;

import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

@Getter
public class MoneyItem extends Item {

    private final MoneyType type;
    private final int nominal;

    public MoneyItem(MoneyType type, Rarity rarity, int nominal) {
        super(new Settings().maxCount(64).rarity(rarity));
        this.type = type;
        this.nominal = nominal;
    }

}
