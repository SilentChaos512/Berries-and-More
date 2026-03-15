package net.silentchaos512.berries;

import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.berries.setup.BamItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(BerriesMod.MOD_ID)
public final class BerriesMod {
    public static final String MOD_ID = "berriesandmore";
    public static final String MOD_NAME = "Berries and More";

    public static final Random RANDOM = new Random();
    public static final RandomSource RANDOM_SOURCE = RandomSource.create();
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public static BerriesMod INSTANCE;

    public BerriesMod(IEventBus modEventBus) {
        INSTANCE = this;

        BamBlocks.REGISTER.register(modEventBus);
        BamItems.REGISTER.register(modEventBus);
        modEventBus.addListener(BamItems::onBuildContentsOfCreativeTabs);
    }

    public static Identifier getId(String path) {
        if (path.contains(":")) {
            throw new IllegalArgumentException("path contains namespace");
        }
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}