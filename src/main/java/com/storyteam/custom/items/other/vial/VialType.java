package com.storyteam.custom.items.other.vial;

import com.storyteam.custom.CustomItemsManager;
import net.minecraft.item.Item;

public enum VialType {
    FULL, SUB_MEDIUM, MEDIUM, EMPTY;

    Item nextType() {
        return switch (this) {
            case FULL -> CustomItemsManager.SUB_MEDIUM_VIAL;
            case SUB_MEDIUM -> CustomItemsManager.MEDIUM_VIAL;
            case MEDIUM -> CustomItemsManager.EMPTY_VIAL;
            case EMPTY -> CustomItemsManager.EMPTY_VIAL;
            default -> CustomItemsManager.EMPTY_VIAL;
        };
    }
}
