package com.abel.mymod.util;

import com.abel.mymod.MyMod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        // Define block tags here
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MyMod.MOD_ID, name));
        }
    }
    public static class Items {
        // Define item tags here
        public static final TagKey<Item> MAGICALY_TRANSFORMABLE_ITEMS = createTag("magicaly_transformable_items");
        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, name));
        }
    }
}
