package io.github.aemogie.learnmod.core;

import io.github.aemogie.learnmod.client.entity.models.TestModel;
import io.github.aemogie.learnmod.client.entity.renderer.SeatRenderer;
import io.github.aemogie.learnmod.client.entity.renderer.TestEntityRenderer;
import io.github.aemogie.learnmod.common.entity.ModEntityType;
import io.github.aemogie.learnmod.common.entity.ModEntityType.Builder;
import io.github.aemogie.learnmod.common.entity.SeatEntity;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static io.github.aemogie.learnmod.References.MOD_ID;
import static net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);
	
	public static final RegistryObject<ModEntityType<SeatEntity>> SEAT_ENTITY = register("seat_entity", Builder.of(SeatEntity.class, EntityClassification.MISC, SeatRenderer::new).sized(0.0f, 0.0f));
	
	public static final RegistryObject<ModEntityType<TestEntity>> TEST_ENTITY = register("test_entity", Builder.of(TestEntity.class, EntityClassification.MISC, manager -> new TestEntityRenderer<>(manager, TestModel::new)).sized(1.0f, 1.0f));
	
	public static <T extends Entity> RegistryObject<ModEntityType<T>> register(String name, Builder<T> builder) {
		return REGISTRY.register(name, () -> builder.build(name));
	}
	
	public static void setupRenderers() {
		for (RegistryObject<EntityType<?>> entityType : REGISTRY.getEntries()) {
			setupRenderer(entityType.get());
		}
	}
	
	private static <T extends Entity> void setupRenderer(EntityType<T> entityType) {
		registerEntityRenderingHandler(entityType, ((ModEntityType<T>) entityType).RENDERER);
	}
}