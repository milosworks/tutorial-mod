package net.vyrek.tutorialmod

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object TutorialMod : ModInitializer {
	@JvmStatic
	val MOD_ID: String = "tutorialmod"
    private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("Hello Fabric world!")
	}
}