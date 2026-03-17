package com.rickal.usts.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class Signpost extends Block{
    private static final VoxelShape SHAPE = Block.createCuboidShape(6.5, 0, 6.5, 9.5, 16, 9.5);

    public Signpost(Settings settings) {
        super(settings);
    }
// making the signpost an actual post and not a full block
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
