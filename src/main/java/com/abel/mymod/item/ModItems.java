package com.abel.mymod.item;

import com.abel.mymod.MyMod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Here we will add all our items
    public static final Item PINK_GARNET = registerItem("pink_garnet",
        new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, "pink_garnet")))));
    
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, "raw_pink_garnet")))));



    // Helper method to register items
    public static Item registerItem(String name, Item item) {
        Identifier id = Identifier.of(MyMod.MOD_ID, name);
        return Registry.register(Registries.ITEM, id, item);
    }

    // Method to register the items
    public static void registerModItems() {
        // MyMod.LOGGER.info("Registering mod items" + MyMod.MOD_ID);
        // Adding the item to a creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }

}
