package net.yeleefff.enderitemod.item;

import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.item.trim.ArmorTrimMaterials;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModArmorTrimMaterials extends ArmorTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> ENDERITE = ModArmorTrimMaterials.of("enderite");

    public static void bootstrap(Registerable<ArmorTrimMaterial> registry) {
        ModArmorTrimMaterials.register(registry, ENDERITE, ModItems.ENDERITE_INGOT, Style.EMPTY.withColor(6445145), 1.1f, Map.of()); //ModArmorMaterials.ENDERITE, "enderite_darker"
    }

    private static void register(Registerable<ArmorTrimMaterial> registry, RegistryKey<ArmorTrimMaterial> key, Item ingredient, Style style, float itemModelIndex, Map<ArmorMaterials, String> overrideArmorMaterials) {
        ArmorTrimMaterial armorTrimMaterial = ArmorTrimMaterial.of(key.getValue().getPath(), ingredient, itemModelIndex, Text.translatable(Util.createTranslationKey("trim_material", key.getValue())).fillStyle(style), overrideArmorMaterials);
        registry.register(key, armorTrimMaterial);
    }

    private static RegistryKey<ArmorTrimMaterial> of(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, new Identifier("enderitemod", id));
    }
}

// Have to add data gen for darker version
// Dont call .of, just call new (and register it yourself too)
