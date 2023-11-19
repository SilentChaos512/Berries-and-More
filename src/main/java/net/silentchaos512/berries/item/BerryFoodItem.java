package net.silentchaos512.berries.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class BerryFoodItem extends Item {
    private final UseAnim useAnim;

    public BerryFoodItem(UseAnim useAnim, Properties properties) {
        super(properties);
        this.useAnim = useAnim;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return useAnim;
    }
}
