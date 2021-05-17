package io.github.aemogie.learnmod;

import io.github.aemogie.learnmod.common.entity.ModEntity;
import io.github.aemogie.learnmod.core.blocks.BlockLists;
import io.github.aemogie.learnmod.core.entitytypes.ModEntityType;
import io.github.aemogie.learnmod.util.LoggerFormat;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static io.github.aemogie.learnmod.References.LOGGER;
import static io.github.aemogie.learnmod.core.entitytypes.EntityTypesList.ENTITY_TYPES;
import static io.github.aemogie.learnmod.util.StringModifier.modifyString;

@Mod(References.MOD_ID)
public class LearnMod {
	public static LearnMod instance;
	
	public LearnMod() {
		LOGGER.info(new LoggerFormat(modifyString("Mod loading started!")));
		instance = this;
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::clientSetup);
		bus.addListener(this::commonSetup);
		bus.addListener(this::serverSetup);
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {
		for (Block block : BlockLists.TRANSLUCENT_BLOCKS) {
			RenderTypeLookup.setRenderLayer(block, RenderType.translucent());
			LOGGER.info(new LoggerFormat(modifyString("Made block \"" + block.getRegistryName() + "\" translucent.")));
		}
		
		for (ModEntityType<?> entityType : ENTITY_TYPES) {
			RenderingRegistry.registerEntityRenderingHandler(entityType, entityType.getRenderFactory());
		}
		
		LOGGER.info(new LoggerFormat(modifyString("Client Setup!")));
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		LOGGER.info(new LoggerFormat(modifyString("Common Setup!")));
	}
	
	private void serverSetup(final FMLDedicatedServerSetupEvent event) {
		LOGGER.info(new LoggerFormat(modifyString("Dedicated Server Setup!")));
	}
	
}
