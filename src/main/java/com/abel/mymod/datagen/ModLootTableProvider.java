package com.abel.mymod.datagen;

import com.abel.mymod.block.ModBlocks;
import com.abel.mymod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

// TODO: Implement proper loot table provider when needed
public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    public LootTable.Builder deeplsateOreDrops(Block drop, Item item, float max, float min) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    public void generate() {
    addDrop(ModBlocks.PINK_GARNET_BLOCK);
    addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK);
    addDrop(ModBlocks.MAGIC_BLOCK);
    addDrop(ModBlocks.PINK_GARNET_ORE,oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
    addDrop(ModBlocks.DEEPSLATE_PINK_GARNET_ORE,deeplsateOreDrops(ModBlocks.DEEPSLATE_PINK_GARNET_ORE,ModItems.RAW_PINK_GARNET,2,5));
    }
    // Placeholder class
}
