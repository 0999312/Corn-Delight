package cn.mcmod.corn_delight.block;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class PopcornBoxBlock extends FeastBlock {
    protected static final VoxelShape BOX_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    public PopcornBoxBlock() {
        super(Block.Properties.copy(Blocks.YELLOW_WOOL), ItemRegistry.CARAMEL_POPCORN::get, true);
    }
    
    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (worldIn.isClientSide) {
            if (this.takeServing(worldIn, pos, state, player, handIn).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }
        return this.takeServing(worldIn, pos, state, player, handIn);
    }
    
    public InteractionResult takeServing(LevelAccessor worldIn, BlockPos pos, BlockState state, Player player, InteractionHand handIn) {
        int servings = state.getValue(SERVINGS);

        if (servings == 0) {
            worldIn.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            worldIn.destroyBlock(pos, true);
            return InteractionResult.SUCCESS;
        }

        ItemStack serving = this.getServingItem(state);
        ItemStack heldStack = player.getItemInHand(handIn);

        if (servings > 0) {
            if (heldStack.isEmpty()) {
                worldIn.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
                if (!player.getInventory().add(serving)) {
                    player.drop(serving, false);
                }
                if (worldIn.getBlockState(pos).getValue(SERVINGS) == 0) {
                    if (!player.getInventory().add(new ItemStack(Items.PAPER))) {
                        player.drop(new ItemStack(Items.PAPER), false);
                    }
                    worldIn.removeBlock(pos, false);
                }
                worldIn.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(new TranslatableComponent(CornDelight.MODID+".block.popcorn.bearhand", serving.getContainerItem().getHoverName()), true);
            }
        }
        return InteractionResult.PASS;
    }
}
