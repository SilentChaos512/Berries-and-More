package net.silentchaos512.berries.setup;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import org.jetbrains.annotations.NotNull;

public class BamFoods {
    // Berries
    public static final FoodProperties ACEROLA_BERRIES = builder(2, 0.1f).build();
    public static final FoodProperties SEABERRIES = builder(2, 0.1f).build();
    public static final FoodProperties SNOWBERRIES = builder(3, 0.1f).build();

    // Juice
    public static final FoodProperties ACEROLA_BERRY_JUICE = builder(4, 0.2f).build();
    public static final FoodProperties SEABERRY_JUICE = builder(4, 0.2f).build();
    public static final FoodProperties SNOWBERRY_JUICE = builder(4, 0.2f).build();
    public static final FoodProperties SWEET_BERRY_JUICE = builder(4, 0.2f).build();

    // Pies
    public static final FoodProperties ACEROLA_BERRY_PIE = builder(6, 0.4f).build();
    public static final FoodProperties SEABERRY_PIE = builder(6, 0.4f).build();
    public static final FoodProperties SNOWBERRY_PIE = builder(6, 0.4f).build();
    public static final FoodProperties SWEET_BERRY_PIE = builder(6, 0.4f).build();

    // Tea
    public static final FoodProperties ACEROLA_BERRY_TEA = builder(5, 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 0), 1f)
            .build();
    public static final FoodProperties SEABERRY_TEA = builder(5, 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0), 1f)
            .build();
    public static final FoodProperties SNOWBERRY_TEA = builder(5, 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1f)
            .build();
    public static final FoodProperties SWEET_BERRY_TEA = builder(5, 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0), 1f)
            .build();

    // Wine
    public static final FoodProperties ACEROLA_BERRY_WINE = builderWine(4, 0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 1), 1f)
            .build();
    public static final FoodProperties SEABERRY_WINE = builderWine(4, 0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 600, 1), 1f)
            .build();
    public static final FoodProperties SNOWBERRY_WINE = builderWine(4, 0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 1f)
            .build();
    public static final FoodProperties SWEET_BERRY_WINE = builderWine(4, 0.15f)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 600, 0), 1f)
            .build();

    @NotNull
    private static FoodProperties.Builder builder(int nutrition, float saturation) {
        return (new FoodProperties.Builder())
                .nutrition(nutrition)
                .saturationMod(saturation);
    }

    private static FoodProperties.Builder builderWine(int nutrition, float saturation) {
        return builder(nutrition, saturation)
                .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 300), 0.2f)
                .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600), 0.33f)
                .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 1200), 0.33f);
    }
}
