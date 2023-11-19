package net.silentchaos512.berries.data;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.block.BerryBushBlock;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.lib.registry.BlockRegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class WorldGenGenerator extends DatapackBuiltinEntriesProvider {
    private static final ConfiguredFeature<?, ?> acerolaBerryBushes = new ConfiguredFeature<>(Feature.RANDOM_PATCH, berryBushConfig(BamBlocks.ACEROLA_BERRY_BUSH));
    private static final ConfiguredFeature<?, ?> seaberryBushes = new ConfiguredFeature<>(Feature.RANDOM_PATCH, berryBushConfig(BamBlocks.SEABERRY_BUSH));
    private static final ConfiguredFeature<?, ?> snowberryBushes = new ConfiguredFeature<>(Feature.RANDOM_PATCH, berryBushConfig(BamBlocks.SNOWBERRY_BUSH));
    private static final ConfiguredFeature<?, ?> voidBerryBushes = new ConfiguredFeature<>(Feature.RANDOM_PATCH, berryBushConfig(BamBlocks.VOID_BERRY_BUSH));
    private static final ConfiguredFeature<?, ?> scorchBerryBushes = new ConfiguredFeature<>(Feature.RANDOM_PATCH, berryBushConfig(BamBlocks.SCORCH_BERRY_BUSH));

    public static final ResourceKey<ConfiguredFeature<?, ?>> ACEROLA_BERRY_BUSHES = configuredFeatureKey(BerriesMod.getId("acerola_berry_bushes"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEABERRY_BUSHES = configuredFeatureKey(BerriesMod.getId("seaberry_bushes"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SNOWBERRY_BUSHES = configuredFeatureKey(BerriesMod.getId("snowberry_bushes"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_BERRY_BUSHES = configuredFeatureKey(BerriesMod.getId("void_berry_bushes"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCORCH_BERRY_BUSHES = configuredFeatureKey(BerriesMod.getId("scorch_berry_bushes"));

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ctx -> {
                ctx.register(ACEROLA_BERRY_BUSHES, acerolaBerryBushes);
                ctx.register(SEABERRY_BUSHES, seaberryBushes);
                ctx.register(SNOWBERRY_BUSHES, snowberryBushes);
                ctx.register(VOID_BERRY_BUSHES, voidBerryBushes);
                ctx.register(SCORCH_BERRY_BUSHES, scorchBerryBushes);
            })
            .add(Registries.PLACED_FEATURE, ctx -> {
                ctx.register(placedFeatureKey(ACEROLA_BERRY_BUSHES.location()), placedBushes(holderFeature(ctx, ACEROLA_BERRY_BUSHES)));
                ctx.register(placedFeatureKey(SEABERRY_BUSHES.location()), placedBushes(holderFeature(ctx, SEABERRY_BUSHES)));
                ctx.register(placedFeatureKey(SNOWBERRY_BUSHES.location()), placedBushes(holderFeature(ctx, SNOWBERRY_BUSHES)));
                ctx.register(placedFeatureKey(VOID_BERRY_BUSHES.location()), placedBushes(holderFeature(ctx, VOID_BERRY_BUSHES)));
                ctx.register(placedFeatureKey(SCORCH_BERRY_BUSHES.location()), placedBushesNether(holderFeature(ctx, SCORCH_BERRY_BUSHES)));
            })
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ctx -> {
                ctx.register(biomeModifierKey(BerriesMod.getId("savanna")),
                        new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                                ctx.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_SAVANNA),
                                HolderSet.direct(holderPlaced(ctx, ACEROLA_BERRY_BUSHES.location())),
                                GenerationStep.Decoration.VEGETAL_DECORATION
                        )
                );
                ctx.register(biomeModifierKey(BerriesMod.getId("plains")),
                        new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                                ctx.lookup(Registries.BIOME).getOrThrow(TagKey.create(Registries.BIOME, BerriesMod.getId("is_plains"))),
                                HolderSet.direct(holderPlaced(ctx, SNOWBERRY_BUSHES.location())),
                                GenerationStep.Decoration.VEGETAL_DECORATION
                        )
                );
                ctx.register(biomeModifierKey(BerriesMod.getId("mountains")),
                        new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                                ctx.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_MOUNTAIN),
                                HolderSet.direct(holderPlaced(ctx, SEABERRY_BUSHES.location())),
                                GenerationStep.Decoration.VEGETAL_DECORATION
                        )
                );
                ctx.register(biomeModifierKey(BerriesMod.getId("hills")),
                        new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                                ctx.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_HILL),
                                HolderSet.direct(holderPlaced(ctx, SEABERRY_BUSHES.location())),
                                GenerationStep.Decoration.VEGETAL_DECORATION
                        )
                );
                ctx.register(biomeModifierKey(BerriesMod.getId("nether")),
                        new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                                ctx.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_NETHER),
                                HolderSet.direct(holderPlaced(ctx, SCORCH_BERRY_BUSHES.location())),
                                GenerationStep.Decoration.VEGETAL_DECORATION
                        )
                );
                ctx.register(biomeModifierKey(BerriesMod.getId("the_end")),
                        new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                                ctx.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_END),
                                HolderSet.direct(holderPlaced(ctx, VOID_BERRY_BUSHES.location())),
                                GenerationStep.Decoration.VEGETAL_DECORATION
                        )
                );
            });

    public WorldGenGenerator(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider(), BUILDER, Collections.singleton(BerriesMod.MOD_ID));
    }

    @NotNull
    private static RandomPatchConfiguration berryBushConfig(BlockRegistryObject<BerryBushBlock> berryBush) {
        return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(berryBush.asBlockState().setValue(BerryBushBlock.AGE, Integer.valueOf(3))))
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey(ResourceLocation name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, name);
    }

    protected static ResourceKey<PlacedFeature> placedFeatureKey(ResourceLocation name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, name);
    }

    protected static ResourceKey<BiomeModifier> biomeModifierKey(ResourceLocation name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, name);
    }

    public static PlacedFeature placedBushes(Holder<ConfiguredFeature<?, ?>> feature) {
        return new PlacedFeature(feature, ImmutableList.of(
                RarityFilter.onAverageOnceEvery(32),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome()
        ));
    }

    public static PlacedFeature placedBushesNether(Holder<ConfiguredFeature<?, ?>> feature) {
        return new PlacedFeature(feature, ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));
    }

    public static List<PlacementModifier> placements(int minHeight, int maxHeight, int count) {
        return ImmutableList.of(
                HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)),
                InSquarePlacement.spread(),
                CountPlacement.of(count),
                BiomeFilter.biome()
        );
    }

    public static Holder<ConfiguredFeature<?, ?>> holderFeature(BootstapContext<PlacedFeature> ctx, ResourceKey<ConfiguredFeature<?, ?>> location) {
        return ctx.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(location);
    }

    public static Holder<PlacedFeature> holderPlaced(BootstapContext<BiomeModifier> ctx, ResourceLocation location) {
        return ctx.lookup(Registries.PLACED_FEATURE).getOrThrow(placedFeatureKey(location));
    }
}
