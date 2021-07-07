package io.github.aemogie.learnmod.core.events;

import io.github.aemogie.learnmod.util.StringUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.References.MOD_ID;
import static io.github.aemogie.learnmod.util.StringUtils.fs;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ServerEvents {
	@SubscribeEvent
	public static void serverSetup(final FMLDedicatedServerSetupEvent event) {
		LOGGER.info(new StringUtils.LoggerMessage(fs("Dedicated Server Setup!")));
	}
}
