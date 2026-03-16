package com.rickal.usts.item;

import com.rickal.usts.USTrafficSignage;
import com.rickal.usts.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TRAFFIC_SIGNAGE = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(USTrafficSignage.MOD_ID, "traffic_signage"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLANK_SIGN))
                    .displayName(Text.translatable("itemgroup.usts.traffic_signage"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLANK_SIGN);
                        entries.add(ModBlocks.SIGNPOST);

                    }).build());


    public static void registerItemGroups() {
        USTrafficSignage.LOGGER.info("Registering Item Groups for " + USTrafficSignage.MOD_ID);
    }
}
