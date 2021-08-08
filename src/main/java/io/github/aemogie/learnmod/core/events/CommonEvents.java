package io.github.aemogie.learnmod.core.events;

import io.github.aemogie.learnmod.common.entity.ModEntityType;
import io.github.aemogie.learnmod.core.ModEntities;
import io.github.aemogie.learnmod.util.StringUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;

import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.References.MOD_ID;
import static io.github.aemogie.learnmod.util.StringUtils.formatString;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CommonEvents {
	
	@SubscribeEvent
	public static void commonSetup(final FMLCommonSetupEvent event) {
		LOGGER.info(new StringUtils.LoggerMessage(formatString("Common Setup!")));
	}
	
	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static void entityAttributes(@Nonnull final EntityAttributeCreationEvent event) {
		ModEntities.REGISTRY.getEntries().stream()
		.filter(entityType -> LivingEntity.class.isAssignableFrom(((ModEntityType<?>) entityType.get()).ENTITY_CLASS))
		.forEach(entityType -> event.put((ModEntityType<LivingEntity>) entityType.get(), MobEntity.createMobAttributes().build()));
	}
}