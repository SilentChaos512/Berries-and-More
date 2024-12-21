package net.silentchaos512.berries.setup;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.ItemLore;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.item.BamFoodItem;

import java.util.List;
import java.util.function.Supplier;

public class BamItems {
    public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(BerriesMod.MOD_ID);

    // Berries
    public static final DeferredItem<ItemNameBlockItem> ACEROLA_BERRIES = register("acerola_berries", () ->
            new ItemNameBlockItem(BamBlocks.ACEROLA_BERRY_BUSH.get(), props().food(BamFoods.ACEROLA_BERRIES))
    );
    public static final DeferredItem<ItemNameBlockItem> SEABERRIES = register("seaberries", () ->
            new ItemNameBlockItem(BamBlocks.SEABERRY_BUSH.get(), props().food(BamFoods.SEABERRIES))
    );
    public static final DeferredItem<ItemNameBlockItem> SNOWBERRIES = register("snowberries", () ->
            new ItemNameBlockItem(BamBlocks.SNOWBERRY_BUSH.get(), props().food(BamFoods.SNOWBERRIES))
    );
    public static final DeferredItem<ItemNameBlockItem> VOID_BERRIES = register("void_berries", () ->
            new ItemNameBlockItem(BamBlocks.VOID_BERRY_BUSH.get(), props().food(BamFoods.VOID_BERRIES))
    );
    public static final DeferredItem<ItemNameBlockItem> SCORCH_BERRIES = register("scorch_berries", () ->
            new ItemNameBlockItem(BamBlocks.SCORCH_BERRY_BUSH.get(), props().food(BamFoods.SCORCH_BERRIES))
    );

    // Seeds
    public static final DeferredItem<ItemNameBlockItem> BARLEY_SEEDS = register("barley_seeds", () ->
            new ItemNameBlockItem(BamBlocks.BARLEY.get(), props()
                    .component(
                            DataComponents.LORE,
                            new ItemLore(
                                    List.of(
                                            Component.translatable("item.berriesandmore.barley_seeds.desc")
                                    )
                            )
                    )
            )
    );

