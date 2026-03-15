package net.silentchaos512.berries.setup;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BamBlocks {
    public static final DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(BerriesMod.MOD_ID);

    public static final DeferredBlock<BerryBushBlock> ACEROLA_BERRY_BUSH = registerBerryBush("acerola_berry_bush", BamItems.ACEROLA_BERRIES);
    public static final DeferredBlock<BerryBushBlock> SEABERRY_BUSH = registerBerryBush("seaberry_bush", BamItems.SEABERRIES);
    public static final DeferredBlock<BerryBushBlock> SNOWBERRY_BUSH = registerBerryBush("snowberry_bush", BamItems.SNOWBERRIES);
    public static final DeferredBlock<BerryBushBlock> VOID_BERRY_BUSH = registerBerryBush("void_berry_bush", BamItems.VOID_BERRIES, Tags.Blocks.END_STONES);
    public static final DeferredBlock<BerryBushBlock> SCORCH_BERRY_BUSH = registerBerryBush("scorch_berry_bush", BamItems.SCORCH_BERRIES, Tags.Blocks.NETHERRACKS);
    public static final DeferredBlock<CropBlock> BARLEY = registerNoItem(
            "barley",
            CropBlock::new,
            properties -> properties
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final DeferredBlock<HayBlock> BARLEY_BLOCK = register(
            "barley_block",
            HayBlock::new,
            properties -> properties
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BANJO)
                    .strength(0.5f)
                    .sound(SoundType.GRASS)
    );

    private static DeferredBlock<BerryBushBlock> registerBerryBush(String name, ItemLike berries) {
        return registerBerryBush(name, berries, null);
    }

    private static DeferredBlock<BerryBushBlock> registerBerryBush(String name, ItemLike berries, @Nullable TagKey<Block> soil) {
        return registerNoItem(
                name,
                properties -> new BerryBushBlock(berries, soil, properties),
                properties -> properties
                        .mapColor(MapColor.PLANT)
                        .randomTicks()
                        .noCollision()
                        .sound(SoundType.SWEET_BERRY_BUSH)
                        .pushReaction(PushReaction.DESTROY)
        );
    }

    private static <T extends Block> DeferredBlock<T> registerNoItem(String name, Function<BlockBehaviour.Properties, T> block, Consumer<BlockBehaviour.Properties> properties) {
        return REGISTER.registerBlock(name, block, p -> {
            properties.accept(p);
            return p;
        });
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Function<BlockBehaviour.Properties, T> block, Consumer<BlockBehaviour.Properties> properties) {
        var itemId = ResourceKey.create(Registries.ITEM, BerriesMod.getId(name));
        return register(name, block, properties, b -> () -> new BlockItem(b.get(), new Item.Properties().setId(itemId).useBlockDescriptionPrefix()));
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Function<BlockBehaviour.Properties, T> block, Consumer<BlockBehaviour.Properties> properties, Function<DeferredBlock<T>, Supplier<? extends BlockItem>> item) {
        DeferredBlock<T> ret = registerNoItem(name, block, properties);
        BamItems.REGISTER.register(name, item.apply(ret));
        return ret;
    }
}
