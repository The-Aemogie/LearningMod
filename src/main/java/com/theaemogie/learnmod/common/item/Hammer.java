package com.theaemogie.learnmod.common.item;

import com.theaemogie.learnmod.References;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Hammer extends PickaxeItem {

    private static final IItemTier ITEM_TIER = ItemTier.OBSIDIAN;
    private static final int ATTACK_DAMAGE = 1;
    private static final float ATTACK_SPEED = -2.8f; //Value used in Vanilla pickaxes.
    private static final Item.Properties PROPERTIES = new Item.Properties().tab(References.MISC_GROUP);

    private float Hardness;
    private PlayerEntity player;

    public Hammer() {
        super(
                ITEM_TIER,
                ATTACK_DAMAGE,
                ATTACK_SPEED,
                PROPERTIES
        );
//        super(new Properties()
//                .group(References.GROUP)
//                .addToolType(ToolType.PICKAXE,5)
//                .maxStackSize(1)
//                .defaultMaxDamage(MAX_DAMAGE)
//                .isImmuneToFire()
//        );
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player) {

        Direction facing = player.getDirection();

        BlockPos up = new BlockPos(0, 1, 0);
        BlockPos down = new BlockPos(0, -1, 0);
        ;
        BlockPos left = null;
        BlockPos right = null;
        BlockPos upLeft = null;
        BlockPos upRight = null;
        BlockPos downLeft = null;
        BlockPos downRight = null;

//        player.sendMessage(new StringTextComponent(facing.toString()), player.getUUID());

        switch (facing) {
            case NORTH:
                left = new BlockPos(-1, 0, 0);
                upLeft = new BlockPos(-1, 1, 0);
                downLeft = new BlockPos(-1, -1, 0);
                right = new BlockPos(1, 0, 0);
                upRight = new BlockPos(1, 1, 0);
                downRight = new BlockPos(1, -1, 0);

                break;
            case EAST:
                left = new BlockPos(0, 0, -1);
                upLeft = new BlockPos(0, 1, -1);
                downLeft = new BlockPos(0, -1, -1);
                right = new BlockPos(0, 0, 1);
                upRight = new BlockPos(0, 1, 1);
                downRight = new BlockPos(0, -1, 1);
                break;
            case SOUTH:
                left = new BlockPos(1, 0, 0);
                upLeft = new BlockPos(1, 1, 0);
                downLeft = new BlockPos(1, -1, 0);
                right = new BlockPos(-1, 0, 0);
                upRight = new BlockPos(-1, 1, 0);
                downRight = new BlockPos(-1, -1, 0);
                break;
            case WEST:
                left = new BlockPos(0, 0, 1);
                upLeft = new BlockPos(0, 0, 1);
                downLeft = new BlockPos(0, 0, 1);
                right = new BlockPos(0, 0, -1);
                upRight = new BlockPos(0, 0, -1);
                downRight = new BlockPos(0, 0, -1);
                break;
            default:
                break;
        }
//        if (-45f<=yaw && yaw<=45f){
//            world.destroyBlock(new BlockPos(x,y,z+1),true,player);
//            player.sendMessage(new StringTextComponent("Case A"), player.getUniqueID());
//        }
//        else if (45f<=yaw && yaw<=135f){
//            world.destroyBlock(new BlockPos(x-1,y,z),true,player);
//            player.sendMessage(new StringTextComponent("Case B"), player.getUniqueID());
//        }
//        else if (135f<=yaw && yaw<=180f){
//            world.destroyBlock(new BlockPos(x,y,z-1),true,player);
//            player.sendMessage(new StringTextComponent("Case C 1"), player.getUniqueID());
//        }
//        else if (-180f<=yaw && yaw<=-135f) {
//            world.destroyBlock(new BlockPos(x, y, z - 1), true, player);
//            player.sendMessage(new StringTextComponent("Case C 2"), player.getUniqueID());
//        }
//        else if (-135<=yaw && yaw<=-45) {
//            world.destroyBlock(new BlockPos(x+1,y,z),true,player);
//            player.sendMessage(new StringTextComponent("Case D"), player.getUniqueID());
//        }
//        itemstack.damageItem(1,player,playerEntity -> );
        breakBlock(pos, up, player);
        breakBlock(pos, down, player);
        breakBlock(pos, left, player);
        breakBlock(pos, upLeft, player);
        breakBlock(pos, downLeft, player);
        breakBlock(pos, right, player);
        breakBlock(pos, upRight, player);
        breakBlock(pos, downRight, player);
        return false;
    }

    private boolean isDropped(World world, BlockPos pos, PlayerEntity player) {
        BlockState blockState = world.getBlockState(pos);

        boolean canDrop = this.canHarvestBlock(player.getMainHandItem(), blockState);
//        canPlayerBreakBlockWhileHolding(blockState, world, pos, player);
        return canDrop && !player.isCreative();
    }

    private void breakBlock(BlockPos pos, BlockPos offset, PlayerEntity player) {

        World world = player.level;
        this.player = player;

        int currentX = pos.getX();
        int currentY = pos.getY();
        int currentZ = pos.getZ();

        int offsetX = offset.getX();
        int offsetY = offset.getY();
        int offsetZ = offset.getZ();

        BlockPos nextPos = new BlockPos(currentX + offsetX, currentY + offsetY, currentZ + offsetZ);

        BlockState current = world.getBlockState(pos);
        BlockState next = world.getBlockState(nextPos);

        boolean isDropped = isDropped(world, nextPos, player);

        if (!world.isClientSide() && next.getBlock() != Blocks.AIR) {
            world.destroyBlock(nextPos, isDropped, player);
        }
    }

}
