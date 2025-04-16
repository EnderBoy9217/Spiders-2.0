package com.enderboy9217.spiders2.init;

import com.enderboy9217.spiders2.registration.RegistrationProvider;
import com.enderboy9217.spiders2.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ItemInit {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);

    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }

    public static void loadClass() {
    }
}
