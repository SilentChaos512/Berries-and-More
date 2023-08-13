package net.silentchaos512.berries.setup;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.berries.BerriesMod;
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

    // Foods
    // Juice
    public static final ItemRegistryObject<Item> ACEROLA_BERRY_JUICE = registerFood("acerola_berry_juice", BamFoods.SWEET_BERRY_JUICE);
    public static final ItemRegistryObject<Item> SEABERRY_JUICE = registerFood("seaberry_juice", BamFoods.SEABERRY_JUICE);
    public static final ItemRegistryObject<Item> SNOWBERRY_JUICE = registerFood("snowberry_juice", BamFoods.SNOWBERRY_JUICE);
    public static final ItemRegistryObject<Item> SWEET_BERRY_JUICE = registerFood("sweet_berry_juice", BamFoods.SWEET_BERRY_JUICE);
    // Pie
    public static final ItemRegistryObject<Item> ACEROLA_BERRY_PIE = registerFood("acerola_berry_pie", BamFoods.SWEET_BERRY_PIE);
    public static final ItemRegistryObject<Item> SEABERRY_PIE = registerFood("seaberry_pie", BamFoods.SEABERRY_PIE);
    public static final ItemRegistryObject<Item> SNOWBERRY_PIE = registerFood("snowberry_pie", BamFoods.SNOWBERRY_PIE);
    public static final ItemRegistryObject<Item> SWEET_BERRY_PIE = registerFood("sweet_berry_pie", BamFoods.SWEET_BERRY_PIE);
    // Tea
    public static final ItemRegistryObject<Item> ACEROLA_BERRY_TEA = registerFood("acerola_berry_tea", BamFoods.ACEROLA_BERRY_TEA);
    public static final ItemRegistryObject<Item> SEABERRY_TEA = registerFood("seaberry_tea", BamFoods.SEABERRY_TEA);
    public static final ItemRegistryObject<Item> SNOWBERRY_TEA = registerFood("snowberry_tea", BamFoods.SNOWBERRY_TEA);
    public static final ItemRegistryObject<Item> SWEET_BERRY_TEA = registerFood("sweet_berry_tea", BamFoods.SWEET_BERRY_TEA);
    // Wine
    public static final ItemRegistryObject<Item> ACEROLA_BERRY_WINE = registerFood("acerola_berry_wine", BamFoods.ACEROLA_BERRY_WINE);
    public static final ItemRegistryObject<Item> SEABERRY_WINE = registerFood("seaberry_wine", BamFoods.SEABERRY_WINE);
    public static final ItemRegistryObject<Item> SNOWBERRY_WINE = registerFood("snowberry_wine", BamFoods.SNOWBERRY_WINE);
    public static final ItemRegistryObject<Item> SWEET_BERRY_WINE = registerFood("sweet_berry_wine", BamFoods.SWEET_BERRY_WINE);

    private static ItemRegistryObject<Item> registerFood(String name, FoodProperties foodProperties) {
        return register(name, () -> new Item(props().food(foodProperties)));
    }

    protected static <T extends Item> ItemRegistryObject<T> register(String name, Supplier<T> item) {
        return new ItemRegistryObject<>(REGISTER.register(name, item));
    }

    private static Item.Properties props() {
        return new Item.Properties();
    }
}
