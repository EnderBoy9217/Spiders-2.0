package com.enderboy9217.spiders2.common.entity.mob;

import net.minecraft.nbt.CompoundTag;

public interface IEntityReadWriteHook {
	public void onRead(CompoundTag nbt);
	
	public void onWrite(CompoundTag nbt);
}
