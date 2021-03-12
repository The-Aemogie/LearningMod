package com.theaemogie.learnmod.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class GlassLightBlock extends Block {

    //region Variables
    //region Create variables to be used as BlockStates.
    private static final BooleanProperty LIT = BlockStateProperties.LIT;
    private static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    //endregion
    //region Create variables to be used as the block's properties.
    private static final float HARDNESS = 1.5f;
    private static final float RESISTANCE = 6.0f;
    //endregion
    //endregion

    //region Block - Constructor. No parameters are required.
    public GlassLightBlock() {
        super(Properties.of(Material.GLASS)
                .sound(SoundType.GLASS)
                .air()
                .strength(HARDNESS, RESISTANCE)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(0)
        );
        //region Set the block's default BlockStates. LIT -> false , POWERED -> false.
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LIT, false)
                .setValue(POWERED, false)
        );
        //endregion
    }
    //endregion

    //region Make the block a transparent block to remain consistent with its "parent" - Glass.
    @SuppressWarnings({"deprecation", "NullableProblems"})
    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }
    //endregion

    //region Add the relevant BlockStates to the block.
    @SuppressWarnings("NullableProblems")
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
        builder.add(POWERED);
    }
    //endregion

    //region Add a right click functionality to call the toggleLit() method.
    @SuppressWarnings({"deprecation", "NullableProblems"})
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        toggleLit(state, worldIn, pos);
        return ActionResultType.SUCCESS;
    }
    //endregion

    //region Toggle the LIT BlockState every time this function is called.
    public void toggleLit(BlockState state, World worldIn, BlockPos pos) {
        //region Check if the POWERED BlockState is false.
        if (state.getValue(POWERED).equals(false)) {
            //region Check if the LIT BlockState is false. If yes, set it true.
            if (state.getValue(LIT).equals(false)) {
                worldIn.setBlock(pos,
                        this.getStateDefinition().any()
                                .setValue(LIT, true)
                                .setValue(POWERED, false),
                        3
                );
            }
            //endregion
            //region If it is true, set it to false.
            else if (state.getValue(LIT).equals(true)) {
                worldIn.setBlock(pos,
                        this.getStateDefinition().any()
                                .setValue(LIT, false)
                                .setValue(POWERED, false),
                        3
                );
            }
            //endregion
        }
        //endregion
        //region If it is true, keep the LIT BlockState as true.
        else if (state.getValue(POWERED).equals(true)) {
            worldIn.setBlock(pos, this.getStateDefinition().any().setValue(LIT, true), 3);
        }
        //endregion
    }
    //endregion

    //region Change light value depending on the LIT BlockState.
    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        //region If it is true, change the light value to 15. (Vanilla maximum)
        if (state.getValue(LIT)) {
            return 15;
        }
        //endregion
        //region If it is false, change the light value to 0. (Vanilla minimum)
        else {
            return 0;
        }
        //endregion
    }
    //endregion


    //region Increase hardness of the block when LIT is true.
    @SuppressWarnings({"deprecation", "NullableProblems"})
    @Override
    public float getDestroyProgress(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
        if (state.getValue(LIT)) {
            //region If LIT is true increase
            return super.getDestroyProgress(state, player, worldIn, pos) / 5f;
            //endregion
        } else {
            return super.getDestroyProgress(state, player, worldIn, pos);
        }
    }
    //endregion

    //@SuppressWarnings({"deprecation", "NullableProblems"})
    //@Override
    //public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
    //    if (state.get(POWERED)) {
    //        if (worldIn.isBlockPowered(pos)){
    //            worldIn.setBlockState(pos,
    //                    this.getStateContainer().getBaseState()
    //                            .with(LIT, true)
    //                            .with(POWERED, true),
    //                    3
    //            );
    //        } else {
    //            worldIn.setBlockState(
    //                    pos,
    //                    this.getStateContainer().getBaseState().
    //                            with(POWERED, false),
    //                    3
    //            );
    //        }
    //    }
    //}

    //@SuppressWarnings("deprecation")
    //@Override
    //public void tick(@NotNull BlockState state, @NotNull ServerWorld worldIn, @NotNull BlockPos pos, @NotNull Random rand) {
    //    if (worldIn.isBlockPowered(pos)){
    //        worldIn.setBlockState(pos,
    //                this.getStateContainer().getBaseState()
    //                        .with(LIT, true)
    //                        .with(POWERED, true),
    //                3
    //        );
    //    } else {
    //        worldIn.setBlockState(
    //                pos,
    //                this.getStateContainer().getBaseState().
    //                        with(POWERED, false),
    //                3
    //        );
    //    }
    //
    //}
}
