package com.theaemogie.learnmod.core.entitytypes;

import com.theaemogie.learnmod.References;
import com.theaemogie.learnmod.common.entity.SeatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = References.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypesRegister {


    public static <T extends Entity> EntityType<T> buildType(String id, EntityType.Builder<T> builder) {
        EntityType<T> type = builder.build(id);
        type.setRegistryName(id);
        EntityTypesList.ENTITY_TYPES.add(type);
        return type;
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerTypes(final RegistryEvent.Register<EntityType<?>> event) {
        EntityTypesList.ENTITY_TYPES.forEach(type -> event.getRegistry().register(type));
        EntityTypesList.ENTITY_TYPES.clear();
    }
}
