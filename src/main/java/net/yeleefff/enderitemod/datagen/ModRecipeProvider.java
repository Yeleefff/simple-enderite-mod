package net.yeleefff.enderitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.BlastingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.block.ModBlocks;
import net.yeleefff.enderitemod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void offerEnderiteUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(input), Ingredient.ofItems(ModItems.ENDERITE_INGOT), category, result)
                .criterion("has_enderite_ingot", FabricRecipeProvider.conditionsFromItem(ModItems.ENDERITE_INGOT))
                .offerTo(exporter, "enderitemod:" + FabricRecipeProvider.getItemPath(result) + "_smithing");
    }

    @Override
    public void generate(RecipeExporter exporter) {
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModBlocks.ENDERITE_ORE), RecipeCategory.MISC, ModItems.ENDERITE_SCRAP, 2.0f, 200, RecipeSerializer.SMELTING, SmeltingRecipe::new)
                .group("enderite")
                .criterion("has_enderite_ore", FabricRecipeProvider.conditionsFromItem(ModBlocks.ENDERITE_ORE))
                .offerTo(exporter, "enderitemod:" + RecipeProvider.getItemPath(ModItems.ENDERITE_SCRAP) + "_from_smelting_" + RecipeProvider.getItemPath(ModBlocks.ENDERITE_ORE));

        CookingRecipeJsonBuilder.create(Ingredient.ofItems(ModBlocks.ENDERITE_ORE), RecipeCategory.MISC, ModItems.ENDERITE_SCRAP, 2.0f, 100, RecipeSerializer.BLASTING, BlastingRecipe::new)
                .group("enderite")
                .criterion("has_enderite_ore", FabricRecipeProvider.conditionsFromItem(ModBlocks.ENDERITE_ORE))
                .offerTo(exporter, "enderitemod:" + FabricRecipeProvider.getItemPath(ModItems.ENDERITE_SCRAP) + "_from_blasting_" + FabricRecipeProvider.getItemPath(ModBlocks.ENDERITE_ORE));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDERITE_INGOT, 1)
                .input(ModItems.ENDERITE_SCRAP, 2)
                .input(Items.ENDER_EYE, 2)
                .group("enderite")
                .criterion("has_enderite_scrap", FabricRecipeProvider.conditionsFromItem(ModItems.ENDERITE_SCRAP))
                .offerTo(exporter, Identifier.of("enderitemod:enderite_ingot"));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ENDERITE_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERITE_BLOCK, "enderitemod:enderite_block" ,
                "enderite", "enderitemod:enderite_ingot_from_block", "enderite");

        offerSmithingTemplateCopyingRecipe(exporter, ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, Items.END_STONE);

        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.ENDERITE_AXE);
        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, ModItems.ENDERITE_PICKAXE);
        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, ModItems.ENDERITE_SHOVEL);
        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_HOE, RecipeCategory.TOOLS, ModItems.ENDERITE_HOE);

        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, ModItems.ENDERITE_SWORD);

        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, ModItems.ENDERITE_HELMET);
        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.ENDERITE_CHESTPLATE);
        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, ModItems.ENDERITE_LEGGINGS);
        offerEnderiteUpgradeRecipe(exporter, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, ModItems.ENDERITE_BOOTS);
    }
}
