package com.abel.mymod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.abel.mymod.block.ModBlocks;
import com.abel.mymod.item.ModItems;

public class MyMod implements ModInitializer {
	public static final String MOD_ID = "my_mod";
	//public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}