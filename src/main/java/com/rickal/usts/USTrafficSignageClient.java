package com.rickal.usts;

import com.rickal.usts.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderContext;
import net.minecraft.client.render.RenderLayer;

public class USTrafficSignageClient implements ClientModInitializer {
    //attempt to make signpost transparent
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SIGNPOST, RenderLayer.getTranslucent());
    }
}
