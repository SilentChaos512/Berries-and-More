package net.silentchaos512.berries.setup;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.item.BerryFoodItem;
import net.silentchaos512.lib.registry.ItemRegistryObject;

import java.util.function.Supplier;

public class BamItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, BerriesMod.MOD_ID);

    // Berries
    public static final ItemRegistryObject<ItemNameBlockItem> ACEROLA_BERRIES = register("acerola_berries", () ->
            new ItemNameBlockItem(BamBlocks.ACEROLA_BERRY_BUSH.get(), props().food(BamFoods.ACEROLA_BERRIES)));
    public static final ItemRegistryObject<ItemNameBlockItem> SEABERRIES = register("seaberries", () ->
            new ItemNameBlockItem(BamBlocks.SEABERRY_BUSH.get(), props().food(BamFoods.SEABERRIES)));
    public static final ItemRegistryObject<ItemNameBlockItem> SNOWBERRIES = register("snowberries", () ->
            new ItemNameBlockItem(BamBlocks.SNOWBERRY_BUSH.get(), props().food(BamFoods.SNOWBERRIES)));
    public static final ItemRegistryObject<ItemNameBlockItem> VOID_BERRIES = register("void_berries", () ->
            new ItemNameBlockItem(BamBlocks.VOID_BERRY_BUSH.get(), props().food(BamFoods.VOID_BERRIES)));
    public static final ItemRegistryObject<ItemNameBlockItem> SCORCH_BERRIES = register("scorch_berries", () ->
            new ItemNameBlockItem(BamBlocks.SCORCH_BERRY_BUSH.get(), props().food(BamFoods.SCORCH_BERRIES)));

    // Foods
    // Juice
    public static final ItemRegistryObject<Item> ACEROLA_BERRY_JUICE = registerDrink("acerola_berry_juice", BamFoods.ACEROLA_BERRY_JUICE);
    public static final ItemRegistryObject<Item> SEABERRY_JUICE = registerDrink("seaberry_juice", BamFoods.SEABERRY_JUICE);
    public static final ItemRegistryObject<Item> SNOWBERRY_JUICE = registerDrink("snowberry_juice", BamFoods.SNOWBERRY_JUICE);
    public static final ItemRegistryObject<Item> VOID_BERRY_JUICE = registerDrink("void_berry_juice", BamFoods.VOID_BERRY_JUICE);
    public static final ItemRegistryObject<Item> SCORCH_BERRY_JUICE = registerDrink("scorch_berry_juice", BamFoods.SCORCH_BERRY_JUICE);
    public static final ItemRegistryObject<Item> SWEET_BERRY_JUICE = registerDrink("sweet_berry_juice", BamFoods.SWEET_BERRY_JUICE);
    // Pie
    public static final ItemRegistryObject<Item> ACEROLA_BERRY_PIE = registerFood("acerola_berry_pie", BamFoods.ACEROLA_BERRY_PIE);
    public static final ItemRegistryObject<Item> SEABERRY_PIE = registerFood("seaberry_pie", BamFoods.SEABERRY_PIE);
    public static final ItemRegistryObject<Item> SNOWBERRY_PIE = registerFood("snowberry_pie", BamFoods.SNOWBERRY_PIE);
    public static final ItemRegistryObject<Item> VOID_BERRY_PIE = registerFood("void_berry_pie", BamFoods.VOID_BERRY_PIE);
    public static final ItemRegistryObject<Item> SCORCH_BERRY_PIE = registerFood("scorch_berry_pie", BamFoods.SCORCH_BERRY_PIE);
    public static final ItemRegistryObject<Item> SWEET_BERRY_PIE = registerFood("sweet_berry_pie", BamFoods.SWEET_BERRY_PIE);
    // Tea
    public static final ItemRegistryObject<Item> ACEROLA_BERRY_TEA = registerDrink("acerola_berry_tea", BamFoods.ACEROLA_BERRY_TEA);
    public static final ItemRegistryObject<Item> SEABERRY_TEA = registerDrink("seaberry_tea", BamFoods.SEABERRY_TEA);
    public static final ItemRegistryObject<Item> SNOWBERRY_TEA = registerDrink("snowberry_tea", BamFoods.SNOWBERRY_TEA);
    public static final ItemRegistryObject<Item> VOID_BERRY_TEA = registerDrink("void_berry_tea", BamFoods.VOID_BERRY_TEA);
    public static final ItemRegistryObject<Item> SCORCH_BERRY_TEA = registerDrink("scorch_berry_tea", BamFoods.SCORCH_BERRY_TEA);
    public static final ItemRegistryObject<Item> SWEET_BERRY_TEA = registerDrink("sweet_berry_tea", BamFoods.SWEET_BERRY_TEA);
    // Wine
    public static final ItemRegistryObject<Item> ACEROLA_BERRY_WINE = registerDrink("acerola_berry_wine", BamFoods.ACEROLA_BERRY_WINE);
    public static final ItemRegistryObject<Item> SEABERRY_WINE = registerDrink("seaberry_wine", BamFoods.SEABERRY_WINE);
    public static final ItemRegistryObject<Item> SNOWBERRY_WINE = registerDrink("snowberry_wine", BamFoods.SNOWBERRY_WINE);
    public static final ItemRegistryObject<Item> VOID_BERRY_WINE = registerDrink("void_berry_wine", BamFoods.VOID_BERRY_WINE);
    public static final ItemRegistryObject<Item> SCORCH_BERRY_WINE = registerDrink("scorch_berry_wine", BamFoods.SCORCH_BERRY_WINE);
    public static final ItemRegistryObject<Item> SWEET_BERRY_WINE = registerFood("sweet_berry_wine", BamFoods.SWEET_BERRY_WINE);

    private static ItemRegistryObject<Item> registerFood(String name, FoodProperties foodProperties) {
        return register(name, () -> new BerryFoodItem(UseAnim.EAT, props().food(foodProperties)));
    }

    private static ItemRegistryObject<Item> registerDrink(String name, FoodProperties foodProperties) {
        return register(name, () -> new BerryFoodItem(UseAnim.DRINK, props().food(foodProperties)));
    }

    protected static <T extends Item> ItemRegistryObject<T> register(String name, Supplier<T> item) {
        return new ItemRegistryObject<>(REGISTER.register(name, item));
    }

    private static Item.Properties props() {
        return new Item.Properties();
    }

    public static void onBuildContentsOfCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            for (RegistryObject<Item> item : REGISTER.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
