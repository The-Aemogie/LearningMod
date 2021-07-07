package io.github.aemogie.learnmod.common.block;

import io.github.aemogie.learnmod.core.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.aemogie.learnmod.util.Math.fromBlockCenter;
import static io.github.aemogie.learnmod.util.Math.getSectionIndex;
import static java.util.Arrays.*;
import static net.minecraft.client.renderer.RenderType.solid;

public class PizzaBlock extends ModBlock {
	
	private static final VoxelShape SHAPE = box(0, 0, 0, 16, 2, 16);
	private static BooleanProperty[] slices;
	private final BooleanProperty[] instanceSlices;
	
	protected PizzaBlock() {
		super(Properties.of(Material.CAKE).instabreak().noOcclusion(), solid());
		this.instanceSlices = slices;
		slices = null;
		BlockState defaultState = stateDefinition.any();
		for (BooleanProperty slice : instanceSlices) defaultState.setValue(slice, true);
		registerDefaultState(defaultState);
	}
	
	public static PizzaBlock createPizza(int noOfSlices) {
		slices = new BooleanProperty[noOfSlices];
		for (int i = 0; i < noOfSlices; i++) slices[i] = BooleanProperty.create("slice_" + i);
		return new PizzaBlock();
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		for (BooleanProperty slice : slices) builder.add(slice);
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
		Vector2f hitPos = new Vector2f((float) (rayTraceResult.getLocation().x - pos.getX()), (float) (rayTraceResult.getLocation().z - pos.getZ()));
		BooleanProperty slice = instanceSlices[getSectionIndex(fromBlockCenter(hitPos), instanceSlices.length)];
		//region If the slice is empty...
		if (!state.getValue(slice)) {
			//region if holding a pizza slice, place the slice in the pizza.
			if (player.getItemInHand(hand).getItem().equals(ModItems.PIZZA_SLICE.get())) {
				world.setBlockAndUpdate(pos, state.setValue(slice, true));
				if (!player.abilities.instabuild) player.getItemInHand(hand).shrink(1);
				return ActionResultType.SUCCESS;
			}
			//endregion
			//region Else, return.
			return ActionResultType.CONSUME;
			//endregion
		}
		//endregion
		//region If inventory not full or in creative add an item, else return.
		if (!player.inventory.add(ModItems.PIZZA_SLICE.get().getDefaultInstance())) return ActionResultType.CONSUME;
		//endregion
		//region Remove the slice.
		state = state.setValue(slice, false);
		//endregion
		//region If that slice was the last, set the block to air.
		if (Arrays.stream(instanceSlices).noneMatch(state::getValue)) world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
		//endregion
		//region If not, set the block to {state}
		else world.setBlockAndUpdate(pos, state);
		//endregion
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader block, BlockPos pos, ISelectionContext selectionContext) {
		return SHAPE;
	}
}