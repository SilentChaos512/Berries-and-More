package net.silentchaos512.berries.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class BamFoodItem extends Item {
    private final UseAnim useAnim;

    public BamFoodItem(UseAnim useAnim, Properties properties) {
        super(properties);
        this.useAnim = useAnim;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return useAnim;
    }
}
