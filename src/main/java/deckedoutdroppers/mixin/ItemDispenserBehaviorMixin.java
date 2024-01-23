package deckedoutdroppers.mixin;

import deckedoutdroppers.DispenseAction;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static deckedoutdroppers.DeckedOutDroppersMod.shouldCostNothing;

@Mixin(ItemDispenserBehavior.class)
public abstract class ItemDispenserBehaviorMixin {
    @Inject(method = "dispenseSilently",
            at = @At(value = "HEAD"))
    private void conditionalNoItemCost(BlockPointer pointer, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        DispenseAction dispenseAction = new DispenseAction(pointer, stack);
        if (shouldCostNothing(dispenseAction))
            stack.increment(1);
    }
}
