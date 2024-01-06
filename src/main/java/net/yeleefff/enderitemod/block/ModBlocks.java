package net.yeleefff.enderitemod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yeleefff.enderitemod.EnderiteMod;

public class ModBlocks {

    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.BLACK).strength(50f, 1200.0F).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block ENDERITE_ORE = registerBlock("enderite_ore",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.BLACK).strength(30f, 1200.0F).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(EnderiteMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(EnderiteMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab).fireproof()));
    }

    public static void registerModBlocks() {
        EnderiteMod.LOGGER.debug("Registering Mod Blocks for " + EnderiteMod.MOD_ID);
    }
}
