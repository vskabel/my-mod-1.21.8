package com.abel.mymod.datagen;

import com.abel.mymod.block.ModBlocks;
import com.abel.mymod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

// TODO: Implement proper recipe provider when needed
public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(
                    ModItems.RAW_PINK_GARNET,
                    ModBlocks.PINK_GARNET_ORE,
                    ModBlocks.DEEPSLATE_PINK_GARNET_ORE
                );

                // Smelting recipe
                offerSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC,
                    ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");

                // Blasting recipe (faster)
                offerBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC,
                    ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

                // Raw Pink Garnet Block crafting (3x3)
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_PINK_GARNET)
                        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                        .offerTo(exporter);

                // Raw Pink Garnet from block (shapeless)
                createShapeless(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                        .offerTo(exporter);

            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
    // Placeholder class
}
