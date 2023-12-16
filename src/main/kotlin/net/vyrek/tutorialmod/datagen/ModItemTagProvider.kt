package net.vyrek.tutorialmod.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.ItemTags
import net.vyrek.tutorialmod.item.ModItems
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(
	output: FabricDataOutput,
	completableFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider.ItemTagProvider(output, completableFuture) {
	override fun configure(arg: RegistryWrapper.WrapperLookup?) {
		getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
			.add(ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS)
	}
}
