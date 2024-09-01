package net.silentchaos512.berries.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.data.loot.packs.VanillaLootTableProvider;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.silentchaos512.berries.setup.BamConst;
import net.silentchaos512.berries.setup.BamItems;

import java.util.Collections;
import java.util.List;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(GatherDataEvent event) {
        super(
                event.getGenerator().getPackOutput(),
                Collections.emptySet(),
                VanillaLootTableProvider.create(event.getGenerator().getPackOutput(), event.getLookupProvider()).getTables(),
                event.getLookupProvider()
        );
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return List.of(
                new SubProviderEntry(ModBlockLootProvider::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(provider -> (LootTableSubProvider) output -> {
                    HolderLookup.RegistryLookup<Enchantment> registrylookup = provider.lookupOrThrow(Registries.ENCHANTMENT);
                    output.accept(
                            BamConst.LOOT_TABLE_BARLEY_SEEDS,
                            new LootTable.Builder()
                                    .withPool(
                                            LootPool.lootPool()
                                                    .setRolls(ConstantValue.exactly(1))
                                                    .add(
                                                            LootItem.lootTableItem(BamItems.BARLEY_SEEDS)
                                                                    .when(LootItemRandomChanceCondition.randomChance(0.0625f))
                                                                    .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE), 2))
                                                    )
                                    )
                    );
                }, LootContextParamSets.BLOCK)
        );
    }
}
