package net.yeleefff.enderitemod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.EnderiteMod;
import net.minecraft.util.registry.Registry;
import net.yeleefff.enderitemod.item.custom.ModAxeItem;
import net.yeleefff.enderitemod.item.custom.ModHoeItem;
import net.yeleefff.enderitemod.item.custom.ModPickaxeItem;

public class ModItems {

    // Basic items
    public static final Item ENDERITE_SCRAP = registerItems("enderite_scrap",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof()));
    public static final Item ENDERITE_INGOT = registerItems("enderite_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof()));

    // Tools
    public static final Item ENDERITE_SWORD = registerItems("enderite_sword",
            new SwordItem(ModToolMaterials.ENDERITE, 8, -2.4f,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item ENDERITE_SHOVEL = registerItems("enderite_shovel",
            new ShovelItem(ModToolMaterials.ENDERITE, 5.5f, -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS).fireproof()));
    public static final Item ENDERITE_PICKAXE = registerItems("enderite_pickaxe",
            new ModPickaxeItem(ModToolMaterials.ENDERITE, 6, -2.8f,
                    new FabricItemSettings().group(ItemGroup.TOOLS).fireproof()));
    public static final Item ENDERITE_AXE = registerItems("enderite_axe",
            new ModAxeItem(ModToolMaterials.ENDERITE, 10, -3f,
                    new FabricItemSettings().group(ItemGroup.TOOLS).fireproof()));
    public static final Item ENDERITE_HOE = registerItems("enderite_hoe",
            new ModHoeItem(ModToolMaterials.ENDERITE, 0, 0f,
                    new FabricItemSettings().group(ItemGroup.TOOLS).fireproof()));

    // Armor
    public static final Item ENDERITE_HELMET = registerItems("enderite_helmet",
            new ArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item ENDERITE_CHESTPLATE = registerItems("enderite_chestplate",
            new ArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item ENDERITE_LEGGINGS = registerItems("enderite_leggings",
            new ArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));
    public static final Item ENDERITE_BOOTS = registerItems("enderite_boots",
            new ArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT).fireproof()));


    private static Item registerItems(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnderiteMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EnderiteMod.LOGGER.debug("Registering Mod Items for " + EnderiteMod.MOD_ID);
    }
}
