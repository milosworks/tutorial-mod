package net.vyrek.tutorialmod.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.CropBlock
import net.minecraft.item.ItemConvertible
import net.minecraft.state.StateManager
import net.minecraft.state.property.IntProperty
import net.minecraft.state.property.Properties
import net.vyrek.tutorialmod.item.ModItems

class TomatoCropBlock(settings: Settings) : CropBlock(settings) {
	companion object {
		val AGE: IntProperty = Properties.AGE_5
	}

	private val MAX_AGE = 5

	override fun getSeedsItem(): ItemConvertible {
		return ModItems.TOMATO_SEEDS
	}

	override fun getAgeProperty(): IntProperty {
		return Companion.AGE
	}

	override fun getMaxAge(): Int {
		return MAX_AGE
	}

	override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
		builder.add(Companion.AGE)
	}
}