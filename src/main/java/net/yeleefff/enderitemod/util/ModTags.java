package net.yeleefff.enderitemod.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yeleefff.enderitemod.EnderiteMod;

public class ModTags {
    public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = of("incorrect_for_enderite_tool");

    private static TagKey<net.minecraft.block.Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(EnderiteMod.MOD_ID, id));
    }
}
