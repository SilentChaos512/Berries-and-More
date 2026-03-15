package net.silentchaos512.berries.data.client;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.registries.DeferredItem;
import net.silentchaos512.berries.setup.BamItems;

import java.util.function.BiConsumer;

public class ModItemModelProvider extends ItemModelGenerators {
    public ModItemModelProvider(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }

    @Override
    public void run() {
        // Berries
        flatItem(BamItems.ACEROLA_BERRIES);
        flatItem(BamItems.SEABERRIES);
        flatItem(BamItems.SNOWBERRIES);
        flatItem(BamItems.VOID_BERRIES);
        flatItem(BamItems.SCORCH_BERRIES);
        // Seeds
//        flatItem(BamItems.BARLEY_SEEDS);

        // Juice
        flatItem(BamItems.ACEROLA_BERRY_JUICE);
        flatItem(BamItems.SEABERRY_JUICE);
        flatItem(BamItems.SNOWBERRY_JUICE);
        flatItem(BamItems.VOID_BERRY_JUICE);
        flatItem(BamItems.SCORCH_BERRY_JUICE);
        flatItem(BamItems.SWEET_BERRY_JUICE);
        flatItem(BamItems.GLOW_BERRY_JUICE);
        // Pies
        flatItem(BamItems.ACEROLA_BERRY_PIE);
        flatItem(BamItems.SEABERRY_PIE);
        flatItem(BamItems.SNOWBERRY_PIE);
        flatItem(BamItems.VOID_BERRY_PIE);
        flatItem(BamItems.SCORCH_BERRY_PIE);
        flatItem(BamItems.SWEET_BERRY_PIE);
        flatItem(BamItems.GLOW_BERRY_PIE);
        // Tea
        flatItem(BamItems.ACEROLA_BERRY_TEA);
        flatItem(BamItems.SEABERRY_TEA);
        flatItem(BamItems.SNOWBERRY_TEA);
        flatItem(BamItems.VOID_BERRY_TEA);
        flatItem(BamItems.SCORCH_BERRY_TEA);
        flatItem(BamItems.SWEET_BERRY_TEA);
        flatItem(BamItems.GLOW_BERRY_TEA);
        // Wine
        flatItem(BamItems.ACEROLA_BERRY_WINE);
        flatItem(BamItems.SEABERRY_WINE);
        flatItem(BamItems.SNOWBERRY_WINE);
        flatItem(BamItems.VOID_BERRY_WINE);
        flatItem(BamItems.SCORCH_BERRY_WINE);
        flatItem(BamItems.SWEET_BERRY_WINE);
        flatItem(BamItems.GLOW_BERRY_WINE);

        // Others
        flatItem(BamItems.BARLEY);
        flatItem(BamItems.BARLEY_BREAD);
        flatItem(BamItems.TOASTED_BARLEY);
        flatItem(BamItems.ORZO);
        flatItem(BamItems.TOASTED_COCOA_BEANS);
        flatItem(BamItems.CHOCOLATE_BAR);
        flatItem(BamItems.CHOCOLATE_MILK);
        flatItem(BamItems.HOT_COCOA);
    }

    private void flatItem(DeferredItem<?> item) {
        generateFlatItem(item.asItem(), ModelTemplates.FLAT_ITEM);
    }
}
