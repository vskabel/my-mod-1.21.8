# My Mod - Minecraft 1.21.8 Fabric Mod

## Overview
This is a Minecraft Fabric mod for version 1.21.8 that adds custom items, blocks, and gameplay features.

## Project Structure

### Main Classes
- `MyMod.java` - Main mod initialization class
- `MyModDataGenerator.java` - Data generation entry point

### Items (`com.abel.mymod.item`)
- `ModItems.java` - Item registration
- `ModItemGroups.java` - Creative tab configuration
- `ModFoodComponents.java` - Food item definitions
- Custom items:
  - `ChiselItem.java` - Tool for transforming blocks
  - `HammerItem.java` - Mining tool with area effect

### Blocks (`com.abel.mymod.block`)
- `ModBlocks.java` - Block registration
- Custom blocks:
  - `MagicBlock.java` - Block with special functionality

### Data Generation (`com.abel.mymod.datagen`)
- `ModBlockTagProvider.java` - Block tag generation
- `ModItemTagProvider.java` - Item tag generation
- `ModLootTableProvider.java` - Loot table generation (placeholder)
- `ModModelProvider.java` - Model generation (placeholder)
- `ModRecipeProvider.java` - Recipe generation (placeholder)

### Utilities
- `ModTags.java` - Custom tag definitions

## Added Items
- Pink Garnet - Custom gem material
- Raw Pink Garnet - Ore drop
- Cauliflower - Food item
- Star Power - Special item
- Chisel - Block transformation tool
- Hammer - Area mining tool

## Added Blocks
- Pink Garnet Block
- Raw Pink Garnet Block
- Pink Garnet Ore
- Deepslate Pink Garnet Ore
- Magic Block - Custom functionality block

## Known Issues
- Datagen providers need proper implementation for 1.21.8 API
- `getOrCreateTagBuilder()` method compatibility issues

## Build Instructions
```bash
./gradlew clean
./gradlew build
```

## Run Instructions
```bash
./gradlew runClient
```

## Data Generation
```bash
./gradlew runDatagen
```

## Localization
- English: `src/main/resources/assets/my_mod/lang/en_us.json`
- Hungarian: `src/main/resources/assets/my_mod/lang/hu_hu.json`

## Version Info
- Minecraft: 1.21.8
- Fabric Loader: (check gradle.properties)
- Fabric API: (check gradle.properties)
- Fabric Loom: 1.11.8
