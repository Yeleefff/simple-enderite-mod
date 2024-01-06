package net.yeleefff.enderitemod.mixin;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.w3c.dom.Entity;

import java.util.List;

@Mixin(SmithingTemplateItem.class)
public interface NetheriteUpgradeSlotTexturesInvoker {
    @Invoker("getNetheriteUpgradeEmptyBaseSlotTextures")
    public static List<Identifier> invokeGetNetheriteUpgradeEmptyBaseSlotTextures() {
        throw new AssertionError();
    }

    @Invoker("getNetheriteUpgradeEmptyAdditionsSlotTextures")
    public static List<Identifier> invokeGetNetheriteUpgradeEmptyAdditionsSlotTextures() {
        throw new AssertionError();
    }
}