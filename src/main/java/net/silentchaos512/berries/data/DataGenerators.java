package net.silentchaos512.berries.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        gen.addProvider(true, new ModBlockStateProvider(event));
        gen.addProvider(true, new ModItemModelProvider(event));
        gen.addProvider(true, new ModLanguageProvider(event.getGenerator()));

        gen.addProvider(true, new ModRecipeProvider(event.getGenerator()));

        gen.addProvider(true, new WorldGenGenerator(event));
    }
}
