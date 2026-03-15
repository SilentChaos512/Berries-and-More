package net.silentchaos512.berries.data;

import net.minecraft.core.HolderLookup;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.berries.setup.BamTags;

class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider(), BerriesMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BamTags.Blocks.STORAGE_BLOCKS_BARLEY).add(BamBlocks.BARLEY_BLOCK.get());
    }
}
