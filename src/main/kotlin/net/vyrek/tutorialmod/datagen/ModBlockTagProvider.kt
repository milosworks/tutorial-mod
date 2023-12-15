package net.vyrek.tutorialmod.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.vyrek.tutorialmod.block.ModBlocks
import net.vyrek.tutorialmod.util.ModTags
import java.util.concurrent.CompletableFuture

class ModBlockTagProvider(
	output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider.BlockTagProvider(output, registriesFuture) {
	override fun configure(arg: RegistryWrapper.WrapperLookup?) {
		getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
			.add(ModBlocks.RUBY_ORE)
			.add(ModBlocks.DEEPSLATE_RUBY_ORE)
			.add(ModBlocks.NETHER_RUBY_ORE)
			.add(ModBlocks.END_STONE_RUBY_ORE)
			.forceAddTag(BlockTags.GOLD_ORES)
			.forceAddTag(BlockTags.EMERALD_ORES)
			.forceAddTag(BlockTags.REDSTONE_ORES)
			.forceAddTag(BlockTags.LAPIS_ORES)
			.forceAddTag(BlockTags.DIAMOND_ORES)
			.forceAddTag(BlockTags.IRON_ORES)
			.forceAddTag(BlockTags.COPPER_ORES)
			.forceAddTag(BlockTags.COAL_ORES);

		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
			.add(ModBlocks.RAW_RUBY_BLOCK)
			.add(ModBlocks.RUBY_BLOCK)
			.add(ModBlocks.RUBY_ORE)
			.add(ModBlocks.DEEPSLATE_RUBY_ORE)
			.add(ModBlocks.NETHER_RUBY_ORE)
			.add(ModBlocks.END_STONE_RUBY_ORE)
			.add(ModBlocks.SOUND_BLOCK)

		getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
			.add(ModBlocks.RUBY_BLOCK)

		getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
			.add(ModBlocks.RAW_RUBY_BLOCK)
			.add(ModBlocks.RUBY_ORE)

		getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
			.add(ModBlocks.DEEPSLATE_RUBY_ORE)

		getOrCreateTagBuilder(
			TagKey.of(RegistryKeys.BLOCK, Identifier("fabric", "needs_tool_level_4"))
		)
			.add(ModBlocks.END_STONE_RUBY_ORE)

		getOrCreateTagBuilder(BlockTags.STAIRS)
			.add(ModBlocks.RUBY_STAIRS)
		getOrCreateTagBuilder(BlockTags.SLABS)
			.add(ModBlocks.RUBY_SLAB)

		getOrCreateTagBuilder(BlockTags.BUTTONS)
			.add(ModBlocks.RUBY_BUTTON)
		getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
			.add(ModBlocks.RUBY_PRESSURE_PLATE)

		getOrCreateTagBuilder(BlockTags.FENCES)
			.add(ModBlocks.RUBY_FENCE)
		getOrCreateTagBuilder(BlockTags.FENCE_GATES)
			.add(ModBlocks.RUBY_FENCE_GATE)
		getOrCreateTagBuilder(BlockTags.WALLS)
			.add(ModBlocks.RUBY_WALL)

		getOrCreateTagBuilder(BlockTags.DOORS)
			.add(ModBlocks.RUBY_DOOR)
		getOrCreateTagBuilder(BlockTags.TRAPDOORS)
			.add(ModBlocks.RUBY_TRAPDOOR)

	}
}
