package net.silentchaos512.berries.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.berries.setup.BamItems;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen) {
        super(gen.getPackOutput(), BerriesMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(BamBlocks.ACEROLA_BERRY_BUSH, "Acerola Berry Bush");
        addBlock(BamBlocks.SCORCH_BERRY_BUSH, "Scorch Berry Bush");
        addBlock(BamBlocks.SEABERRY_BUSH, "Seaberry Bush");
        addBlock(BamBlocks.SNOWBERRY_BUSH, "Snowberry Bush");
        addBlock(BamBlocks.VOID_BERRY_BUSH, "Void Berry Bush");

        addItem(BamItems.ACEROLA_BERRIES, "Acerola Berries");
        addItem(BamItems.SCORCH_BERRIES, "Scorch Berries");
        addItem(BamItems.SEABERRIES, "Seaberries");
        addItem(BamItems.SNOWBERRIES, "Snowberries");
        addItem(BamItems.VOID_BERRIES, "Void Berries");

        addItem(BamItems.ACEROLA_BERRY_JUICE, "Acerola Berry Juice");
        addItem(BamItems.SCORCH_BERRY_JUICE, "Scorch Berry Juice");
        addItem(BamItems.SEABERRY_JUICE, "Seaberry Juice");
        addItem(BamItems.SNOWBERRY_JUICE, "Snowberry Juice");
        addItem(BamItems.VOID_BERRY_JUICE, "Void Berry Juice");
        addItem(BamItems.SWEET_BERRY_JUICE, "Sweet Berry Juice");

        addItem(BamItems.ACEROLA_BERRY_PIE, "Acerola Berry Pie");
        addItem(BamItems.SCORCH_BERRY_PIE, "Scorch Berry Pie");
        addItem(BamItems.SEABERRY_PIE, "Seaberry Pie");
        addItem(BamItems.SNOWBERRY_PIE, "Snowberry Pie");
        addItem(BamItems.VOID_BERRY_PIE, "Void Berry Pie");
        addItem(BamItems.SWEET_BERRY_PIE, "Sweet Berry Pie");

        addItem(BamItems.ACEROLA_BERRY_TEA, "Acerola Berry Tea");
        addItem(BamItems.SCORCH_BERRY_TEA, "Scorch Berry Tea");
        addItem(BamItems.SEABERRY_TEA, "Seaberry Tea");
        addItem(BamItems.SNOWBERRY_TEA, "Snowberry Tea");
        addItem(BamItems.VOID_BERRY_TEA, "Void Berry Tea");
        addItem(BamItems.SWEET_BERRY_TEA, "Sweet Berry Tea");

        addItem(BamItems.ACEROLA_BERRY_WINE, "Acerola Berry Wine");
        addItem(BamItems.SCORCH_BERRY_WINE, "Scorch Berry Wine");
        addItem(BamItems.SEABERRY_WINE, "Seaberry Wine");
        addItem(BamItems.SNOWBERRY_WINE, "Snowberry Wine");
        addItem(BamItems.VOID_BERRY_WINE, "Void Berry Wine");
        addItem(BamItems.SWEET_BERRY_WINE, "Sweet Berry Wine");
    }
}
