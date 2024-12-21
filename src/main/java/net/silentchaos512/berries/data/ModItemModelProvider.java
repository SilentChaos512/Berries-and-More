package net.silentchaos512.berries.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.berries.setup.BamItems;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), BerriesMod.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void registerModels() {
        blockItemModel(BamBlocks.BARLEY_BLOCK.get());

        // Berries
        simple(BamItems.ACEROLA_BERRIES);
        simple(BamItems.SEABERRIES);
        simple(BamItems.SNOWBERRIES);
        simple(BamItems.VOID_BERRIES);
        simple(BamItems.SCORCH_BERRIES);
        // Seeds
        simple(BamItems.BARLEY_SEEDS);

        // Juice
        simple(BamItems.ACEROLA_BERRY_JUICE);
        simple(BamItems.SEABERRY_JUICE);
        simple(BamItems.SNOWBERRY_JUICE);
        simple(BamItems.VOID_BERRY_JUICE);
        simple(BamItems.SCORCH_BERRY_JUICE);
        simple(BamItems.SWEET_BERRY_JUICE);
        simple(BamItems.GLOW_BERRY_JUICE);
        // Pies
        simple(BamItems.ACEROLA_BERRY_PIE);
        simple(BamItems.SEABERRY_PIE);
        simple(BamItems.SNOWBERRY_PIE);
        simple(BamItems.VOID_BERRY_PIE);
        simple(BamItems.SCORCH_BERRY_PIE);
        simple(BamItems.SWEET_BERRY_PIE);
        simple(BamItems.GLOW_BERRY_PIE);
        // Tea
        simple(BamItems.ACEROLA_BERRY_TEA);
        simple(BamItems.SEABERRY_TEA);
        simple(BamItems.SNOWBERRY_TEA);
        simple(BamItems.VOID_BERRY_TEA);
        simple(BamItems.SCORCH_BERRY_TEA);
        simple(BamItems.SWEET_BERRY_TEA);
        simple(BamItems.GLOW_BERRY_TEA);
        // Wine
        simple(BamItems.ACEROLA_BERRY_WINE);
        simple(BamItems.SEABERRY_WINE);
        simple(BamItems.SNOWBERRY_WINE);
        simple(BamItems.VOID_BERRY_WINE);
        simple(BamItems.SCORCH_BERRY_WINE);
        simple(BamItems.SWEET_BERRY_WINE);
        simple(BamItems.GLOW_BERRY_WINE);

        // Others
        simple(BamItems.BARLEY);
        simple(BamItems.BARLEY_BREAD);
        simple(BamItems.TOASTED_BARLEY);
        simple(BamItems.ORZO);
        simple(BamItems.TOASTED_COCOA_BEANS);
        simple(BamItems.CHOCOLATE_BAR);
        simple(BamItems.CHOCOLATE_MILK);
        simple(BamItems.HOT_COCOA);
    }

    private ItemModelBuilder simple(DeferredItem<?> item) {
        return builder(item, getExistingFile(ResourceLocation.withDefaultNamespace("item/generated")));
    }

    private ItemModelBuilder builder(DeferredItem<?> item) {
        return getBuilder(item.getId().getPath());
    }

    private ItemModelBuilder builder(DeferredItem<?> item, ModelFile parent) {
        String name = item.getId().getPath();
        return builder(item, parent, "item/" + name);
    }

    private ItemModelBuilder builder(DeferredItem<?> item, ModelFile parent, String texture) {
        return getBuilder(item.getId().getPath()).parent(parent).texture("layer0", texture);
    }

    private void blockItemModel(Block block) {
        if (block.asItem() != Items.AIR) {
            var name = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block)).getPath();
            withExistingParent(name, modLoc("block/" + name));
        }
    }
}
