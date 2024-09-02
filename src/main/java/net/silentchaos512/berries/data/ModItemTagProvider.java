package net.silentchaos512.berries.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.berries.setup.BamItems;
import net.silentchaos512.berries.setup.BamTags;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(GatherDataEvent event, BlockTagsProvider blocks) {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider(), blocks.contentsGetter(), BerriesMod.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BamTags.Items.STORAGE_BLOCKS_BARLEY).add(BamBlocks.BARLEY_BLOCK.asItem());

        tag(BamTags.Items.BERRIES).add(
                BamItems.ACEROLA_BERRIES.get(),
                BamItems.SEABERRIES.get(),
                BamItems.SNOWBERRIES.get(),
                BamItems.VOID_BERRIES.get(),
                BamItems.SCORCH_BERRIES.get()
        );
        tag(Tags.Items.FOODS_BERRY).addTag(BamTags.Items.BERRIES);

        tag(BamTags.Items.JUICES).add(
                BamItems.ACEROLA_BERRY_JUICE.get(),
                BamItems.SEABERRY_JUICE.get(),
                BamItems.SNOWBERRY_JUICE.get(),
                BamItems.VOID_BERRY_JUICE.get(),
                BamItems.SCORCH_BERRY_JUICE.get(),
                BamItems.SWEET_BERRY_JUICE.get()
        );
        tag(BamTags.Items.FOODS_JUICE).addTag(BamTags.Items.JUICES);

        tag(BamTags.Items.PIES).add(
                BamItems.ACEROLA_BERRY_PIE.get(),
                BamItems.SEABERRY_PIE.get(),
                BamItems.SNOWBERRY_PIE.get(),
                BamItems.VOID_BERRY_PIE.get(),
                BamItems.SCORCH_BERRY_PIE.get(),
                BamItems.SWEET_BERRY_PIE.get()
        );
        tag(BamTags.Items.FOODS_PIE).addTag(BamTags.Items.PIES);

        tag(BamTags.Items.TEAS).add(
                BamItems.ACEROLA_BERRY_TEA.get(),
                BamItems.SEABERRY_TEA.get(),
                BamItems.SNOWBERRY_TEA.get(),
                BamItems.VOID_BERRY_TEA.get(),
                BamItems.SCORCH_BERRY_TEA.get(),
                BamItems.SWEET_BERRY_TEA.get()
        );
        tag(BamTags.Items.FOODS_TEA).addTag(BamTags.Items.TEAS);

        tag(BamTags.Items.WINES).add(
                BamItems.ACEROLA_BERRY_WINE.get(),
                BamItems.SEABERRY_WINE.get(),
                BamItems.SNOWBERRY_WINE.get(),
                BamItems.VOID_BERRY_WINE.get(),
                BamItems.SCORCH_BERRY_WINE.get(),
                BamItems.SWEET_BERRY_WINE.get()
        );
        tag(BamTags.Items.FOODS_WINE).addTag(BamTags.Items.WINES);

        tag(Tags.Items.FOODS_BREAD).add(BamItems.BARLEY_BREAD.get());

        var barley = BamItems.BARLEY.get();
        tag(BamTags.Items.CROPS_BARLEY).add(barley);
        tag(Tags.Items.CROPS).addTag(BamTags.Items.CROPS_BARLEY);
        tag(ItemTags.COW_FOOD).add(barley);
        tag(ItemTags.GOAT_FOOD).add(barley);
        tag(ItemTags.HORSE_FOOD).add(barley);
        tag(ItemTags.LLAMA_FOOD).add(barley);
        tag(ItemTags.SHEEP_FOOD).add(barley);

        tag(ItemTags.LLAMA_TEMPT_ITEMS).add(BamBlocks.BARLEY_BLOCK.asItem());

        var barleySeeds = BamItems.BARLEY_SEEDS.get();
        tag(BamTags.Items.SEEDS_BARLEY).add(barleySeeds);
        tag(Tags.Items.SEEDS).addTag(BamTags.Items.SEEDS_BARLEY);
        tag(ItemTags.CHICKEN_FOOD).add(barleySeeds);
        tag(ItemTags.PARROT_FOOD).add(barleySeeds);
        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(barleySeeds);
    }
}
