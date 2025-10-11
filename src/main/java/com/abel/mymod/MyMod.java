package com.abel.mymod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abel.mymod.block.ModBlocks;
import com.abel.mymod.item.ModItemGroups;
import com.abel.mymod.item.ModItems;

public class MyMod implements ModInitializer {
	public static final String MOD_ID = "my_mod";
	//public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.STAR_POWER, 20*20);
		});

		ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
			if (stack.isOf(ModBlocks.MAGIC_BLOCK.asItem())) {
				lines.add(Text.translatable("tooltip.my_mod.magic_block.line1").formatted(Formatting.LIGHT_PURPLE));
			}
		});
		ItemTooltipCallback.EVENT.register((stack, context, type, lines) ->

		{
			if (stack.isOf(ModItems.CHISEL.asItem())&&Screen.hasShiftDown()) {
				lines.add(Text.translatable("tooltip.my_mod.chisel_shift").formatted(Formatting.GREEN));
			}else if(stack.isOf(ModItems.CHISEL.asItem())){
				lines.add(Text.translatable("tooltip.my_mod.chisel").formatted(Formatting.GRAY));
			}
		});
		ItemTooltipCallback.EVENT.register((stack, context, type, lines) ->

		{
			if (stack.isOf(ModItems.CAULIFLOWER.asItem())&&Screen.hasShiftDown()) {
				lines.add(Text.translatable("tooltip.my_mod.cauliflower").formatted(Formatting.GREEN));
			}else if(stack.isOf(ModItems.CAULIFLOWER.asItem())){
				lines.add(Text.translatable("tooltip.my_mod.cauliflower").formatted(Formatting.GRAY));
			}
		});
		ItemTooltipCallback.EVENT.register((stack, context, type, lines) ->{
			if (stack.isOf(ModItems.STAR_POWER.asItem())&&Screen.hasShiftDown()) {
				lines.add(Text.translatable("tooltip.my_mod.star_power_shift").formatted(Formatting.YELLOW));
			}else if(stack.isOf(ModItems.STAR_POWER.asItem())){
				lines.add(Text.translatable("tooltip.my_mod.star_power").formatted(Formatting.GRAY));
			}
		});
	}
	
}