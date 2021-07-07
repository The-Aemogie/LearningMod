package io.github.aemogie.learnmod.core.events;

import io.github.aemogie.learnmod.core.ModBlocks;
import io.github.aemogie.learnmod.core.ModEntities;
import io.github.aemogie.learnmod.util.StringUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static io.github.aemogie.learnmod.LearnMod.minecraft;
import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.References.MOD_ID;
import static io.github.aemogie.learnmod.util.StringUtils.formatString;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		minecraft = event.getMinecraftSupplier().get();
		LOGGER.info(new StringUtils.LoggerMessage(formatString("Client Setup!")));
		setupRenderers();
	}
	
	private static void setupRenderers() {
		ModBlocks.setupRenderers();
		ModEntities.setupRenderers();
	}
}
