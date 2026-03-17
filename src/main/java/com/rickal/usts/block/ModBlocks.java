package com.rickal.usts.block;

import com.rickal.usts.USTrafficSignage;
import com.rickal.usts.block.custom.Signpost;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SIGNPOST = registerBlock("signpost",
        new Signpost(AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.COPPER_GRATE).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(USTrafficSignage.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(USTrafficSignage.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        USTrafficSignage.LOGGER.info("Registering Mod Blocks for " + USTrafficSignage.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.SIGNPOST);
        });
    }
}
