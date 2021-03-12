package com.theaemogie.learnmod.core.entitytypes.entitytypeslist;

import com.theaemogie.learnmod.common.entity.SeatEntity;
import com.theaemogie.learnmod.core.entitytypes.EntityTypeNames;
import com.theaemogie.learnmod.core.entitytypes.EntityTypesRegister;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class SeatEntityType {
    public static final EntityType GET = EntityTypesRegister.buildType(
            EntityTypeNames.SEAT.toString(),
            EntityType.Builder.<SeatEntity>of(
                    (type, world) -> new SeatEntity(world),
                    EntityClassification.MISC
            )
                    .sized(0.0F, 0.0F)
                    .setCustomClientFactory(
                            (spawnEntity, world) -> new SeatEntity(world)
                    )
    );
}
