package net.vyrek.tutorialmod.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.data.DataOutput
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.BlockStatePropertyLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.predicate.StatePredicate
import net.vyrek.tutorialmod.block.ModBlocks
import net.vyrek.tutorialmod.block.custom.CornCropBlock
import net.vyrek.tutorialmod.block.custom.TomatoCropBlock
import net.vyrek.tutorialmod.item.ModItems

class ModLootTableProvider(dataOutput: FabricDataOutput) : FabricBlockLootTableProvider(dataOutput) {
	override fun generate() {
		addDrop(ModBlocks.RUBY_BLOCK)
		addDrop(ModBlocks.RAW_RUBY_BLOCK)
		addDrop(ModBlocks.SOUND_BLOCK)

		addDrop(
			ModBlocks.RUBY_ORE,
			dropWithSilkTouchAndQuantity(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY, 1.0f, 2.0f)
		)
		addDrop(
			ModBlocks.DEEPSLATE_RUBY_ORE,
			dropWithSilkTouchAndQuantity(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY, 2.0f, 3.0f)
		)
		addDrop(
			ModBlocks.NETHER_RUBY_ORE,
			dropWithSilkTouchAndQuantity(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY, 2.0f, 4.0f)
		)
		addDrop(
			ModBlocks.END_STONE_RUBY_ORE,
			dropWithSilkTouchAndQuantity(ModBlocks.END_STONE_RUBY_ORE, ModItems.RAW_RUBY, 2.0f, 6.0f)
		)

		addDrop(ModBlocks.RUBY_STAIRS)
		addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB))
		addDrop(ModBlocks.RUBY_BUTTON)
		addDrop(ModBlocks.RUBY_PRESSURE_PLATE)
		addDrop(ModBlocks.RUBY_FENCE)
		addDrop(ModBlocks.RUBY_FENCE_GATE)
		addDrop(ModBlocks.RUBY_WALL)
		addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR))
		addDrop(ModBlocks.RUBY_TRAPDOOR)

		addDrop(
			ModBlocks.TOMATO_CROP, cropDrops(
				ModBlocks.TOMATO_CROP,
				ModItems.TOMATO,
				ModItems.TOMATO_SEEDS,
				BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP).properties(
					StatePredicate.Builder.create().exactMatch(TomatoCropBlock.AGE, 5)
				)
			)
		)

		addDrop(
			ModBlocks.CORN_CROP, cropDrops(
				ModBlocks.CORN_CROP,
				ModItems.CORN,
				ModItems.CORN_SEEDS,
				BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(
					StatePredicate.Builder.create().exactMatch(CornCropBlock.AGE, 8)
				)
			)
		)
	}

	private fun dropWithSilkTouchAndQuantity(drop: Block, item: Item, min: Float, max: Float): LootTable.Builder {
		return dropsWithSilkTouch(
			drop,
			applyExplosionDecay(
				drop,
				ItemEntry.builder(item).apply(
					SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max))
				).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
			)
		)
	}
}