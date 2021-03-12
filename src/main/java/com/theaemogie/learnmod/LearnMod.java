package com.theaemogie.learnmod;

import com.theaemogie.learnmod.client.renderer.entity.SeatRenderer;
import com.theaemogie.learnmod.core.blocks.BlockLists;
import com.theaemogie.learnmod.core.entitytypes.EntityTypesList;
import com.theaemogie.learnmod.util.LoggerFormat;
import com.theaemogie.learnmod.util.StringModifier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Logger;

@Mod(References.MOD_ID)
public class LearnMod {

    public static final Logger LOGGER = References.LOGGER;
    public static LearnMod instance;

    public LearnMod() {
        LOGGER.info(new LoggerFormat(
                modifyString("Mod loading started!")
        ).get());
        instance = this;

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);
        bus.addListener(this::serverSetup);
    }

    @SuppressWarnings("SameParameterValue")
    private static String modifyString(String input, int... modifiers) {
        return new StringModifier().modifyString(input, modifiers);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        BlockLists.TRANSLUCENT_BLOCKS.forEach(block -> RenderTypeLookup.setRenderLayer(block, RenderType.translucent()));
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesList.SEAT_ENTITY, SeatRenderer::new);
        LOGGER.info(new LoggerFormat(
                modifyString("Client Setup!")
        ).get());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info(new LoggerFormat(
                modifyString("Common Setup!")
        ).get());
    }

    private void serverSetup(final FMLDedicatedServerSetupEvent event) {
        LOGGER.info(new LoggerFormat(
                modifyString("Dedicated Server Setup!")
        ).get());
    }
}
