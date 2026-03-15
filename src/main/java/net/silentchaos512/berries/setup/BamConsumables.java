package net.silentchaos512.berries.setup;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.RemoveStatusEffectsConsumeEffect;

public class BamConsumables {
    public static final Consumable ACEROLA_BERRY_TEA = singleEffectDrink(MobEffects.SPEED, 3600).build();
    public static final Consumable SEABERRY_TEA = singleEffectDrink(MobEffects.STRENGTH, 2400).build();
    public static final Consumable SNOWBERRY_TEA = singleEffectDrink(MobEffects.ABSORPTION, 1200).build();
    public static final Consumable VOID_BERRY_TEA = singleEffectDrink(MobEffects.SLOW_FALLING, 1800).build();
    public static final Consumable SCORCH_BERRY_TEA = singleEffectDrink(MobEffects.FIRE_RESISTANCE, 1800).build();
    public static final Consumable SWEET_BERRY_TEA = singleEffectDrink(MobEffects.HASTE, 3600).build();
    public static final Consumable GLOW_BERRY_TEA = singleEffectDrink(MobEffects.NIGHT_VISION, 3600).build();

    public static final Consumable ACEROLA_BERRY_WINE = wine(MobEffects.SLOWNESS, 600, 1).build();
    public static final Consumable SEABERRY_WINE = wine(MobEffects.JUMP_BOOST, 600, 1).build();
    public static final Consumable SNOWBERRY_WINE = wine(MobEffects.HUNGER, 600, 0).build();
    public static final Consumable VOID_BERRY_WINE = wine(MobEffects.LEVITATION, 300, 0).build();
    public static final Consumable SCORCH_BERRY_WINE = wine(MobEffects.MINING_FATIGUE, 600, 1).build();
    public static final Consumable SWEET_BERRY_WINE = wine(MobEffects.INVISIBILITY, 600, 0).build();
    public static final Consumable GLOW_BERRY_WINE = wine(MobEffects.DARKNESS, 600, 0).build();

    public static final Consumable BARLEY_BREAD = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RESISTANCE, 200), 1f))
            .build();
    public static final Consumable ORZO = singleEffectDrink(MobEffects.RESISTANCE, 1200).build();
    public static final Consumable CHOCOLATE_MILK = singleEffectDrink(MobEffects.RESISTANCE, 300)
            .onConsume(new RemoveStatusEffectsConsumeEffect(MobEffects.POISON))
            .build();
    public static final Consumable HOT_COCOA = singleEffectDrink(MobEffects.RESISTANCE, 600).build();

    private static Consumable.Builder singleEffectDrink(Holder<MobEffect> effect, int duration) {
        return Consumables.defaultDrink()
                .onConsume(
                        new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(effect, duration), 1f)
                );
    }

    private static Consumable.Builder wine(Holder<MobEffect> specialEffect, int duration, int amplifier) {
        return Consumables.defaultDrink()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(specialEffect, duration, amplifier), 1f))
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300), 0.2f))
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 600), 0.33f))
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200), 0.33f));
    }
}
