package com.abel.mymod;
import com.abel.mymod.datagen.ModBlockTagProvider;
import com.abel.mymod.datagen.ModItemTagProvider;
import com.abel.mymod.datagen.ModLootTableProvider;
import com.abel.mymod.datagen.ModModelProvider;
import com.abel.mymod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;



public class MyModDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}

}