    // Foods
    // Juice
    public static final DeferredItem<Item> ACEROLA_BERRY_JUICE = registerDrink("acerola_berry_juice", BamFoods.ACEROLA_BERRY_JUICE);
    public static final DeferredItem<Item> SEABERRY_JUICE = registerDrink("seaberry_juice", BamFoods.SEABERRY_JUICE);
    public static final DeferredItem<Item> SNOWBERRY_JUICE = registerDrink("snowberry_juice", BamFoods.SNOWBERRY_JUICE);
    public static final DeferredItem<Item> VOID_BERRY_JUICE = registerDrink("void_berry_juice", BamFoods.VOID_BERRY_JUICE);
    public static final DeferredItem<Item> SCORCH_BERRY_JUICE = registerDrink("scorch_berry_juice", BamFoods.SCORCH_BERRY_JUICE);
    public static final DeferredItem<Item> SWEET_BERRY_JUICE = registerDrink("sweet_berry_juice", BamFoods.SWEET_BERRY_JUICE);
    public static final DeferredItem<Item> GLOW_BERRY_JUICE = registerDrink("glow_berry_juice", BamFoods.GLOW_BERRY_JUICE);
    // Pie
    public static final DeferredItem<Item> ACEROLA_BERRY_PIE = registerFood("acerola_berry_pie", BamFoods.ACEROLA_BERRY_PIE);
    public static final DeferredItem<Item> SEABERRY_PIE = registerFood("seaberry_pie", BamFoods.SEABERRY_PIE);
    public static final DeferredItem<Item> SNOWBERRY_PIE = registerFood("snowberry_pie", BamFoods.SNOWBERRY_PIE);
    public static final DeferredItem<Item> VOID_BERRY_PIE = registerFood("void_berry_pie", BamFoods.VOID_BERRY_PIE);
    public static final DeferredItem<Item> SCORCH_BERRY_PIE = registerFood("scorch_berry_pie", BamFoods.SCORCH_BERRY_PIE);
    public static final DeferredItem<Item> SWEET_BERRY_PIE = registerFood("sweet_berry_pie", BamFoods.SWEET_BERRY_PIE);
    public static final DeferredItem<Item> GLOW_BERRY_PIE = registerFood("glow_berry_pie", BamFoods.GLOW_BERRY_PIE);
    // Tea
    public static final DeferredItem<Item> ACEROLA_BERRY_TEA = registerDrink("acerola_berry_tea", BamFoods.ACEROLA_BERRY_TEA);
    public static final DeferredItem<Item> SEABERRY_TEA = registerDrink("seaberry_tea", BamFoods.SEABERRY_TEA);
    public static final DeferredItem<Item> SNOWBERRY_TEA = registerDrink("snowberry_tea", BamFoods.SNOWBERRY_TEA);
    public static final DeferredItem<Item> VOID_BERRY_TEA = registerDrink("void_berry_tea", BamFoods.VOID_BERRY_TEA);
    public static final DeferredItem<Item> SCORCH_BERRY_TEA = registerDrink("scorch_berry_tea", BamFoods.SCORCH_BERRY_TEA);
    public static final DeferredItem<Item> SWEET_BERRY_TEA = registerDrink("sweet_berry_tea", BamFoods.SWEET_BERRY_TEA);
    public static final DeferredItem<Item> GLOW_BERRY_TEA = registerDrink("glow_berry_tea", BamFoods.GLOW_BERRY_TEA);
    // Wine
    public static final DeferredItem<Item> ACEROLA_BERRY_WINE = registerDrink("acerola_berry_wine", BamFoods.ACEROLA_BERRY_WINE);
    public static final DeferredItem<Item> SEABERRY_WINE = registerDrink("seaberry_wine", BamFoods.SEABERRY_WINE);
    public static final DeferredItem<Item> SNOWBERRY_WINE = registerDrink("snowberry_wine", BamFoods.SNOWBERRY_WINE);
    public static final DeferredItem<Item> VOID_BERRY_WINE = registerDrink("void_berry_wine", BamFoods.VOID_BERRY_WINE);
    public static final DeferredItem<Item> SCORCH_BERRY_WINE = registerDrink("scorch_berry_wine", BamFoods.SCORCH_BERRY_WINE);
    public static final DeferredItem<Item> SWEET_BERRY_WINE = registerFood("sweet_berry_wine", BamFoods.SWEET_BERRY_WINE);
    public static final DeferredItem<Item> GLOW_BERRY_WINE = registerFood("glow_berry_wine", BamFoods.GLOW_BERRY_WINE);
    // Others
    public static final DeferredItem<Item> BARLEY = register("barley", () -> new Item(props()));
    public static final DeferredItem<Item> BARLEY_BREAD = registerFood("barley_bread", BamFoods.BARLEY_BREAD);
    public static final DeferredItem<Item> TOASTED_BARLEY = register("toasted_barley", () -> new Item(props()));
    public static final DeferredItem<Item> ORZO = registerDrink("orzo", BamFoods.ORZO);
    public static final DeferredItem<Item> TOASTED_COCOA_BEANS = register("toasted_cocoa_beans", () -> new Item(props()));
    public static final DeferredItem<Item> CHOCOLATE_BAR = registerFood("chocolate_bar", BamFoods.CHOCOLATE_BAR);
    public static final DeferredItem<Item> CHOCOLATE_MILK = registerDrink("chocolate_milk", BamFoods.CHOCOLATE_MILK);
    public static final DeferredItem<Item> HOT_COCOA = registerDrink("hot_cocoa", BamFoods.HOT_COCOA);

    private static DeferredItem<Item> registerFood(String name, FoodProperties foodProperties) {
        return register(name, () -> new BamFoodItem(UseAnim.EAT, props().food(foodProperties)));
    }

    private static DeferredItem<Item> registerDrink(String name, FoodProperties foodProperties) {
        return register(name, () -> new BamFoodItem(UseAnim.DRINK, props().food(foodProperties)));
    }

    protected static <T extends Item> DeferredItem<T> register(String name, Supplier<T> item) {
        return REGISTER.register(name, item);
    }

    private static Item.Properties props() {
        return new Item.Properties();
    }

    public static void onBuildContentsOfCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            for (DeferredHolder<Item, ? extends Item> item : REGISTER.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
