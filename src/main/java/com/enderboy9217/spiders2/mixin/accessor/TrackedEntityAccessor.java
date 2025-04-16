package com.enderboy9217.spiders2.mixin.accessor;

import net.minecraft.server.network.TrackedEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TrackedEntity.class)
public interface TrackedEntityAccessor {
    @Accessor("tickCount")
    int getTickCount();
}