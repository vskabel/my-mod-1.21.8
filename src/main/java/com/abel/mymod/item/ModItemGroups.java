package com.abel.mymod.item;


import com.abel.mymod.MyMod;
import com.abel.mymod.block.ModBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> PINK_GARNET_ITEMGROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(MyMod.MOD_ID, "pink_garnet_itemgroup"));

    public static final ItemGroup PINK_GARNET_ITEMGROUP = Registry.register(Registries.ITEM_GROUP,
            PINK_GARNET_ITEMGROUP_KEY,
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.my_mod.pink_garnet_itemgroup"))
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        // Currently empty, but can be used to define custom item groups in the future
    }
}
