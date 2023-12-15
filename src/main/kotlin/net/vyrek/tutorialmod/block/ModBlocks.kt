package net.vyrek.tutorialmod.block

import net.fabricmc.fabric.api.block.v1.FabricBlock
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.vyrek.tutorialmod.TutorialMod
import net.vyrek.tutorialmod.block.custom.SoundBlock

object ModBlocks {
	val RUBY_BLOCK: Block = registerBlock(
		"ruby_block",
		Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK))
	)
	val RAW_RUBY_BLOCK: Block = registerBlock(
		"raw_ruby_block",
		Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK))
	)

	val RUBY_ORE: Block = registerBlock(
		"ruby_ore",
		ExperienceDroppingBlock(
			FabricBlockSettings.copyOf(Blocks.STONE).strength(2f),
			UniformIntProvider.create(2, 5)
		)
	)
	val DEEPSLATE_RUBY_ORE: Block = registerBlock(
		"deepslate_ruby_ore",
		ExperienceDroppingBlock(
			FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f),
			UniformIntProvider.create(3, 6)
		)
	)
	val NETHER_RUBY_ORE: Block = registerBlock(
		"nether_ruby_ore",
		ExperienceDroppingBlock(
			FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f),
			UniformIntProvider.create(4, 7)
		)
	)
	val END_STONE_RUBY_ORE: Block = registerBlock(
		"end_stone_ruby_ore",
		ExperienceDroppingBlock(
			FabricBlockSettings.copyOf(Blocks.END_STONE).strength(3f),
			UniformIntProvider.create(5, 8)
		)
	)

	val SOUND_BLOCK: Block = registerBlock(
		"sound_block",
		SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
	)

	val RUBY_STAIRS: Block = registerBlock(
		"ruby_stairs",
		StairsBlock(ModBlocks.RUBY_BLOCK.defaultState, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
	)
	val RUBY_SLAB: Block = registerBlock(
		"ruby_slab",
		SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
	)

	val RUBY_BUTTON: Block = registerBlock(
		"ruby_button",
		ButtonBlock(
			FabricBlockSettings.copyOf(Blocks.IRON_BLOCK),
			BlockSetType.IRON,
			10,
			true
		)
	)
	val RUBY_PRESSURE_PLATE: Block = registerBlock(
		"ruby_pressure_plate",
		PressurePlateBlock(
			PressurePlateBlock.ActivationRule.EVERYTHING,
			FabricBlockSettings.copyOf(Blocks.IRON_BLOCK),
			BlockSetType.IRON
		)
	)

	val RUBY_FENCE: Block = registerBlock(
		"ruby_fence",
		FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
	)
	val RUBY_FENCE_GATE: Block = registerBlock(
		"ruby_fence_gate",
		FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA)
	)
	val RUBY_WALL: Block = registerBlock(
		"ruby_wall",
		WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
	)

	val RUBY_DOOR: Block = registerBlock(
		"ruby_door",
		DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON)
	)
	val RUBY_TRAPDOOR: Block = registerBlock(
		"ruby_trapdoor",
		TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON)
	)

	private fun registerBlock(name: String, block: Block): Block {
		registerBlockItem(name, block)
		return Registry.register(Registries.BLOCK, Identifier(TutorialMod.MOD_ID, name), block)
	}

	private fun registerBlockItem(name: String, block: Block): Item {
		return Registry.register(
			Registries.ITEM, Identifier(TutorialMod.MOD_ID, name),
			BlockItem(block, FabricItemSettings())
		)
	}

	fun registerModBlocks() {
		TutorialMod.logger.info("Registering mod blocks for " + TutorialMod.MOD_ID)
	}
}