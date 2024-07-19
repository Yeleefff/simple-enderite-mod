package net.yeleefff.enderitemod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier END_CITY_CHEST_ID = Identifier.of("minecraft", "chests/end_city_treasure");

    public static void modifyLootTables() {
//        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
//            if (END_CITY_CHEST_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1.0f))
//                        .conditionally(RandomChanceLootCondition.builder(0.05f))
//                        .with(ItemEntry.builder(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE));
//                tableBuilder.pool(poolBuilder.build());
//            }
//        }));

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (source.isBuiltin() && END_CITY_CHEST_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(RandomChanceLootCondition.builder(0.07f))
                        .with(ItemEntry.builder(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE));
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
