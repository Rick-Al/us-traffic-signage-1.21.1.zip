package com.rickal.usts;

import com.rickal.usts.block.ModBlocks;
import com.rickal.usts.block.entity.ModBlockEntities;
import com.rickal.usts.block.entity.ModBlockEntities;
import com.rickal.usts.item.ModItemGroups;
import com.rickal.usts.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class USTrafficSignage implements ModInitializer {
	public static final String MOD_ID = "usts";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
	}
}