package deckedoutdroppers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

import java.util.Map;
import java.util.function.Function;

public record ItemStackAttributeChecker(Map<Item, Function<NbtCompound, Boolean>> perItemTypeChecks) {
    public boolean evaluate(ItemStack itemStack) {
        Item itemType = itemStack.getItem();
        NbtCompound itemNbt = itemStack.getNbt();
        
        if (itemNbt == null)
            return false;
        
        if (!perItemTypeChecks.containsKey(itemType))
            return false;
        
        Function<NbtCompound, Boolean> checkFunction = perItemTypeChecks.get(itemType);
        return checkFunction.apply(itemNbt);
    }
}
