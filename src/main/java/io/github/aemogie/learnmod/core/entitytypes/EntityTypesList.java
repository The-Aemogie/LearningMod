package io.github.aemogie.learnmod.core.entitytypes;

import io.github.aemogie.learnmod.client.renderer.entity.DefaultEntityRenderer;
import io.github.aemogie.learnmod.client.renderer.entity.SeatRenderer;
import io.github.aemogie.learnmod.client.renderer.entity.TestEntityRenderer;
import io.github.aemogie.learnmod.common.entity.DefaultEntity;
import io.github.aemogie.learnmod.common.entity.ModEntity;
import io.github.aemogie.learnmod.common.entity.SeatEntity;
import io.github.aemogie.learnmod.common.entity.TestEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

import static io.github.aemogie.learnmod.core.entitytypes.ModEntityType.Builder;
import static io.github.aemogie.learnmod.core.entitytypes.EntityTypeNames.SEAT;
import static io.github.aemogie.learnmod.core.entitytypes.EntityTypeNames.TEST;
import static io.github.aemogie.learnmod.core.entitytypes.EntityTypesRegister.register;

public class EntityTypesList {
	public static final ArrayList<ModEntityType<? extends ModEntity<?>>> ENTITY_TYPES = new ArrayList<>();
	
//	public static final EntityType<DefaultEntity> DEFAULT_ENTITY = Builder.of(DefaultEntity::new, EntityClassification.MISC, DefaultEntityRenderer::new).build(new ResourceLocation("default"));
	public static final EntityType<SeatEntity> SEAT_ENTITY = register(SEAT, Builder.of(SeatEntity::new, EntityClassification.MISC, SeatRenderer::new).sized(0.0f, 0.0f));
	public static final EntityType<TestEntity> TEST_ENTITY = register(TEST, Builder.of(TestEntity::new, EntityClassification.MISC, TestEntityRenderer::new).sized(1.0f, 1.0f));
}
