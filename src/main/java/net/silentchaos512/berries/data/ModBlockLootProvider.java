package net.silentchaos512.berries.data;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.berries.setup.BamItems;

import java.util.Collections;
import java.util.stream.Collectors;

public class ModBlockLootProvider extends BlockLootSubProvider {
    protected ModBlockLootProvider(HolderLookup.Provider provider) {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BamBlocks.REGISTER.getEntries().stream()
                .map(DeferredHolder::get)
                .collect(Collectors.toSet());
    }

    @Override
    protected void generate() {
        berryBush(BamBlocks.ACEROLA_BERRY_BUSH.get(), BamItems.ACEROLA_BERRIES.get());
        berryBush(BamBlocks.SEABERRY_BUSH.get(), BamItems.SEABERRIES.get());
        berryBush(BamBlocks.SNOWBERRY_BUSH.get(), BamItems.SNOWBERRIES.get());
        berryBush(BamBlocks.SCORCH_BERRY_BUSH.get(), BamItems.SCORCH_BERRIES.get());
        berryBush(BamBlocks.VOID_BERRY_BUSH.get(), BamItems.VOID_BERRIES.get());

        dropSelf(BamBlocks.BARLEY_BLOCK.get());

        add(
                BamBlocks.BARLEY.get(),
                createCropDrops(
                        BamBlocks.BARLEY_BLOCK.get(),
                        BamItems.BARLEY.get(),
                        BamItems.BARLEY_SEEDS.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(BamBlocks.BARLEY.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))
                )
        );
    }

    private void berryBush(Block bush, Item berries) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        add(
                bush,
                p_249159_ -> this.applyExplosionDecay(
                        p_249159_,
                        LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                                )
                                                .add(LootItem.lootTableItem(berries))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                                )
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                                )
                                                .add(LootItem.lootTableItem(berries))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                                )
                )
        );
    }
}
