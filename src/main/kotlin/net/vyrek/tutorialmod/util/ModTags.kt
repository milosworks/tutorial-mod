package net.vyrek.tutorialmod.util

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.vyrek.tutorialmod.TutorialMod

class ModTags {
	object Blocks {
		val METAL_DETECTOR_DETECTABLE_BLOCKS: TagKey<Block> =
			createTag("metal_detector_detectable_blocks")

		private fun createTag(name: String): TagKey<Block> {
			return TagKey.of(RegistryKeys.BLOCK, Identifier(TutorialMod.MOD_ID, name))
		}
	}

	object Items {
		private fun createTag(name: String): TagKey<Item> {
			return TagKey.of(RegistryKeys.ITEM, Identifier(TutorialMod.MOD_ID, name))
		}
	}
}