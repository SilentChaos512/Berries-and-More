package net.silentchaos512.berries.setup;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silentchaos512.berries.BerriesMod;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BamItems {
    public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(BerriesMod.MOD_ID);

    // Berries
    public static final DeferredItem<BlockItem> ACEROLA_BERRIES = registerBerries("acerola_berries",
            () -> BamBlocks.ACEROLA_BERRY_BUSH, BamFoods.ACEROLA_BERRIES, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<BlockItem> SEABERRIES = registerBerries("seaberries",
            () -> BamBlocks.SEABERRY_BUSH, BamFoods.SEABERRIES, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<BlockItem> SNOWBERRIES = registerBerries("snowberries",
            () -> BamBlocks.SNOWBERRY_BUSH, BamFoods.SNOWBERRIES, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<BlockItem> VOID_BERRIES = registerBerries("void_berries",
            () -> BamBlocks.VOID_BERRY_BUSH, BamFoods.VOID_BERRIES, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<BlockItem> SCORCH_BERRIES = registerBerries("scorch_berries",
            () -> BamBlocks.SCORCH_BERRY_BUSH, BamFoods.SCORCH_BERRIES, Consumables.DEFAULT_FOOD);

    // Seeds
    public static final DeferredItem<BlockItem> BARLEY_SEEDS = register(
            "barley_seeds",
            properties -> new BlockItem(BamBlocks.BARLEY.get(), properties),
            properties -> properties
                    .component(
                            DataComponents.LORE,
                            new ItemLore(
                                    List.of(
                                            Component.translatable("item.berriesandmore.barley_seeds.desc")
                                    )
                            )
                    )
    );

    // Foods
    // Juice
    public static final DeferredItem<Item> ACEROLA_BERRY_JUICE = registerFood("acerola_berry_juice", BamFoods.ACEROLA_BERRY_JUICE, Consumables.DEFAULT_DRINK);
    public static final DeferredItem<Item> SEABERRY_JUICE = registerFood("seaberry_juice", BamFoods.SEABERRY_JUICE, Consumables.DEFAULT_DRINK);
    public static final DeferredItem<Item> SNOWBERRY_JUICE = registerFood("snowberry_juice", BamFoods.SNOWBERRY_JUICE, Consumables.DEFAULT_DRINK);
    public static final DeferredItem<Item> VOID_BERRY_JUICE = registerFood("void_berry_juice", BamFoods.VOID_BERRY_JUICE, Consumables.DEFAULT_DRINK);
    public static final DeferredItem<Item> SCORCH_BERRY_JUICE = registerFood("scorch_berry_juice", BamFoods.SCORCH_BERRY_JUICE, Consumables.DEFAULT_DRINK);
    public static final DeferredItem<Item> SWEET_BERRY_JUICE = registerFood("sweet_berry_juice", BamFoods.SWEET_BERRY_JUICE, Consumables.DEFAULT_DRINK);
    public static final DeferredItem<Item> GLOW_BERRY_JUICE = registerFood("glow_berry_juice", BamFoods.GLOW_BERRY_JUICE, Consumables.DEFAULT_DRINK);
    // Pie
    public static final DeferredItem<Item> ACEROLA_BERRY_PIE = registerFood("acerola_berry_pie", BamFoods.ACEROLA_BERRY_PIE, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<Item> SEABERRY_PIE = registerFood("seaberry_pie", BamFoods.SEABERRY_PIE, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<Item> SNOWBERRY_PIE = registerFood("snowberry_pie", BamFoods.SNOWBERRY_PIE, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<Item> VOID_BERRY_PIE = registerFood("void_berry_pie", BamFoods.VOID_BERRY_PIE, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<Item> SCORCH_BERRY_PIE = registerFood("scorch_berry_pie", BamFoods.SCORCH_BERRY_PIE, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<Item> SWEET_BERRY_PIE = registerFood("sweet_berry_pie", BamFoods.SWEET_BERRY_PIE, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<Item> GLOW_BERRY_PIE = registerFood("glow_berry_pie", BamFoods.GLOW_BERRY_PIE, Consumables.DEFAULT_FOOD);
    // Tea
    public static final DeferredItem<Item> ACEROLA_BERRY_TEA = registerFood("acerola_berry_tea", BamFoods.ACEROLA_BERRY_TEA, BamConsumables.ACEROLA_BERRY_TEA);
    public static final DeferredItem<Item> SEABERRY_TEA = registerFood("seaberry_tea", BamFoods.SEABERRY_TEA, BamConsumables.SEABERRY_TEA);
    public static final DeferredItem<Item> SNOWBERRY_TEA = registerFood("snowberry_tea", BamFoods.SNOWBERRY_TEA, BamConsumables.SNOWBERRY_TEA);
    public static final DeferredItem<Item> VOID_BERRY_TEA = registerFood("void_berry_tea", BamFoods.VOID_BERRY_TEA, BamConsumables.VOID_BERRY_TEA);
    public static final DeferredItem<Item> SCORCH_BERRY_TEA = registerFood("scorch_berry_tea", BamFoods.SCORCH_BERRY_TEA, BamConsumables.SCORCH_BERRY_TEA);
    public static final DeferredItem<Item> SWEET_BERRY_TEA = registerFood("sweet_berry_tea", BamFoods.SWEET_BERRY_TEA, BamConsumables.SWEET_BERRY_TEA);
    public static final DeferredItem<Item> GLOW_BERRY_TEA = registerFood("glow_berry_tea", BamFoods.GLOW_BERRY_TEA, BamConsumables.GLOW_BERRY_TEA);
    // Wine
    public static final DeferredItem<Item> ACEROLA_BERRY_WINE = registerFood("acerola_berry_wine", BamFoods.ACEROLA_BERRY_WINE, BamConsumables.ACEROLA_BERRY_WINE);
    public static final DeferredItem<Item> SEABERRY_WINE = registerFood("seaberry_wine", BamFoods.SEABERRY_WINE, BamConsumables.SEABERRY_WINE);
    public static final DeferredItem<Item> SNOWBERRY_WINE = registerFood("snowberry_wine", BamFoods.SNOWBERRY_WINE, BamConsumables.SNOWBERRY_WINE);
    public static final DeferredItem<Item> VOID_BERRY_WINE = registerFood("void_berry_wine", BamFoods.VOID_BERRY_WINE, BamConsumables.VOID_BERRY_WINE);
    public static final DeferredItem<Item> SCORCH_BERRY_WINE = registerFood("scorch_berry_wine", BamFoods.SCORCH_BERRY_WINE, BamConsumables.SCORCH_BERRY_WINE);
    public static final DeferredItem<Item> SWEET_BERRY_WINE = registerFood("sweet_berry_wine", BamFoods.SWEET_BERRY_WINE, BamConsumables.SWEET_BERRY_WINE);
    public static final DeferredItem<Item> GLOW_BERRY_WINE = registerFood("glow_berry_wine", BamFoods.GLOW_BERRY_WINE, BamConsumables.GLOW_BERRY_WINE);
    // Others
    public static final DeferredItem<Item> BARLEY = registerSimple("barley");
    public static final DeferredItem<Item> BARLEY_BREAD = registerFood("barley_bread", BamFoods.BARLEY_BREAD, BamConsumables.BARLEY_BREAD);
    public static final DeferredItem<Item> TOASTED_BARLEY = registerSimple("toasted_barley");
    public static final DeferredItem<Item> ORZO = registerFood("orzo", BamFoods.ORZO, BamConsumables.ORZO);
    public static final DeferredItem<Item> TOASTED_COCOA_BEANS = registerSimple("toasted_cocoa_beans");
    public static final DeferredItem<Item> CHOCOLATE_BAR = registerFood("chocolate_bar", BamFoods.CHOCOLATE_BAR, Consumables.DEFAULT_FOOD);
    public static final DeferredItem<Item> CHOCOLATE_MILK = registerFood("chocolate_milk", BamFoods.CHOCOLATE_MILK, BamConsumables.CHOCOLATE_MILK);
    public static final DeferredItem<Item> HOT_COCOA = registerFood("hot_cocoa", BamFoods.HOT_COCOA, BamConsumables.HOT_COCOA);

    private static DeferredItem<BlockItem> registerBerries(String name, Supplier<Holder<Block>> bushBlock, FoodProperties food, Consumable consumable) {
        return register(
                name,
                properties -> new BlockItem(bushBlock.get().value(), properties),
                properties -> properties.food(food, consumable)
        );
    }

    private static DeferredItem<Item> registerFood(String name, FoodProperties foodProperties, Consumable consumable) {
        return register(name, Item::new, properties -> properties.food(foodProperties, consumable));
    }

    private static DeferredItem<Item> registerSimple(String name) {
        return register(name, Item::new, p -> {
        });
    }

    protected static <T extends Item> DeferredItem<T> register(String name, Function<Item.Properties, T> item, Consumer<Item.Properties> properties) {
        return REGISTER.registerItem(name, item, p -> {
            properties.accept(p);
            return p;
        });
    }

    public static void onBuildContentsOfCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            for (DeferredHolder<Item, ? extends Item> item : REGISTER.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
