package com.storyteam.custom;

import com.storyteam.StoryTeam;
import com.storyteam.custom.items.combat.SpearsOfTheFather;
import com.storyteam.custom.items.jdh.JDHArmorItem;
import com.storyteam.custom.items.lo.LoArmorItem;
import com.storyteam.custom.items.money.MoneyItem;
import com.storyteam.custom.items.money.MoneyType;
import com.storyteam.custom.items.other.WaterBottle;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class CustomItemsManager {

    // Одежда Ло
    public static Item LO_SPECS;
    public static Item LO_JACKET;
    public static Item LO_LEGGINGS;
    public static Item LO_BOOTS;

    // Одежда Джона
    public static Item JDH_SPECS;
    public static Item JDH_JACKET;
    public static Item JDH_LEGGINGS;
    public static Item JDH_BOOTS;

    // Остальное
    public static Item WATER_BOTTLE;
    public static Item SPEARS_OF_THE_FATHER;

    // Деньги
        // V
    public static Item V_1;
    public static Item V_5;
    public static Item V_10;
    public static Item V_50;
    public static Item V_100;
        // ST
    public static Item ST_1;
    public static Item ST_5;
    public static Item ST_50;
    public static Item ST_100;
    public static Item ST_250;
    public static Item ST_500;

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(StoryTeam.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void init() {
        LO_SPECS = register(new LoArmorItem(CustomArmorMaterial.LO_ARMOR, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(10000).rarity(Rarity.EPIC)), "lo_specs");
        LO_JACKET = register(new LoArmorItem(CustomArmorMaterial.LO_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(10000).rarity(Rarity.EPIC)), "lo_jacket");
        LO_LEGGINGS = register(new LoArmorItem(CustomArmorMaterial.LO_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(10000).rarity(Rarity.EPIC)), "lo_leggins");
        LO_BOOTS = register(new LoArmorItem(CustomArmorMaterial.LO_ARMOR, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(10000).rarity(Rarity.EPIC)), "lo_boots");

        JDH_SPECS = register(new JDHArmorItem(CustomArmorMaterial.JDH_ARMOR, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(10000).rarity(Rarity.EPIC)), "jdh_specs");
        JDH_JACKET = register(new JDHArmorItem(CustomArmorMaterial.JDH_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(10000).rarity(Rarity.EPIC)), "jdh_jacket");
        JDH_LEGGINGS = register(new JDHArmorItem(CustomArmorMaterial.JDH_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(10000).rarity(Rarity.EPIC)), "jdh_leggins");
        JDH_BOOTS = register(new JDHArmorItem(CustomArmorMaterial.JDH_ARMOR, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(10000).rarity(Rarity.EPIC)), "jdh_boots");

        WATER_BOTTLE = register(new WaterBottle(new Item.Settings().maxCount(1)), "water_bottle");

         V_1 = register(new MoneyItem(MoneyType.V, Rarity.COMMON,1), "1v");
         V_5 = register(new MoneyItem(MoneyType.V, Rarity.UNCOMMON,5), "5v");
         V_10 = register(new MoneyItem(MoneyType.V, Rarity.RARE,10), "10v");
         V_50 = register(new MoneyItem(MoneyType.V, Rarity.RARE,50), "50v");
         V_100 = register(new MoneyItem(MoneyType.V, Rarity.EPIC,100), "100v");

         ST_1 = register(new MoneyItem(MoneyType.ST, Rarity.COMMON,1), "1st");
        ST_5 = register(new MoneyItem(MoneyType.ST, Rarity.UNCOMMON,5), "5st");
        ST_50 = register(new MoneyItem(MoneyType.ST, Rarity.RARE, 50), "50st");
        ST_100 = register(new MoneyItem(MoneyType.ST, Rarity.RARE,100), "100st");
        ST_250 = register(new MoneyItem(MoneyType.ST, Rarity.EPIC,250), "250st");
        ST_500 = register(new MoneyItem(MoneyType.ST, Rarity.EPIC,500), "500st");
        SPEARS_OF_THE_FATHER = register(new SpearsOfTheFather(CustomToolMaterials.SPEARS_OF_THE_FATHER, new Item.Settings().maxCount(1).rarity(Rarity.EPIC)), "spears_of_the_father");
    }
}

