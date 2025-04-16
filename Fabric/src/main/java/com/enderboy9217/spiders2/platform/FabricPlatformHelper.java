package com.enderboy9217.spiders2.platform;

import com.enderboy9217.spiders2.Config;
import com.enderboy9217.spiders2.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public boolean getPreventClimbingInRain() {
        return Config.getConfig().isPreventClimbingInRain();
    }

    @Override
    public boolean getPathFinderDebugPreview() {
        return Config.getConfig().isPathFinderDebugPreview();
    }


}
