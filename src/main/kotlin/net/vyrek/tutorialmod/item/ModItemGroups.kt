package net.vyrek.tutorialmod.item

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.vyrek.tutorialmod.TutorialMod
import net.vyrek.tutorialmod.block.ModBlocks

object ModItemGroups {
	val RUBY_GROUP: ItemGroup = Registry.register(Registries.ITEM_GROUP,
		Identifier(TutorialMod.MOD_ID, "ruby"),
		FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
			.icon { ItemStack(ModItems.RUBY) }.entries { _, entries ->
				run {
					entries.add(ModItems.RUBY)
					entries.add(ModItems.RAW_RUBY)

					entries.add(ModItems.TOMATO)

					entries.add(ModItems.COAL_BRIQUETTE)

					entries.add(ModItems.METAL_DETECTOR)

					entries.add(ModBlocks.SOUND_BLOCK)

					entries.add(ModItems.RUBY_STAFF)

					entries.add(ModItems.RUBY_SWORD)
					entries.add(ModItems.RUBY_PICKAXE)
					entries.add(ModItems.RUBY_AXE)
					entries.add(ModItems.RUBY_SHOVEL)
					entries.add(ModItems.RUBY_HOE)

					entries.add(ModItems.RUBY_HELMET)
					entries.add(ModItems.RUBY_CHESTPLATE)
					entries.add(ModItems.RUBY_LEGGINGS)
					entries.add(ModItems.RUBY_BOOTS)

					entries.add(ModBlocks.RUBY_BLOCK)
					entries.add(ModBlocks.RAW_RUBY_BLOCK)
					entries.add(ModBlocks.RUBY_ORE)
					entries.add(ModBlocks.DEEPSLATE_RUBY_ORE)
					entries.add(ModBlocks.NETHER_RUBY_ORE)
					entries.add(ModBlocks.END_STONE_RUBY_ORE)

					entries.add(ModBlocks.RUBY_STAIRS)
					entries.add(ModBlocks.RUBY_SLAB)

					entries.add(ModBlocks.RUBY_BUTTON)
					entries.add(ModBlocks.RUBY_PRESSURE_PLATE)

					entries.add(ModBlocks.RUBY_FENCE)
					entries.add(ModBlocks.RUBY_FENCE_GATE)
					entries.add(ModBlocks.RUBY_WALL)

					entries.add(ModBlocks.RUBY_DOOR)
					entries.add(ModBlocks.RUBY_TRAPDOOR)
				}
			}.build()
	)

	fun registerItemGroups() {
		TutorialMod.logger.info("Registering item groups for " + TutorialMod.MOD_ID)
	}
}