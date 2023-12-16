package net.vyrek.tutorialmod.item.custom

import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ArmorMaterials
import net.minecraft.item.ItemStack
import net.minecraft.stat.Stat
import net.minecraft.world.World
import net.vyrek.tutorialmod.item.ModArmorMaterials

class ModArmorItem(
	material: ArmorMaterial?,
	type: Type?,
	settings: Settings?
) : ArmorItem(material, type, settings) {
	private val MATERIAL_TO_EFFECT_MAP: Map<ArmorMaterial, StatusEffectInstance> =
		mapOf(
			ModArmorMaterials.RUBY to StatusEffectInstance(
				StatusEffects.HASTE,
				400,
				1,
				false,
				false,
				true
			)
		)

	override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
		if (!world.isClient()) {
			if (entity is PlayerEntity && hasFullSuitOfArmorOn(entity)) {
				evaluateArmorEffects(entity)
			}
		}

		super.inventoryTick(stack, world, entity, slot, selected)
	}

	private fun hasFullSuitOfArmorOn(player: PlayerEntity): Boolean {
		val boots = player.inventory.getArmorStack(0)
		val leggings = player.inventory.getArmorStack(1)
		val chestplate = player.inventory.getArmorStack(2)
		val helmet = player.inventory.getArmorStack(3)

		return !helmet.isEmpty && !chestplate.isEmpty && !leggings.isEmpty && !boots.isEmpty
	}

	private fun evaluateArmorEffects(player: PlayerEntity) {
		for (entry in MATERIAL_TO_EFFECT_MAP.entries) {
			if (hasCorrectArmorOn(entry.key, player)) {
				addStatusEffectForMaterial(player, entry.key, entry.value)
			}
		}
	}

	private fun hasCorrectArmorOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
		for (armorStack in player.inventory.armor) {
			if (armorStack.item !is ArmorItem) {
				return false
			}
		}

		val boots = player.inventory.getArmorStack(0).item as ArmorItem
		val leggings = player.inventory.getArmorStack(1).item as ArmorItem
		val chestplate = player.inventory.getArmorStack(2).item as ArmorItem
		val helmet = player.inventory.getArmorStack(3).item as ArmorItem

		return helmet.material == material &&
				chestplate.material == material &&
				leggings.material == material &&
				boots.material == material
	}

	private fun addStatusEffectForMaterial(
		player: PlayerEntity,
		armorMaterial: ArmorMaterial,
		statusEffect: StatusEffectInstance
	) {
		val hasStatusEffect = player.hasStatusEffect(statusEffect.effectType)

		if (!hasStatusEffect) {
			player.addStatusEffect(StatusEffectInstance(statusEffect))
		}
	}
}