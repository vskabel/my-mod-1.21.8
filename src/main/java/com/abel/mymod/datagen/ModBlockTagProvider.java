package com.abel.mymod.datagen;

import com.abel.mymod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output,  registriesFuture);
    }
    private Identifier idOf(Block block){
        return Registries.BLOCK.getId(block);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Add blocks to tags here
        getTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(idOf(ModBlocks.MAGIC_BLOCK))
                .add(idOf(ModBlocks.PINK_GARNET_BLOCK))
                .add(idOf(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .add(idOf(ModBlocks.PINK_GARNET_ORE))
                .add(idOf(ModBlocks.DEEPSLATE_PINK_GARNET_ORE));
        getTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(idOf(ModBlocks.DEEPSLATE_PINK_GARNET_ORE));
    }
}
