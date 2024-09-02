package net.silentchaos512.berries.setup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.silentchaos512.berries.BerriesMod;

public class BamTags {
    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS_BARLEY = common("storage_blocks/barley");

        private static TagKey<Block> common(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }
    public static class Items {
        public static final TagKey<Item> STORAGE_BLOCKS_BARLEY = common("storage_blocks/barley");

        public static final TagKey<Item> BERRIES = mod("berries");
        public static final TagKey<Item> JUICES = mod("juices");
        public static final TagKey<Item> PIES = mod("pies");
        public static final TagKey<Item> TEAS = mod("teas");
        public static final TagKey<Item> WINES = mod("wines");

        public static final TagKey<Item> CROPS_BARLEY = common("crops/barley");
        public static final TagKey<Item> FOODS_JUICE = common("foods/juice");
        public static final TagKey<Item> FOODS_PIE = common("foods/pie");
        public static final TagKey<Item> FOODS_TEA = common("foods/tea");
        public static final TagKey<Item> FOODS_WINE = common("foods/wine");
        public static final TagKey<Item> SEEDS_BARLEY = common("seeds/barley");

        private static TagKey<Item> common(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<Item> mod(String path) {
            return ItemTags.create(BerriesMod.getId(path));
        }
    }
}
