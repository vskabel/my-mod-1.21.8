package com.abel.mymod.item;

import com.abel.mymod.MyMod;
import com.abel.mymod.item.custom.ChiselItem;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Items
    public static final Item PINK_GARNET = registerItem("pink_garnet");
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet");
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, "chisel")))));

    // Food Items
    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(ModFoodComponents.createFoodItemSettings("cauliflower", ModFoodComponents.CAULIFLOWER)));
        
    //Fuel items
    public static final  Item STAR_POWER = registerItem("star_power");
    

    // Helper method to register items
    private static Item registerItem(String name) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, name));
        return registerItem(name, new Item(new Item.Settings().registryKey(key)));
    }

    private static Item registerItem(String name, Item item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, item);
    }

    // Register items and add to creative tab
    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.add(CHISEL);
            entries.add(STAR_POWER);   
            entries.add(CAULIFLOWER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CAULIFLOWER);
        });
    }
}