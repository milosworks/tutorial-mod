package net.vyrek.tutorialmod.item.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.text.TextColor
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.vyrek.tutorialmod.block.ModBlocks
import net.vyrek.tutorialmod.util.ModTags

class MetalDetectorItem(settings: Settings) : Item(settings) {
	override fun useOnBlock(context: ItemUsageContext): ActionResult {
		if (!context.world.isClient()) {
			val positionClicked: BlockPos = context.blockPos
			val player: PlayerEntity = context.player!!
			var foundBlock = false

			for (i in (0..(positionClicked.y + 64))) {
				val state: BlockState = context.world.getBlockState(positionClicked.down(i))

				if (isValuableBlock(state)) {
					outputValuableCoordinates(positionClicked.down(i), player, state.block)
					foundBlock = true

					break
				}
			}

			if (!foundBlock) {
				player.sendMessage(Text.literal("No valuables found"))
			}
		}

		context.stack.damage(
			1,
			context.player
		) { playerEntity -> playerEntity!!.sendToolBreakStatus(playerEntity.activeHand) }

		return ActionResult.SUCCESS
	}

	private fun outputValuableCoordinates(blockPos: BlockPos, player: PlayerEntity, block: Block) {
		player.sendMessage(
			Text.literal(
				"Found ${block.asItem().name.string} at (${blockPos.x}, ${blockPos.y}, ${blockPos.z})"
			),
			false
		)
	}

	private fun isValuableBlock(state: BlockState): Boolean {
		return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
	}

	override fun appendTooltip(
		stack: ItemStack?,
		world: World?,
		tooltip: MutableList<Text>,
		context: TooltipContext?
	) {
		tooltip.add(Text.translatable("tooltip.tutorialmod.metal_detector.tooltip").styled {
			it.withColor(TextColor.fromRgb(11053224))
		})
		super.appendTooltip(stack, world, tooltip, context)
	}
}