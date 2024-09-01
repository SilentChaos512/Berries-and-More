package net.silentchaos512.berries.data;

import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        gen.addProvider(true, new ModBlockStateProvider(event));
        gen.addProvider(true, new ModItemModelProvider(event));
        gen.addProvider(true, new ModLanguageProvider(event.getGenerator()));

        gen.addProvider(true, new ModRecipeProvider(event));

        gen.addProvider(true, new WorldGenGenerator(event));
    }
}
