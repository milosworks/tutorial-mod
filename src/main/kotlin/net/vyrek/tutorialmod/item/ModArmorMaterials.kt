package net.vyrek.tutorialmod.item

import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.vyrek.tutorialmod.util.ModIdentifier
import java.util.function.Supplier

enum class ModArmorMaterials(
	private val materialName: String,
	private val durabilityMultiplier: Int,
	private val protectionAmounts: Array<Int>,
	private val enchantability: Int,
	private val equipSound: SoundEvent,
	private val toughness: Float,
	private val knockbackResistance: Float,
	private val repairIngredient: Supplier<Ingredient>
) : ArmorMaterial {
	RUBY(
		"ruby",
		25,
		arrayOf(3, 8, 6, 3),
		19,
		SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
		2f,
		0.1f,
		{ Ingredient.ofItems(ModItems.RUBY) }
	);

	private val BASE_DURABILITY: Array<Int> = arrayOf(11, 16, 15, 13)

	override fun getDurability(type: ArmorItem.Type): Int {
		return BASE_DURABILITY[type.ordinal] * this.durabilityMultiplier
	}

	override fun getProtection(type: ArmorItem.Type): Int {
		return BASE_DURABILITY[type.ordinal] * this.durabilityMultiplier
	}

	override fun getEnchantability(): Int {
		return enchantability
	}

	override fun getEquipSound(): SoundEvent {
		return equipSound
	}

	override fun getRepairIngredient(): Ingredient {
		return repairIngredient.get()
	}

	override fun getName(): String {
		return ModIdentifier.identifierString(materialName)
	}

	override fun getToughness(): Float {
		return toughness
	}

	override fun getKnockbackResistance(): Float {
		return knockbackResistance
	}

}