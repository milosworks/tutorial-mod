package net.vyrek.tutorialmod

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import net.vyrek.tutorialmod.block.ModBlocks

object TutorialModClient : ClientModInitializer {
	override fun onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout())
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAPDOOR, RenderLayer.getCutout())

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout())
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout())
	}
}