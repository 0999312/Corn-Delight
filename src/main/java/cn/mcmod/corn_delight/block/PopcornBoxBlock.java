package cn.mcmod.corn_delight.block;

import cn.mcmod.corn_delight.CornDelight;
import cn.mcmod.corn_delight.item.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
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
    @SuppressWarnings("deprecation")
	public PopcornBoxBlock() {
        super(Block.Properties.ofLegacyCopy(Blocks.YELLOW_WOOL), ItemRegistry.CARAMEL_POPCORN::get, true);
    }
    
    @Override
	public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) {
            if (this.takeServing(level, pos, state, player, hand).consumesAction()) {
                return ItemInteractionResult.SUCCESS;
            }
        }
        return this.takeServing(level, pos, state, player, hand);
    }
    
    public ItemInteractionResult takeServing(LevelAccessor worldIn, BlockPos pos, BlockState state, Player player, InteractionHand handIn) {
        int servings = state.getValue(SERVINGS);

        if (servings == 0) {
            worldIn.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            worldIn.destroyBlock(pos, true);
            return ItemInteractionResult.SUCCESS;
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
                worldIn.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(Component.translatable(CornDelight.MODID+".block.popcorn.bearhand", serving.getCraftingRemainingItem().getHoverName()), true);
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
