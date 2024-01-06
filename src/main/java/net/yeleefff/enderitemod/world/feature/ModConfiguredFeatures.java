package net.yeleefff.enderitemod.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> END_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDERITE_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ENDERITE_ORE =
            ConfiguredFeatures.register("enderite_ore", Feature.SCATTERED_ORE, new OreFeatureConfig(END_ORES, 3));


    public static void registerConfiguredFeatures() {
        EnderiteMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + EnderiteMod.MOD_ID);
    }
}
