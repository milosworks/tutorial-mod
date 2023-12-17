package net.vyrek.tutorialmod.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.CropBlock
import net.minecraft.block.ShapeContext
import net.minecraft.item.ItemConvertible
import net.minecraft.server.world.ServerWorld
import net.minecraft.state.StateManager
import net.minecraft.state.property.IntProperty
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.minecraft.world.WorldView
import net.vyrek.tutorialmod.item.ModItems

class CornCropBlock(settings: Settings?) : CropBlock(settings) {
	companion object {
		val AGE: IntProperty = IntProperty.of("age", 0, 8)
	}

	val FIRST_STAGE_MAX_AGE = 7
	val SECOND_STAGE_MAX_AGE = 1

	private val AGE_TO_SHAPE = arrayOf(
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
		createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
	)

	override fun getOutlineShape(
		state: BlockState?,
		world: BlockView?,
		pos: BlockPos?,
		context: ShapeContext?
	): VoxelShape {
		return AGE_TO_SHAPE[getAge(state)]
	}

	override fun randomTick(state: BlockState, world: ServerWorld, pos: BlockPos, random: Random) {
		if (world.getBaseLightLevel(pos, 0) >= 9) {
			val currentAge = getAge(state)
			if (currentAge < maxAge) {
				val f: Float = getAvailableMoisture(this, world, pos)
				if (random.nextInt(((25.0F / f) + 1).toInt()) == 0) {
					if (currentAge == FIRST_STAGE_MAX_AGE) {
						if (world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
							world.setBlockState(pos.up(1), withAge(currentAge + 1), 2)
						} else {
							world.setBlockState(pos, withAge(currentAge + 1), 2)
						}
					}
				}
			}
		}
	}

	override fun applyGrowth(world: World, pos: BlockPos, state: BlockState?) {
		var nextAge = getAge(state) + getGrowthAmount(world)

		if (nextAge > maxAge) {
			nextAge = maxAge
		}

		if (getAge(state) == FIRST_STAGE_MAX_AGE && world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
			world.setBlockState(pos.up(1), withAge(nextAge), 2)
		} else {
			world.setBlockState(pos, withAge(nextAge - 1), 2)
		}
	}

	override fun canPlaceAt(state: BlockState, world: WorldView, pos: BlockPos): Boolean {
		return super.canPlaceAt(state, world, pos) || (world.getBlockState(pos.down(1)).isOf(this) &&
				world.getBlockState(pos.down(1)).get(Companion.AGE) == 7)
	}

	override fun getMaxAge(): Int {
		return FIRST_STAGE_MAX_AGE + SECOND_STAGE_MAX_AGE
	}

	override fun getSeedsItem(): ItemConvertible {
		return ModItems.CORN_SEEDS
	}

	override fun getAgeProperty(): IntProperty {
		return Companion.AGE
	}

	override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
		builder.add(Companion.AGE)
	}
}