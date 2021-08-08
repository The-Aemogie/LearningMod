package io.github.aemogie.learnmod;

import io.github.aemogie.learnmod.core.ModBlocks;
import io.github.aemogie.learnmod.core.ModEntities;
import io.github.aemogie.learnmod.core.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.util.StringUtils.LoggerMessage;
import static io.github.aemogie.learnmod.util.StringUtils.formatString;

@Mod(References.MOD_ID)
public class LearnMod {
	public static LearnMod instance;
	public static Minecraft minecraft;
	
	public LearnMod() {
		instance = this;
		LOGGER.info(new LoggerMessage(formatString("Mod loading started!")));
		registerEvents(FMLJavaModLoadingContext.get().getModEventBus());
		GeckoLib.initialize();
	}
	
	private void registerEvents(IEventBus bus) {
		ModBlocks.REGISTRY.register(bus);
		ModItems.REGISTRY.register(bus);
		ModEntities.REGISTRY.register(bus);
	}
}