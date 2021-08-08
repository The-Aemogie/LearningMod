package io.github.aemogie.learnmod.client.entity.models

import software.bernie.geckolib3.model.AnimatedGeoModel
import net.minecraft.util.ResourceLocation
import io.github.aemogie.learnmod.References
import software.bernie.geckolib3.core.IAnimatable

class GeoEntityModel<T : IAnimatable>(name: String) : AnimatedGeoModel<T>() {
	private val model = ResourceLocation(References.MOD_ID, "geo/$name.geo.json")
	private val texture = ResourceLocation(References.MOD_ID, "textures/entities/$name.png")
	private val animation: ResourceLocation = ResourceLocation(References.MOD_ID, "animations/$name.animation.json")
	
	override fun getModelLocation(entity: T): ResourceLocation = model
	override fun getTextureLocation(entity: T): ResourceLocation = texture
	override fun getAnimationFileLocation(entity: T): ResourceLocation = animation
}