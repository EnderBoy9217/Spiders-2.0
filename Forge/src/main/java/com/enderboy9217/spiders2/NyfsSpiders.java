package com.enderboy9217.spiders2;

import com.enderboy9217.spiders2.datagen.ModBlockStateProvider;
import com.enderboy9217.spiders2.datagen.ModItemModelProvider;
import com.enderboy9217.spiders2.datagen.ModLangProvider;
import com.enderboy9217.spiders2.datagen.ModLootTableProvider;
import com.enderboy9217.spiders2.datagen.ModRecipeProvider;
import com.enderboy9217.spiders2.datagen.ModSoundProvider;
import com.enderboy9217.spiders2.datagen.ModTagProvider;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsSpiders {

    public NyfsSpiders() {
        ModLoadingContext loadingContext = ModLoadingContext.get();
        loadingContext.registerConfig(ModConfig.Type.COMMON, Config.COMMON, "nyfsspiders.toml");
        CommonClass.init();
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();
        generator.addProvider(includeServer, new ModRecipeProvider(packOutput));
        generator.addProvider(includeServer, new ModLootTableProvider(packOutput));
        generator.addProvider(includeServer, new ModSoundProvider(packOutput, existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.Blocks(packOutput, event.getLookupProvider(), existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.Items(packOutput, event.getLookupProvider(), existingFileHelper));
        generator.addProvider(includeClient, new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(includeClient, new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(includeClient, new ModLangProvider(packOutput));
    }

}