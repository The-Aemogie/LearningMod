package io.github.aemogie.learnmod.core;

import io.github.aemogie.learnmod.client.renderer.entity.SeatRenderer;
import io.github.aemogie.learnmod.client.renderer.entity.Test;
import io.github.aemogie.learnmod.common.entity.SeatEntity;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static io.github.aemogie.learnmod.References.MOD_ID;
import static net.minecraft.entity.EntityType.Builder;
import static net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);
	
	public static final RegistryObject<EntityType<SeatEntity>> SEAT_ENTITY = register("seat_entity", Builder.of(SeatEntity::new, EntityClassification.MISC).sized(0.0f, 0.0f));
	public static final RegistryObject<EntityType<TestEntity>> TEST_ENTITY = register("test_entity", Builder.of(TestEntity::new, EntityClassification.MISC).sized(1.0f, 1.0f));
	
	public static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
		return REGISTRY.register(name, () -> builder.build(name));
	}
	
	public static void setupRenderers() {
		registerEntityRenderingHandler(SEAT_ENTITY.get(), SeatRenderer::new);
		registerEntityRenderingHandler(TEST_ENTITY.get(), Test::new);
	}
	
}
