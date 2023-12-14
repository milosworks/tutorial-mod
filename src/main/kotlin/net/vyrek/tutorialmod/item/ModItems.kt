package net.vyrek.tutorialmod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.vyrek.tutorialmod.TutorialMod
import net.vyrek.tutorialmod.item.custom.MetalDetectorItem

object ModItems {
	val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))
	val RAW_RUBY: Item = registerItem("raw_ruby", Item(FabricItemSettings()))

	val METAL_DETECTOR: Item =
		registerItem("metal_detector", MetalDetectorItem(FabricItemSettings().maxDamage(64)))

	val TOMATO: Item =
		registerItem("tomato", Item(FabricItemSettings().food(ModFoodComponents.TOMATO)))
	val COAL_BRIQUETTE = registerItem("coal_briquette", Item(FabricItemSettings()))

//	private fun addItemsToIngredientItemGroup(entries: FabricItemGroupEntries) {
//		entries.add(RUBY)
//		entries.add(RAW_RUBY)
//	}

	private fun registerItem(name: String, item: Item): Item {
		return Registry.register(Registries.ITEM, Identifier(TutorialMod.MOD_ID, name), item)
	}

	fun registerModItems() {
		TutorialMod.logger.info("Registering Mod Items for ${TutorialMod.MOD_ID}")

//		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(::addItemsToIngredientItemGroup)
	}
}