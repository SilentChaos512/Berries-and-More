package net.silentchaos512.berries.setup;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.lib.registry.BlockRegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BamBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, BerriesMod.MOD_ID);

    public static final BlockRegistryObject<SweetBerryBushBlock> ACEROLA_BERRY_BUSH = registerNoItem("acerola_berry_bush", BamBlocks::getBerryBush);
    public static final BlockRegistryObject<SweetBerryBushBlock> SEABERRY_BUSH = registerNoItem("seaberry_bush", BamBlocks::getBerryBush);
    public static final BlockRegistryObject<SweetBerryBushBlock> SNOWBERRY_BUSH = registerNoItem("snowberry_bush", BamBlocks::getBerryBush);

    @NotNull
    private static SweetBerryBushBlock getBerryBush() {
        return new SweetBerryBushBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .randomTicks()
                .noCollission()
                .sound(SoundType.SWEET_BERRY_BUSH)
                .pushReaction(PushReaction.DESTROY)
        );
    }

    private static <T extends Block> BlockRegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return new BlockRegistryObject<>(REGISTER.register(name, block));
    }
}
