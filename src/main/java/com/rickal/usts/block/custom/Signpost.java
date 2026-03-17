package com.rickal.usts.block.custom;

import com.mojang.serialization.MapCodec;
import com.rickal.usts.block.entity.custom.SignpostEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Signpost extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE =
            Block.createCuboidShape(6.5, 0, 6.5, 9.5, 16, 9.5);
    public static final MapCodec<Signpost> CODEC = Signpost.createCodec(Signpost::new);

    public Signpost(Settings settings) {
        super(settings);
    }

    // making the signpost an actual post and not a full block
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SignpostEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof SignpostEntity) {
                ItemScatterer.spawn(world, pos, ((SignpostEntity) blockEntity));
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof SignpostEntity SignpostEntity) {
            if(SignpostEntity.isEmpty() && !stack.isEmpty()) {
                SignpostEntity.setStack(0, stack.copyWithCount(1));
                world.playSound(player, pos, SoundEvents.BLOCK_COPPER_GRATE_PLACE, SoundCategory.BLOCKS, 1f, 2f);
                stack.decrement(1);

                SignpostEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            } else if(stack.isEmpty() && !player.isSneaking()) {
                ItemStack stackOnSignpost = SignpostEntity.getStack(0);
                player.setStackInHand(Hand.MAIN_HAND, stackOnSignpost);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                SignpostEntity.clear();

                SignpostEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            }
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }
}
