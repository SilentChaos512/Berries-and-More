package net.silentchaos512.berries.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.silentchaos512.berries.setup.BamItems;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider());
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        juiceRecipe(output, BamItems.ACEROLA_BERRY_JUICE, BamItems.ACEROLA_BERRIES);
        juiceRecipe(output, BamItems.SEABERRY_JUICE, BamItems.SEABERRIES);
        juiceRecipe(output, BamItems.SNOWBERRY_JUICE, BamItems.SNOWBERRIES);
        juiceRecipe(output, BamItems.VOID_BERRY_JUICE, BamItems.VOID_BERRIES);
        juiceRecipe(output, BamItems.SCORCH_BERRY_JUICE, BamItems.SCORCH_BERRIES);
        juiceRecipe(output, BamItems.SWEET_BERRY_JUICE, Items.SWEET_BERRIES);

        pieRecipe(output, BamItems.ACEROLA_BERRY_PIE, BamItems.ACEROLA_BERRIES);
        pieRecipe(output, BamItems.SEABERRY_PIE, BamItems.SEABERRIES);
        pieRecipe(output, BamItems.SNOWBERRY_PIE, BamItems.SNOWBERRIES);
        pieRecipe(output, BamItems.VOID_BERRY_PIE, BamItems.VOID_BERRIES);
        pieRecipe(output, BamItems.SCORCH_BERRY_PIE, BamItems.SCORCH_BERRIES);
        pieRecipe(output, BamItems.SWEET_BERRY_PIE, Items.SWEET_BERRIES);

        teaRecipe(output, BamItems.ACEROLA_BERRY_TEA, BamItems.ACEROLA_BERRIES);
        teaRecipe(output, BamItems.SEABERRY_TEA, BamItems.SEABERRIES);
        teaRecipe(output, BamItems.SNOWBERRY_TEA, BamItems.SNOWBERRIES);
        teaRecipe(output, BamItems.VOID_BERRY_TEA, BamItems.VOID_BERRIES);
        teaRecipe(output, BamItems.SCORCH_BERRY_TEA, BamItems.SCORCH_BERRIES);
        teaRecipe(output, BamItems.SWEET_BERRY_TEA, Items.SWEET_BERRIES);

        wineRecipe(output, BamItems.ACEROLA_BERRY_WINE, BamItems.ACEROLA_BERRIES);
        wineRecipe(output, BamItems.SEABERRY_WINE, BamItems.SEABERRIES);
        wineRecipe(output, BamItems.SNOWBERRY_WINE, BamItems.SNOWBERRIES);
        wineRecipe(output, BamItems.VOID_BERRY_WINE, BamItems.VOID_BERRIES);
        wineRecipe(output, BamItems.SCORCH_BERRY_WINE, BamItems.SCORCH_BERRIES);
        wineRecipe(output, BamItems.SWEET_BERRY_WINE, Items.SWEET_BERRIES);
    }

    private void juiceRecipe(RecipeOutput consumer, ItemLike juice, ItemLike berry) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, juice)
                .requires(berry)
                .requires(Items.SUGAR)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }

    private void pieRecipe(RecipeOutput consumer, ItemLike pie, ItemLike berry) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, pie)
                .pattern("esw")
                .pattern("bbb")
                .define('e', Tags.Items.EGGS)
                .define('s', Items.SUGAR)
                .define('w', Items.WHEAT)
                .define('b', berry)
                .unlockedBy("has_item", has(Items.SWEET_BERRIES))
                .save(consumer);
    }

    private void teaRecipe(RecipeOutput consumer, ItemLike tea, ItemLike berry) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, tea)
                .requires(berry)
                .requires(berry)
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }

    private void wineRecipe(RecipeOutput consumer, ItemLike wine, ItemLike berry) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, wine)
                .requires(berry)
                .requires(berry)
                .requires(Items.RED_MUSHROOM)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }
}
