package com.theaemogie.learnmod.common.item;

import com.theaemogie.learnmod.References;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
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

        BlockPos offset;

        player.sendMessage(new StringTextComponent(facing.toString()), player.getUUID());

        switch (facing) {
            case NORTH:
                offset = new BlockPos(0, 0, -1);
                breakBlock(pos, offset, player);
                break;
            case EAST:
                offset = new BlockPos(1, 0, 0);
                breakBlock(pos, offset, player);
                break;
            case SOUTH:
                offset = new BlockPos(0, 0, 1);
                breakBlock(pos, offset, player);
                break;
            case WEST:
                offset = new BlockPos(-1, 0, 0);
                breakBlock(pos, offset, player);
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

        return false;
    }

    private boolean isDropped(World world, BlockPos pos, PlayerEntity player) {
        BlockState blockState = world.getBlockState(pos);

        boolean canDrop = this.canHarvestBlock(player.getMainHandItem(),blockState);
//        canPlayerBreakBlockWhileHolding(blockState, world, pos, player);
        boolean isDropped = canDrop && !player.isCreative();
        return isDropped;
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

        if (!world.isClientSide()) {
            world.destroyBlock(nextPos, isDropped, player);
        }
    }

}
