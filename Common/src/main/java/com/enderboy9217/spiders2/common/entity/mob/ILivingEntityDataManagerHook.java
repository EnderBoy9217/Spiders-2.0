package com.enderboy9217.spiders2.common.entity.mob;

import net.minecraft.network.syncher.EntityDataAccessor;

public interface ILivingEntityDataManagerHook {
	public void onNotifyDataManagerChange(EntityDataAccessor<?> key);
}
