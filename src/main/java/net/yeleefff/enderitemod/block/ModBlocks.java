package net.yeleefff.enderitemod.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.EnderiteMod;

public class ModBlocks {

    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)
                    .mapColor(MapColor.BLACK).strength(50f, 1200.0F).requiresTool()));

    public static final Block ENDERITE_ORE = registerBlock("enderite_ore",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)
                    .mapColor(MapColor.BLACK).strength(30f, 1200.0F).requiresTool()));

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDERITE_ORE);
    }

    private static void addItemsToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENDERITE_BLOCK);
    }

    private static void addItemsToNaturalBlocksItemGroup(FabricItemGroupEntries entires) {
        entires.add(ENDERITE_ORE);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EnderiteMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EnderiteMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().fireproof()));
    }

    public static void registerModBlocks() {
        EnderiteMod.LOGGER.debug("Registering Mod Blocks for " + EnderiteMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModBlocks::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlocksItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addItemsToNaturalBlocksItemGroup);
    }
}
