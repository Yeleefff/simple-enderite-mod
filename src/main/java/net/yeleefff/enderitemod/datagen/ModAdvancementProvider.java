package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.EnderiteMod;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry obtainEnderiteOre = Advancement.Builder.create().parent(Identifier.of("end/root")).display(
                ModBlocks.ENDERITE_ORE,
                Text.literal("Hidden in the Void"),
                Text.literal("Obtain Enderite Debris"),
                null,
                AdvancementFrame.TASK,
                true,
                true,
                false
            ).criterion("has_enderite_ore", InventoryChangedCriterion.Conditions.items(ModBlocks.ENDERITE_ORE))
                .build(consumer, EnderiteMod.MOD_ID + ":end/obtain_enderite_ore");

        AdvancementEntry obtainEnderiteArmor = Advancement.Builder.create().parent(obtainEnderiteOre).display(
                ModItems.ENDERITE_CHESTPLATE,
                Text.literal("Cover Me in Debris: The Sequel"),
                Text.literal("Get a full set of Enderite armor"),
                null,
                AdvancementFrame.CHALLENGE,
                true,
                true,
                false
            ).rewards(AdvancementRewards.Builder.experience(100))
                .criterion("enderite_armor", InventoryChangedCriterion.Conditions.items(ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS))
                .build(consumer, EnderiteMod.MOD_ID + ":end/enderite_armor");

        AdvancementEntry obtainEnderiteHoe = Advancement.Builder.create().parent(Identifier.of("husbandry/obtain_netherite_hoe")).display(
                ModItems.ENDERITE_HOE,
                Text.literal("Too Much Dedication"),
                Text.literal("Use an Enderite Ingot to upgrade a Netherite Hoe after failing to rethink your life choices"),
                null,
                AdvancementFrame.CHALLENGE,
                true,
                true,
                true
            ).rewards(AdvancementRewards.Builder.experience(100))
                .criterion("enderite_hoe", InventoryChangedCriterion.Conditions.items(ModItems.ENDERITE_HOE))
                .build(consumer, EnderiteMod.MOD_ID + ":husbandry/obtain_enderite_hoe");
    }
}
