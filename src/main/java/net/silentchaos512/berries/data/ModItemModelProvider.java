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
        simple(BamItems.ACEROLA_BERRIES);
        simple(BamItems.SEABERRIES);
        simple(BamItems.SNOWBERRIES);
        simple(BamItems.VOID_BERRIES);
        simple(BamItems.SCORCH_BERRIES);

        // Juice
        simple(BamItems.ACEROLA_BERRY_JUICE);
        simple(BamItems.SEABERRY_JUICE);
        simple(BamItems.SNOWBERRY_JUICE);
        simple(BamItems.VOID_BERRY_JUICE);
        simple(BamItems.SCORCH_BERRY_JUICE);
        simple(BamItems.SWEET_BERRY_JUICE);
        // Pies
        simple(BamItems.ACEROLA_BERRY_PIE);
        simple(BamItems.SEABERRY_PIE);
        simple(BamItems.SNOWBERRY_PIE);
        simple(BamItems.VOID_BERRY_PIE);
        simple(BamItems.SCORCH_BERRY_PIE);
        simple(BamItems.SWEET_BERRY_PIE);
        // Tea
        simple(BamItems.ACEROLA_BERRY_TEA);
        simple(BamItems.SEABERRY_TEA);
        simple(BamItems.SNOWBERRY_TEA);
        simple(BamItems.VOID_BERRY_TEA);
        simple(BamItems.SCORCH_BERRY_TEA);
        simple(BamItems.SWEET_BERRY_TEA);
        // Wine
        simple(BamItems.ACEROLA_BERRY_WINE);
        simple(BamItems.SEABERRY_WINE);
        simple(BamItems.SNOWBERRY_WINE);
        simple(BamItems.VOID_BERRY_WINE);
        simple(BamItems.SCORCH_BERRY_WINE);
        simple(BamItems.SWEET_BERRY_WINE);
    }

    private ItemModelBuilder simple(ItemLike item) {
        return builder(item, getExistingFile(new ResourceLocation("item/generated")));
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
