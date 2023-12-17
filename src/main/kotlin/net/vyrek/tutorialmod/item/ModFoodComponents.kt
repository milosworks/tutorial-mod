package net.vyrek.tutorialmod.item

import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent

object ModFoodComponents {
	val TOMATO: FoodComponent = FoodComponent.Builder()
		.hunger(3)
		.saturationModifier(0.25f)
		.statusEffect(StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f)
		.build()

	val CORN: FoodComponent = FoodComponent.Builder()
		.hunger(2)
		.saturationModifier(0.1f)
		.statusEffect(StatusEffectInstance(StatusEffects.NAUSEA, 400), 0.1f)
		.build()
}