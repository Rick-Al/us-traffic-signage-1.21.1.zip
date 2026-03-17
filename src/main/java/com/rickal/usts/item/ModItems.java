package com.rickal.usts.item;

import com.rickal.usts.USTrafficSignage;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //mod items
    public static final Item BLANK_SIGN = registerItem("blank_sign", new Item(new Item.Settings()));
    public static final Item STOP_SIGN = registerItem("stop_sign", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(USTrafficSignage.MOD_ID, name), item);
    }

        public static void registerModItems() {
            USTrafficSignage.LOGGER.info("Registering Mod Items for " + USTrafficSignage.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
                entries.add(BLANK_SIGN);
            });
        }
}
