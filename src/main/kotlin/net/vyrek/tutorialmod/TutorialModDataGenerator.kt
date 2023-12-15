package net.vyrek.tutorialmod

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.vyrek.tutorialmod.datagen.*

object TutorialModDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack: FabricDataGenerator.Pack = fabricDataGenerator.createPack()

		pack.addProvider { output, registriesFuture -> ModBlockTagProvider(output, registriesFuture) }
		pack.addProvider { output, registriesFuture -> ModItemTagProvider(output, registriesFuture) }
		pack.addProvider { output, _ -> ModLootTableProvider(output) }
		pack.addProvider { output, _ -> ModModelProvider(output) }
		pack.addProvider { output, _ -> ModRecipeProvider(output) }
	}
}