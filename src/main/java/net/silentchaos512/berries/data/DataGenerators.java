package net.silentchaos512.berries.data;

import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.silentchaos512.berries.data.client.ModLanguageProvider;
import net.silentchaos512.berries.data.client.ModModelProvider;

@EventBusSubscriber
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator gen = event.getGenerator();
        var packOutput = event.getGenerator().getPackOutput();
        var lookupProvider = event.getLookupProvider();

        gen.addProvider(true, new ModModelProvider(packOutput));
        gen.addProvider(true, new ModLanguageProvider(event.getGenerator()));

        gen.addProvider(true, new ModLootTableProvider(event));
        gen.addProvider(true, new ModGlobalLootModifierProvider(event));

        var blockTagsUnused = new ModBlockTagsProvider(event);
        gen.addProvider(true, blockTagsUnused);
        gen.addProvider(true, new ModItemTagProvider(packOutput, lookupProvider, blockTagsUnused));
        gen.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));

        gen.addProvider(true, new WorldGenGenerator(event));

        gen.addProvider(true, new ModDataMapsProvider(event));
    }
}
