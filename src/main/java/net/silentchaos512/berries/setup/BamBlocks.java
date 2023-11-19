package net.silentchaos512.berries.setup;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.block.BerryBushBlock;
import net.silentchaos512.lib.registry.BlockRegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BamBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, BerriesMod.MOD_ID);

    public static final BlockRegistryObject<BerryBushBlock> ACEROLA_BERRY_BUSH = registerNoItem("acerola_berry_bush",() ->
            getBerryBush(BamItems.ACEROLA_BERRIES));
    public static final BlockRegistryObject<BerryBushBlock> SEABERRY_BUSH = registerNoItem("seaberry_bush",() ->
            getBerryBush(BamItems.SEABERRIES));
    public static final BlockRegistryObject<BerryBushBlock> SNOWBERRY_BUSH = registerNoItem("snowberry_bush",() ->
            getBerryBush(BamItems.SNOWBERRIES));
    public static final BlockRegistryObject<BerryBushBlock> VOID_BERRY_BUSH = registerNoItem("void_berry_bush",() ->
            getBerryBush(BamItems.VOID_BERRIES, Tags.Blocks.END_STONES));
    public static final BlockRegistryObject<BerryBushBlock> SCORCH_BERRY_BUSH = registerNoItem("scorch_berry_bush",() ->
            getBerryBush(BamItems.SCORCH_BERRIES, Tags.Blocks.NETHERRACK));

    @NotNull
    private static BerryBushBlock getBerryBush(ItemLike berries) {
        return getBerryBush(berries, null);
    }

    @NotNull
    private static BerryBushBlock getBerryBush(ItemLike berries, TagKey<Block> soil) {
        return new BerryBushBlock(berries, soil,
                BlockBehaviour.Properties.of()
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
