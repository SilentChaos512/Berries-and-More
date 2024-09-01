package net.silentchaos512.berries.data;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamConst;

import java.util.List;
import java.util.Optional;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider(), BerriesMod.MOD_ID);
    }

    @Override
    protected void start() {
        var biomeHolderGetter = this.registries.lookupOrThrow(Registries.BIOME);

        add(
                "barley_seeds_from_grass",
                new AddTableLootModifier(
                        new LootItemCondition[]{
                                AnyOfCondition.anyOf(
                                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("blocks/short_grass")),
                                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("blocks/tall_grass"))
                                ).build(),
                                new LocationCheck(
                                        Optional.of(
                                                new LocationPredicate.Builder()
                                                        .setBiomes(
                                                                HolderSet.direct(
                                                                        biomeHolderGetter.getOrThrow(Biomes.BIRCH_FOREST),
                                                                        biomeHolderGetter.getOrThrow(Biomes.FLOWER_FOREST),
                                                                        biomeHolderGetter.getOrThrow(Biomes.FOREST),
                                                                        biomeHolderGetter.getOrThrow(Biomes.GROVE),
                                                                        biomeHolderGetter.getOrThrow(Biomes.MEADOW),
                                                                        biomeHolderGetter.getOrThrow(Biomes.PLAINS),
                                                                        biomeHolderGetter.getOrThrow(Biomes.WINDSWEPT_FOREST),
                                                                        biomeHolderGetter.getOrThrow(Biomes.WINDSWEPT_HILLS)
                                                                )
                                                        )
                                                        .build()
                                        ),
                                        BlockPos.ZERO
                                )
                        },
                        BamConst.LOOT_TABLE_BARLEY_SEEDS
                ),
                List.of()
        );
    }
}
