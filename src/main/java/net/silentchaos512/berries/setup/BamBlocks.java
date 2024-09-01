package net.silentchaos512.berries.setup;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.block.BerryBushBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;

public class BamBlocks {
    public static final DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(BerriesMod.MOD_ID);

    public static final DeferredBlock<BerryBushBlock> ACEROLA_BERRY_BUSH = registerNoItem("acerola_berry_bush", () ->
            getBerryBush(BamItems.ACEROLA_BERRIES)
    );
    public static final DeferredBlock<BerryBushBlock> SEABERRY_BUSH = registerNoItem("seaberry_bush", () ->
            getBerryBush(BamItems.SEABERRIES)
    );
    public static final DeferredBlock<BerryBushBlock> SNOWBERRY_BUSH = registerNoItem("snowberry_bush", () ->
            getBerryBush(BamItems.SNOWBERRIES)
    );
    public static final DeferredBlock<BerryBushBlock> VOID_BERRY_BUSH = registerNoItem("void_berry_bush", () ->
            getBerryBush(BamItems.VOID_BERRIES, Tags.Blocks.END_STONES)
    );
    public static final DeferredBlock<BerryBushBlock> SCORCH_BERRY_BUSH = registerNoItem("scorch_berry_bush", () ->
            getBerryBush(BamItems.SCORCH_BERRIES, Tags.Blocks.NETHERRACKS)
    );
    public static final DeferredBlock<CropBlock> BARLEY = registerNoItem("barley", () ->
            new CropBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)
            )
    );
    public static final DeferredBlock<HayBlock> BARLEY_BLOCK = register("barley_block", () ->
            new HayBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_YELLOW)
                            .instrument(NoteBlockInstrument.BANJO)
                            .strength(0.5f)
                            .sound(SoundType.GRASS)
            )
    );

    @NotNull
    private static BerryBushBlock getBerryBush(ItemLike berries) {
        return getBerryBush(berries, null);
    }

    @NotNull
    private static BerryBushBlock getBerryBush(ItemLike berries, @Nullable TagKey<Block> soil) {
        return new BerryBushBlock(
                berries,
                soil,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .randomTicks()
                        .noCollission()
                        .sound(SoundType.SWEET_BERRY_BUSH)
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    private static <T extends Block> DeferredBlock<T> registerNoItem(String name, Supplier<T> block) {
        return REGISTER.register(name, block);
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        return register(name, block, b -> () -> new BlockItem(b.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block, Function<DeferredBlock<T>, Supplier<? extends BlockItem>> item) {
        DeferredBlock<T> ret = registerNoItem(name, block);
        BamItems.REGISTER.register(name, item.apply(ret));
        return ret;
    }
}
