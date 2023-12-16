package net.vyrek.tutorialmod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Blocks
import net.minecraft.item.ArmorItem
import net.minecraft.item.AxeItem
import net.minecraft.item.HoeItem
import net.minecraft.item.Item
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.vyrek.tutorialmod.TutorialMod
import net.vyrek.tutorialmod.item.custom.MetalDetectorItem
import net.vyrek.tutorialmod.item.custom.ModArmorItem

object ModItems {
	val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))
	val RAW_RUBY: Item = registerItem("raw_ruby", Item(FabricItemSettings()))

	val METAL_DETECTOR: Item =
		registerItem("metal_detector", MetalDetectorItem(FabricItemSettings().maxDamage(64)))

	val TOMATO: Item =
		registerItem("tomato", Item(FabricItemSettings().food(ModFoodComponents.TOMATO)))

	val COAL_BRIQUETTE = registerItem("coal_briquette", Item(FabricItemSettings()))

	val RUBY_STAFF: Item =
		registerItem("ruby_staff", Item(FabricItemSettings().maxCount(1)))

	val RUBY_PICKAXE: Item = registerItem(
		"ruby_pickaxe", PickaxeItem(
			ModToolMaterial.RUBY,
			2,
			2f,
			FabricItemSettings()
		)
	)
	val RUBY_AXE: Item = registerItem(
		"ruby_axe", AxeItem(
			ModToolMaterial.RUBY,
			4f,
			2f,
			FabricItemSettings()
		)
	)
	val RUBY_SHOVEL: Item = registerItem(
		"ruby_shovel", ShovelItem(
			ModToolMaterial.RUBY,
			1.2f,
			3f,
			FabricItemSettings()
		)
	)
	val RUBY_SWORD: Item = registerItem(
		"ruby_sword", SwordItem(
			ModToolMaterial.RUBY,
			5,
			2.5f,
			FabricItemSettings()
		)
	)
	val RUBY_HOE: Item = registerItem(
		"ruby_hoe", HoeItem(
			ModToolMaterial.RUBY,
			10,
			8.5f,
			FabricItemSettings()
		)
	)

	val RUBY_HELMET: Item = registerItem(
		"ruby_helmet", ModArmorItem(
			ModArmorMaterials.RUBY,
			ArmorItem.Type.HELMET,
			FabricItemSettings()
		)
	)
	val RUBY_CHESTPLATE: Item = registerItem(
		"ruby_chestplate", ArmorItem(
			ModArmorMaterials.RUBY,
			ArmorItem.Type.CHESTPLATE,
			FabricItemSettings()
		)
	)
	val RUBY_LEGGINGS: Item = registerItem(
		"ruby_leggings", ArmorItem(
			ModArmorMaterials.RUBY,
			ArmorItem.Type.LEGGINGS,
			FabricItemSettings()
		)
	)
	val RUBY_BOOTS: Item = registerItem(
		"ruby_boots", ArmorItem(
			ModArmorMaterials.RUBY,
			ArmorItem.Type.BOOTS,
			FabricItemSettings()
		)
	)

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