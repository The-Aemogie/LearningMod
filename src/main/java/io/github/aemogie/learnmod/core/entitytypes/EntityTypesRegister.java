package io.github.aemogie.learnmod.core.entitytypes;

import io.github.aemogie.learnmod.References;
import io.github.aemogie.learnmod.common.entity.ModEntity;
import io.github.aemogie.learnmod.util.LoggerFormat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.util.StringModifier.*;

@Mod.EventBusSubscriber(modid = References.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypesRegister {
	
	
	public static <T extends ModEntity<?>> ModEntityType<T> register(ResourceLocation id, ModEntityType.Builder<T> builder) {
		ModEntityType<T> type = builder.build(id);
		type.setRegistryName(id);
		EntityTypesList.ENTITY_TYPES.add(type);
		LOGGER.info(new LoggerFormat(
				modifyString("Successfully added entity type: "),
				modifyString(Objects.requireNonNull(type.getRegistryName()).toString(), GREEN, BOLD))
		);
		return type;
	}
	
	@SubscribeEvent
	public static void registerTypes(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(EntityTypesList.ENTITY_TYPES.toArray(new EntityType[0]));
		EntityTypesList.ENTITY_TYPES.clear();
	}
}
