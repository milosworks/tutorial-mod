package net.vyrek.tutorialmod.util

import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTables
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.util.Identifier
import net.vyrek.tutorialmod.item.ModItems

object ModLootTableModifiers {
	private val JUNGLE_TEMPLE_ID: Identifier = Identifier("minecraft", "chests/jungle_temple")
	private val CREEPER_ID: Identifier = Identifier("minecraft", "entities/creeper")

	fun modifyLootTables() {
		LootTableEvents.MODIFY.register(LootTableEvents.Modify { _, _, id, tableBuilder, source ->
			if (source.isBuiltin) {
				if (JUNGLE_TEMPLE_ID == id) {
					val poolBuilder: LootPool.Builder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1f))
						.conditionally(RandomChanceLootCondition.builder(1f)) // Chance to drop (1f == 100%)
						.with(ItemEntry.builder(ModItems.METAL_DETECTOR))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

					tableBuilder.pool(poolBuilder.build())
				}

				if (CREEPER_ID == id) {
					val poolBuilder: LootPool.Builder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1f))
						.conditionally(RandomChanceLootCondition.builder(0.7f)) // 70% chance
						.with(ItemEntry.builder(ModItems.COAL_BRIQUETTE))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())

					tableBuilder.pool(poolBuilder.build())
				}
			}
		})

		LootTableEvents.MODIFY.register(LootTableEvents.Modify { _, _, id, tableBuilder, source ->
			if (source.isBuiltin && LootTables.DESERT_PYRAMID_ARCHAEOLOGY == id) {
				tableBuilder.modifyPools {
					it.with(ItemEntry.builder(ModItems.METAL_DETECTOR))
				}
			}
		})
	}
}