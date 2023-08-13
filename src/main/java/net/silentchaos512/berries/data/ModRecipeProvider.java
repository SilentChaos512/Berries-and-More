package net.silentchaos512.berries.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamItems;
import net.silentchaos512.lib.data.recipe.LibRecipeProvider;

import java.util.function.Consumer;

public class ModRecipeProvider extends LibRecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn, BerriesMod.MOD_ID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        juiceRecipe(consumer, BamItems.ACEROLA_BERRY_JUICE, BamItems.ACEROLA_BERRIES);
        juiceRecipe(consumer, BamItems.SEABERRY_JUICE, BamItems.SEABERRIES);
        juiceRecipe(consumer, BamItems.SNOWBERRY_JUICE, BamItems.SNOWBERRIES);
        juiceRecipe(consumer, BamItems.SWEET_BERRY_JUICE, Items.SWEET_BERRIES);
        pieRecipe(consumer, BamItems.ACEROLA_BERRY_PIE, BamItems.ACEROLA_BERRIES);
        pieRecipe(consumer, BamItems.SEABERRY_PIE, BamItems.SEABERRIES);
        pieRecipe(consumer, BamItems.SNOWBERRY_PIE, BamItems.SNOWBERRIES);
        pieRecipe(consumer, BamItems.SWEET_BERRY_PIE, Items.SWEET_BERRIES);
        teaRecipe(consumer, BamItems.ACEROLA_BERRY_TEA, BamItems.ACEROLA_BERRIES);
        teaRecipe(consumer, BamItems.SEABERRY_TEA, BamItems.SEABERRIES);
        teaRecipe(consumer, BamItems.SNOWBERRY_TEA, BamItems.SNOWBERRIES);
        teaRecipe(consumer, BamItems.SWEET_BERRY_TEA, Items.SWEET_BERRIES);
        wineRecipe(consumer, BamItems.ACEROLA_BERRY_WINE, BamItems.ACEROLA_BERRIES);
        wineRecipe(consumer, BamItems.SEABERRY_WINE, BamItems.SEABERRIES);
        wineRecipe(consumer, BamItems.SNOWBERRY_WINE, BamItems.SNOWBERRIES);
        wineRecipe(consumer, BamItems.SWEET_BERRY_WINE, Items.SWEET_BERRIES);
    }

    private void juiceRecipe(Consumer<FinishedRecipe> consumer, ItemLike juice, ItemLike berry) {
        shapelessBuilder(RecipeCategory.FOOD, juice)
                .requires(berry)
                .requires(Items.SUGAR)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }

    private void pieRecipe(Consumer<FinishedRecipe> consumer, ItemLike pie, ItemLike berry) {
        shapedBuilder(RecipeCategory.FOOD, pie)
                .pattern("esw")
                .pattern("bbb")
                .define('e', Tags.Items.EGGS)
                .define('s', Items.SUGAR)
                .define('w', Items.WHEAT)
                .define('b', berry)
                .unlockedBy("has_item", has(Items.SWEET_BERRIES))
                .save(consumer);
    }

    private void teaRecipe(Consumer<FinishedRecipe> consumer, ItemLike tea, ItemLike berry) {
        shapelessBuilder(RecipeCategory.FOOD, tea)
                .requires(berry)
                .requires(berry)
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }

    private void wineRecipe(Consumer<FinishedRecipe> consumer, ItemLike wine, ItemLike berry) {
        shapelessBuilder(RecipeCategory.FOOD, wine)
                .requires(berry)
                .requires(berry)
                .requires(Items.RED_MUSHROOM)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }
}
