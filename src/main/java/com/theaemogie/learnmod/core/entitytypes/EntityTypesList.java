package com.theaemogie.learnmod.core.entitytypes;

import com.theaemogie.learnmod.common.entity.SeatEntity;
import com.theaemogie.learnmod.core.entitytypes.entitytypeslist.SeatEntityType;
import net.minecraft.entity.EntityType;

import java.util.ArrayList;

public class EntityTypesList {
    //    public static final EntityType<SeatEntity> SEAT_ENTITY = SeatEntityType.ENTITY;
    public static final ArrayList<EntityType> ENTITY_TYPES = new ArrayList<>();

    public static final EntityType<SeatEntity> SEAT_ENTITY = SeatEntityType.GET;
}
