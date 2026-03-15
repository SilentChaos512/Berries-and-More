package net.silentchaos512.berries.data.client;

import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.silentchaos512.berries.setup.BamBlocks;
import net.silentchaos512.lib.data.client.LibBlockModelGenerators;
import net.silentchaos512.lib.data.client.LibModelTemplates;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ModBlockModelGenerator extends LibBlockModelGenerators {
    public ModBlockModelGenerator(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    @Override
    public void run() {
        createBerryBush(BamBlocks.ACEROLA_BERRY_BUSH);
        createBerryBush(BamBlocks.SEABERRY_BUSH);
        createBerryBush(BamBlocks.SNOWBERRY_BUSH);
        createBerryBush(BamBlocks.VOID_BERRY_BUSH);
        createBerryBush(BamBlocks.SCORCH_BERRY_BUSH);

        createCropBlock(BamBlocks.BARLEY.get(), CropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        createRotatedPillarWithHorizontalVariant(BamBlocks.BARLEY_BLOCK.get(), TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
    }

    private void createBerryBush(DeferredBlock<?> block) {
        this.blockStateOutput
                .accept(
                        MultiVariantGenerator.dispatch(block.get())
                                .with(
                                        PropertyDispatch.initial(BlockStateProperties.AGE_3)
                                                .generate(
                                                        age -> plainVariant(
                                                                this.createSuffixedVariant(block.get(), "_stage" + age, LibModelTemplates.CROSS_CUTOUT, TextureMapping::cross)
                                                        )
                                                )
                                )
                );
    }
}
