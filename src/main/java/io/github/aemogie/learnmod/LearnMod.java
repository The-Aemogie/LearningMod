package io.github.aemogie.learnmod;

import io.github.aemogie.learnmod.core.ModBlocks;
import io.github.aemogie.learnmod.core.ModEntities;
import io.github.aemogie.learnmod.core.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.util.StringUtils.*;

@Mod(References.MOD_ID)
public class LearnMod {
	public static LearnMod instance;
	public static Minecraft minecraft;
	
	public LearnMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModBlocks.REGISTRY.register(bus);
		ModItems.REGISTRY.register(bus);
		ModEntities.REGISTRY.register(bus);
		
		bus.addListener(this::clientSetup);
		bus.addListener(this::commonSetup);
		bus.addListener(this::serverSetup);
		instance = this;
		LOGGER.info(new LoggerMessage(formatString("Mod loading started!")));
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {
		LOGGER.info(new LoggerMessage(formatString("Client Setup!")));
		
		ModBlocks.setupRenderers();
		ModEntities.setupRenderers();
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		LOGGER.info(new LoggerMessage(fs("Common Setup!")));
	}
	
	private void serverSetup(final FMLDedicatedServerSetupEvent event) {
		LOGGER.info(new LoggerMessage(fs("Dedicated Server Setup!")));
	}
}
