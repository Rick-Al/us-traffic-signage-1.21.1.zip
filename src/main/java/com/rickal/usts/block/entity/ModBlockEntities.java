package com.rickal.usts.block.entity;

import com.rickal.usts.USTrafficSignage;
import com.rickal.usts.block.ModBlocks;
import com.rickal.usts.block.entity.custom.SignpostEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<SignpostEntity> SIGNPOST_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(USTrafficSignage.MOD_ID, "signpost_be"),
                    BlockEntityType.Builder.create(SignpostEntity::new, ModBlocks.SIGNPOST).build(null));

    public static void registerBlockEntities(){
        USTrafficSignage.LOGGER.info("Registering Block Entities for " + USTrafficSignage.MOD_ID);
    }
}
