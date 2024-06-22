package net.yeleefff.enderitemod.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.yeleefff.enderitemod.EnderiteMod;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> ENDERITE = registerArmorMaterials("enderite", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
        map.put(ArmorItem.Type.BODY, 11);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () ->
            Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT}));

    private static RegistryEntry<ArmorMaterial> registerArmorMaterials(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(Identifier.of(id)));
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] armorValues = ArmorItem.Type.values();
        int numArmorValues = armorValues.length;

        for(int i = 0; i < numArmorValues; i++) {
            ArmorItem.Type type = armorValues[i];
            enumMap.put(type, defense.get(type));
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(EnderiteMod.MOD_ID, id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }

    public static void registerModArmorMaterials() {
        EnderiteMod.LOGGER.debug("Register Mod Armor Materials for " + EnderiteMod.MOD_ID);
    }
}

//public enum ModArmorMaterials implements ArmorMaterial {
//
//    ENDERITE("enderite", 41, new int[]{3, 8, 6, 3}, 20,
//            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> Ingredient.ofItems(ModItems.ENDERITE_INGOT));
//
//    private final String name;
//    private final int durabilityMultiplier;
//    private final int[] protectionAmounts;
//    private final int enchantability;
//    private final SoundEvent equipSound;
//    private final float toughness;
//    private final float knockbackResistance;
//    private final Supplier<Ingredient> repairIngredient;
//
//    private static final int[] BASE_DURABILITY = new int[]{11, 16, 15, 13};
//
//    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
//        this.name = name;
//        this.durabilityMultiplier = durabilityMultiplier;
//        this.protectionAmounts = protectionAmounts;
//        this.enchantability = enchantability;
//        this.equipSound = equipSound;
//        this.toughness = toughness;
//        this.knockbackResistance = knockbackResistance;
//        this.repairIngredient = repairIngredient;
//    }
//
//    @Override
//    public int getDurability(ArmorItem.Type type) {
//        return BASE_DURABILITY[type.ordinal()] = this.durabilityMultiplier;
//    }
//
//    @Override
//    public int getProtection(ArmorItem.Type type) {
//        return protectionAmounts[type.ordinal()];
//    }
//
//    @Override
//    public int getEnchantability() {
//        return this.enchantability;
//    }
//
//    @Override
//    public SoundEvent getEquipSound() {
//        return this.equipSound;
//    }
//
//    @Override
//    public Ingredient getRepairIngredient() {
//        return this.repairIngredient.get();
//    }
//
//    @Override
//    public String getName() {
//        return EnderiteMod.MOD_ID + ":" + this.name;
//    }
//
//    @Override
//    public float getToughness() {
//        return this.toughness;
//    }
//
//    @Override
//    public float getKnockbackResistance() {
//        return this.knockbackResistance;
//    }
//}
