package io.github.aemogie.learnmod;

import io.github.aemogie.learnmod.core.ModBlocks;
import io.github.aemogie.learnmod.core.ModEntities;
import io.github.aemogie.learnmod.core.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.util.StringUtils.LoggerMessage;
import static io.github.aemogie.learnmod.util.StringUtils.formatString;

@Mod(References.MOD_ID)
public class LearnMod {
	public static LearnMod instance;
	public static Minecraft minecraft;
	
	public LearnMod() {
		registerEvents(FMLJavaModLoadingContext.get().getModEventBus());
		instance = this;
		LOGGER.info(new LoggerMessage(formatString("Mod loading started!")));
	}
	
	private void registerEvents(IEventBus bus) {
		ModBlocks.REGISTRY.register(bus);
		ModItems.REGISTRY.register(bus);
		ModEntities.REGISTRY.register(bus);
	}
}