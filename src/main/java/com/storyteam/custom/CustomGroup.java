package com.storyteam.custom;

import com.storyteam.StoryTeam;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroupBuilderImpl;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CustomGroup {

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(StoryTeam.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CustomItemsManager.LO_SPECS))
            .displayName(Text.translatable("itemGroup.storyteam"))
            .build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CustomItemsManager.LO_SPECS);
            itemGroup.add(CustomItemsManager.LO_JACKET);
            itemGroup.add(CustomItemsManager.LO_LEGGINGS);
            itemGroup.add(CustomItemsManager.LO_BOOTS);
            itemGroup.add(CustomItemsManager.JDH_SPECS);
            itemGroup.add(CustomItemsManager.JDH_JACKET);
            itemGroup.add(CustomItemsManager.JDH_LEGGINGS);
            itemGroup.add(CustomItemsManager.JDH_BOOTS);
            itemGroup.add(CustomItemsManager.WATER_BOTTLE);
            itemGroup.add(CustomItemsManager.V_1);
            itemGroup.add(CustomItemsManager.V_5);
            itemGroup.add(CustomItemsManager.V_10);
            itemGroup.add(CustomItemsManager.V_50);
            itemGroup.add(CustomItemsManager.V_100);
            itemGroup.add(CustomItemsManager.ST_1);
            itemGroup.add(CustomItemsManager.ST_5);
            itemGroup.add(CustomItemsManager.ST_50);
            itemGroup.add(CustomItemsManager.ST_100);
            itemGroup.add(CustomItemsManager.ST_250);
            itemGroup.add(CustomItemsManager.ST_500);
            itemGroup.add(CustomItemsManager.SPEARS_OF_THE_FATHER);
        });
    }

}
