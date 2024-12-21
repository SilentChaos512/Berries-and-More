package net.silentchaos512.berries.setup;

import net.minecraft.world.food.FoodProperties;
import org.jetbrains.annotations.NotNull;

public class BamFoods {
    // Berries
    public static final FoodProperties ACEROLA_BERRIES = builder(2, 0.1f).build();
    public static final FoodProperties SEABERRIES = builder(2, 0.1f).build();
    public static final FoodProperties SNOWBERRIES = builder(3, 0.1f).build();
    public static final FoodProperties VOID_BERRIES = builder(4, 0.1f).build();
    public static final FoodProperties SCORCH_BERRIES = builder(3, 0.1f).build();

    // Juice
    public static final FoodProperties ACEROLA_BERRY_JUICE = builder(4, 0.2f).build();
    public static final FoodProperties SEABERRY_JUICE = builder(4, 0.2f).build();
    public static final FoodProperties SNOWBERRY_JUICE = builder(4, 0.2f).build();
    public static final FoodProperties VOID_BERRY_JUICE = builder(5, 0.2f).build();
    public static final FoodProperties SCORCH_BERRY_JUICE = builder(4, 0.2f).build();
    public static final FoodProperties SWEET_BERRY_JUICE = builder(4, 0.2f).build();
    public static final FoodProperties GLOW_BERRY_JUICE = builder(4, 0.2f).build();

    // Pies
    public static final FoodProperties ACEROLA_BERRY_PIE = builderPie().build();
    public static final FoodProperties SEABERRY_PIE = builderPie().build();
    public static final FoodProperties SNOWBERRY_PIE = builderPie().build();
    public static final FoodProperties VOID_BERRY_PIE = builderPie().build();
    public static final FoodProperties SCORCH_BERRY_PIE = builderPie().build();
    public static final FoodProperties SWEET_BERRY_PIE = builderPie().build();
    public static final FoodProperties GLOW_BERRY_PIE = builderPie().build();

    // Tea
    public static final FoodProperties ACEROLA_BERRY_TEA = builderTea().build();
    public static final FoodProperties SEABERRY_TEA = builderTea().build();
    public static final FoodProperties SNOWBERRY_TEA = builderTea().build();
    public static final FoodProperties VOID_BERRY_TEA = builderTea().build();
    public static final FoodProperties SCORCH_BERRY_TEA = builderTea().build();
    public static final FoodProperties SWEET_BERRY_TEA = builderTea().build();
    public static final FoodProperties GLOW_BERRY_TEA = builderTea().build();

    // Wine
    public static final FoodProperties ACEROLA_BERRY_WINE = builderWine().build();
    public static final FoodProperties SEABERRY_WINE = builderWine().build();
    public static final FoodProperties SNOWBERRY_WINE = builderWine().build();
    public static final FoodProperties VOID_BERRY_WINE = builderWine().build();
    public static final FoodProperties SCORCH_BERRY_WINE = builderWine().build();
    public static final FoodProperties SWEET_BERRY_WINE = builderWine().build();
    public static final FoodProperties GLOW_BERRY_WINE = builderWine().build();

    // Others
    public static final FoodProperties BARLEY_BREAD = builder(5, 0.8f)
            .build();
    public static final FoodProperties ORZO = builder(4, 0.3f)
            .alwaysEdible()
            .build();
    public static final FoodProperties CHOCOLATE_BAR = builder(4, 0.2f)
            .build();
    public static final FoodProperties CHOCOLATE_MILK = builder(6, 0.4f)
            .alwaysEdible()
            .build();
    public static final FoodProperties HOT_COCOA = builder(6, 0.4f)
            .alwaysEdible()
            .build();

    @NotNull
    private static FoodProperties.Builder builder(int nutrition, float saturation) {
        return (new FoodProperties.Builder())
                .nutrition(nutrition)
                .saturationModifier(saturation);
    }

    private static FoodProperties.@NotNull Builder builderPie() {
        return builder(7, 0.5f);
    }

    private static FoodProperties.@NotNull Builder builderTea() {
        return builder(5, 0.3f).alwaysEdible();
    }

    private static FoodProperties.Builder builderWine() {
        return builder(4, (float) 0.15).alwaysEdible();
    }
}
