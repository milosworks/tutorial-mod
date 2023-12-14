package net.vyrek.tutorialmod.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.text.TextColor
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView
import net.minecraft.world.World

class SoundBlock(settings: Settings) : Block(settings) {
	override fun onUse(
		state: BlockState?,
		world: World,
		pos: BlockPos?,
		player: PlayerEntity?,
		hand: Hand?,
		hit: BlockHitResult?
	): ActionResult {
		world.playSound(
			player, pos, SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE.value(), SoundCategory.BLOCKS, 1f, 1f
		)
		return ActionResult.SUCCESS
	}

	override fun appendTooltip(
		stack: ItemStack?,
		world: BlockView?,
		tooltip: MutableList<Text>,
		options: TooltipContext?
	) {
		tooltip.add(Text.translatable("tooltip.tutorialmod.sound_block.tooltip").styled {
			it.withColor(TextColor.fromRgb(11053224))
		})
		super.appendTooltip(stack, world, tooltip, options)
	}
}