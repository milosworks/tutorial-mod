package net.vyrek.tutorialmod.util

import net.minecraft.util.Identifier
import net.vyrek.tutorialmod.TutorialMod

object ModIdentifier {
	fun identifier(path: String): Identifier {
		return Identifier(TutorialMod.MOD_ID, path)
	}

	fun identifierString(path: String): String {
		return "${TutorialMod.MOD_ID}:${path}"
	}
}