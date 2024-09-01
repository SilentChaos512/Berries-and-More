package net.silentchaos512.berries.setup;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.silentchaos512.berries.BerriesMod;

public class BamConst {
    public static final ResourceKey<LootTable> LOOT_TABLE_BARLEY_SEEDS =
            ResourceKey.create(Registries.LOOT_TABLE, BerriesMod.getId("barley_seeds"));
}
