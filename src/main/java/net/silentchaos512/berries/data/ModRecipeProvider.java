package net.silentchaos512.berries.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.berries.setup.BamItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        juiceRecipe(output, BamItems.ACEROLA_BERRY_JUICE, BamItems.ACEROLA_BERRIES);
        juiceRecipe(output, BamItems.SEABERRY_JUICE, BamItems.SEABERRIES);
        juiceRecipe(output, BamItems.SNOWBERRY_JUICE, BamItems.SNOWBERRIES);
        juiceRecipe(output, BamItems.VOID_BERRY_JUICE, BamItems.VOID_BERRIES);
        juiceRecipe(output, BamItems.SCORCH_BERRY_JUICE, BamItems.SCORCH_BERRIES);
        juiceRecipe(output, BamItems.SWEET_BERRY_JUICE, Items.SWEET_BERRIES);
        juiceRecipe(output, BamItems.GLOW_BERRY_JUICE, Items.GLOW_BERRIES);

        pieRecipe(output, BamItems.ACEROLA_BERRY_PIE, BamItems.ACEROLA_BERRIES);
        pieRecipe(output, BamItems.SEABERRY_PIE, BamItems.SEABERRIES);
        pieRecipe(output, BamItems.SNOWBERRY_PIE, BamItems.SNOWBERRIES);
        pieRecipe(output, BamItems.VOID_BERRY_PIE, BamItems.VOID_BERRIES);
        pieRecipe(output, BamItems.SCORCH_BERRY_PIE, BamItems.SCORCH_BERRIES);
        pieRecipe(output, BamItems.SWEET_BERRY_PIE, Items.SWEET_BERRIES);
        pieRecipe(output, BamItems.GLOW_BERRY_PIE, Items.GLOW_BERRIES);

        teaRecipe(output, BamItems.ACEROLA_BERRY_TEA, BamItems.ACEROLA_BERRIES);
        teaRecipe(output, BamItems.SEABERRY_TEA, BamItems.SEABERRIES);
        teaRecipe(output, BamItems.SNOWBERRY_TEA, BamItems.SNOWBERRIES);
        teaRecipe(output, BamItems.VOID_BERRY_TEA, BamItems.VOID_BERRIES);
        teaRecipe(output, BamItems.SCORCH_BERRY_TEA, BamItems.SCORCH_BERRIES);
        teaRecipe(output, BamItems.SWEET_BERRY_TEA, Items.SWEET_BERRIES);
        teaRecipe(output, BamItems.GLOW_BERRY_TEA, Items.GLOW_BERRIES);

        wineRecipe(output, BamItems.ACEROLA_BERRY_WINE, BamItems.ACEROLA_BERRIES);
        wineRecipe(output, BamItems.SEABERRY_WINE, BamItems.SEABERRIES);
        wineRecipe(output, BamItems.SNOWBERRY_WINE, BamItems.SNOWBERRIES);
        wineRecipe(output, BamItems.VOID_BERRY_WINE, BamItems.VOID_BERRIES);
        wineRecipe(output, BamItems.SCORCH_BERRY_WINE, BamItems.SCORCH_BERRIES);
        wineRecipe(output, BamItems.SWEET_BERRY_WINE, Items.SWEET_BERRIES);
        wineRecipe(output, BamItems.GLOW_BERRY_WINE, Items.GLOW_BERRIES);

        // Barley Foods
        shaped(RecipeCategory.FOOD, BamItems.BARLEY_BREAD)
                .pattern("###")
                .define('#', BamItems.BARLEY)
                .unlockedBy("has_item", has(BamItems.BARLEY))
                .save(output);

        cookingRecipes(output, BamItems.TOASTED_BARLEY, BamItems.BARLEY);

        shapeless(RecipeCategory.FOOD, BamItems.ORZO)
                .requires(BamItems.TOASTED_BARLEY)
                .requires(Items.SUGAR)
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_item", has(BamItems.TOASTED_BARLEY))
                .save(output);

        // Barley Blocks
        shaped(RecipeCategory.FOOD, BamBlocks.BARLEY_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', BamItems.BARLEY)
                .unlockedBy("has_item", has(BamItems.BARLEY))
                .save(output);
        shapeless(RecipeCategory.FOOD, BamItems.BARLEY, 9)
                .requires(BamBlocks.BARLEY_BLOCK)
                .unlockedBy("has_item", has(BamBlocks.BARLEY_BLOCK))
                .save(output);

        // Chocolate Foods
        cookingRecipes(output, BamItems.TOASTED_COCOA_BEANS, Items.COCOA_BEANS);
        shaped(RecipeCategory.FOOD, BamItems.CHOCOLATE_BAR)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', BamItems.TOASTED_COCOA_BEANS)
                .unlockedBy("has_item", has(BamItems.TOASTED_COCOA_BEANS))
                .save(output);
        shapeless(RecipeCategory.FOOD, BamItems.CHOCOLATE_MILK)
                .requires(BamItems.CHOCOLATE_BAR)
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_item", has(BamItems.CHOCOLATE_BAR))
                .save(output);
        shapeless(RecipeCategory.FOOD, BamItems.HOT_COCOA)
                .requires(BamItems.CHOCOLATE_BAR)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_item", has(BamItems.CHOCOLATE_BAR))
                .save(output);
    }

    private void juiceRecipe(RecipeOutput consumer, ItemLike juice, ItemLike berry) {
        shapeless(RecipeCategory.FOOD, juice)
                .requires(berry)
                .requires(Items.SUGAR)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }

    private void pieRecipe(RecipeOutput consumer, ItemLike pie, ItemLike berry) {
        shaped(RecipeCategory.FOOD, pie)
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
        shapeless(RecipeCategory.FOOD, tea)
                .requires(berry)
                .requires(berry)
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }

    private void wineRecipe(RecipeOutput consumer, ItemLike wine, ItemLike berry) {
        shapeless(RecipeCategory.FOOD, wine)
                .requires(berry)
                .requires(berry)
                .requires(Items.RED_MUSHROOM)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_item", has(berry))
                .save(consumer);
    }

    private void cookingRecipes(RecipeOutput recipeOutput, ItemLike result, ItemLike input) {
        var name = BuiltInRegistries.ITEM.getKey(result.asItem()).getPath();
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.FOOD, new ItemStack(result), 0.2f, 600)
                .unlockedBy("has_item", has(input))
                .save(recipeOutput, modKey(name + "_campfire_cooking"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, new ItemStack(result), 0.2f, 100)
                .unlockedBy("has_item", has(input))
                .save(recipeOutput, modKey(name + "_smoking"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, new ItemStack(result), 0.2f, 200)
                .unlockedBy("has_item", has(input))
                .save(recipeOutput, modKey(name));
    }

    private ResourceKey<Recipe<?>> modKey(String path) {
        return ResourceKey.create(Registries.RECIPE, BerriesMod.getId(path));
    }

    public static class Runner extends RecipeProvider.Runner {
        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Berries and More Recipes";
        }
    }
}
