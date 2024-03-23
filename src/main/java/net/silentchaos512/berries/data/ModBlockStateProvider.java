package net.silentchaos512.berries.data;

import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.silentchaos512.berries.BerriesMod;
import net.silentchaos512.berries.setup.BamBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), BerriesMod.MOD_ID, event.getExistingFileHelper());
    }

    @Override
    protected void registerStatesAndModels() {
        berryBush(BamBlocks.ACEROLA_BERRY_BUSH);
        berryBush(BamBlocks.SEABERRY_BUSH);
        berryBush(BamBlocks.SNOWBERRY_BUSH);
        berryBush(BamBlocks.VOID_BERRY_BUSH);
        berryBush(BamBlocks.SCORCH_BERRY_BUSH);
    }

    private void berryBush(DeferredBlock<?> block) {
        String blockName = block.getId().getPath();
        getVariantBuilder(block.get()).forAllStates(state -> {
            int age = state.getValue(SweetBerryBushBlock.AGE);
            String name = blockName + "_stage" + age;
            return ConfiguredModel.builder()
                    .modelFile(models().cross(name, modLoc("block/" + name)).renderType("cutout"))
                    .build();
        });
    }
}
