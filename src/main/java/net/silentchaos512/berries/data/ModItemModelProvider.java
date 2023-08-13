package net.silentchaos512.berries.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamItems;
import net.silentchaos512.lib.block.IBlockProvider;
import net.silentchaos512.lib.util.NameUtils;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), BerriesMod.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(new ResourceLocation("item/generated"));

        // Berries
        builder(BamItems.ACEROLA_BERRIES);
        builder(BamItems.SEABERRIES);
        builder(BamItems.SNOWBERRIES);

        // Juice
        builder(BamItems.ACEROLA_BERRY_JUICE);
        builder(BamItems.SEABERRY_JUICE);
        builder(BamItems.SNOWBERRY_JUICE);
        builder(BamItems.SWEET_BERRY_JUICE);
        // Pies
        builder(BamItems.ACEROLA_BERRY_PIE);
        builder(BamItems.SEABERRY_PIE);
        builder(BamItems.SNOWBERRY_PIE);
        builder(BamItems.SWEET_BERRY_PIE);
        // Tea
        builder(BamItems.ACEROLA_BERRY_TEA);
        builder(BamItems.SEABERRY_TEA);
        builder(BamItems.SNOWBERRY_TEA);
        builder(BamItems.SWEET_BERRY_TEA);
        // Wine
        builder(BamItems.ACEROLA_BERRY_WINE);
        builder(BamItems.SEABERRY_WINE);
        builder(BamItems.SNOWBERRY_WINE);
        builder(BamItems.SWEET_BERRY_WINE);
    }

    private ItemModelBuilder builder(ItemLike item) {
        return getBuilder(NameUtils.fromItem(item).getPath());
    }

    private ItemModelBuilder builder(ItemLike item, ModelFile parent) {
        String name = NameUtils.fromItem(item).getPath();
        return builder(item, parent, "item/" + name);
    }

    private ItemModelBuilder builder(ItemLike item, ModelFile parent, String texture) {
        return getBuilder(NameUtils.fromItem(item).getPath()).parent(parent).texture("layer0", texture);
    }

    private void blockItemModel(IBlockProvider block) {
        String name = NameUtils.fromBlock(block).getPath();
        blockItemModel(block, modLoc("block/" + name));
    }

    private void blockItemModel(IBlockProvider block, ResourceLocation parent) {
        String name = NameUtils.fromBlock(block).getPath();
        withExistingParent(name, parent);
    }
}
