package com.abel.mymod.datagen;

import com.abel.mymod.block.ModBlocks;
import com.abel.mymod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
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
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
    // Placeholder class
}
