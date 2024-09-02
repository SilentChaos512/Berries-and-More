package net.silentchaos512.berries.data;

import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.silentchaos512.berries.setup.BamItems;
import net.silentchaos512.berries.setup.BamTags;

public class ModDataMapsProvider extends DataMapProvider {
    public ModDataMapsProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider());
    }

    @Override
    protected void gather() {
        final var compostables = builder(NeoForgeDataMaps.COMPOSTABLES);
        compostables.add(BamTags.Items.BERRIES, new Compostable(0.3f, false), false);
        compostables.add(BamTags.Items.PIES, new Compostable(1.0f, false), false);
        compostables.add(BamTags.Items.SEEDS_BARLEY, new Compostable(0.3f, true), false);
        compostables.add(BamTags.Items.CROPS_BARLEY, new Compostable(0.65f, false), false);
        compostables.add(BamItems.BARLEY_BREAD, new Compostable(0.85f, false), false);
        compostables.add(BamItems.TOASTED_BARLEY, new Compostable(0.5f, false), false);
        compostables.add(BamTags.Items.STORAGE_BLOCKS_BARLEY, new Compostable(0.85f, false), false);
        compostables.build();
    }
}
