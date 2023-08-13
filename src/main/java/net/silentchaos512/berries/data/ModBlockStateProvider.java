package net.silentchaos512.berries.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.lib.block.IBlockProvider;
import net.silentchaos512.lib.util.NameUtils;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), BerriesMod.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void registerStatesAndModels() {
        berryBush(BamBlocks.ACEROLA_BERRY_BUSH.get());
        berryBush(BamBlocks.SEABERRY_BUSH.get());
        berryBush(BamBlocks.SNOWBERRY_BUSH.get());
    }

    private void berryBush(Block block) {
        String blockName = NameUtils.fromBlock(block).getPath();
        getVariantBuilder(block).forAllStates(state -> {
            int age = state.getValue(SweetBerryBushBlock.AGE);
            String name = blockName + "_stage" + age;
            return ConfiguredModel.builder()
                    .modelFile(models().cross(name, modLoc("block/" + name)).renderType("cutout"))
                    .build();
        });
    }
}
