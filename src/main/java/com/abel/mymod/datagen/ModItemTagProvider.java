package com.abel.mymod.datagen;

import java.util.concurrent.CompletableFuture;

import com.abel.mymod.item.ModItems;
import com.abel.mymod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    private Identifier idOf(Item item){
        return Registries.ITEM.getId(item);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(ModTags.Items.MAGICALY_TRANSFORMABLE_ITEMS)
                .add(idOf(ModItems.PINK_GARNET))
                .add(idOf(ModItems.RAW_PINK_GARNET))
                .add(idOf(Items.COAL))
                .add(idOf(Items.STICK))
                .add(idOf(Items.APPLE));

    }
}
