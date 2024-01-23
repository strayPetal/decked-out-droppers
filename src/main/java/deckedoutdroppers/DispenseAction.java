package deckedoutdroppers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;

public record DispenseAction(BlockPointer blockPointer, ItemStack itemStack) {
    public Item getItemType() {
        return itemStack.getItem();
    }
    
    public NbtCompound getItemNbt() {
        return itemStack.getNbt();
    }
    
    public BlockPos getDispenserPosition() {
        return blockPointer.pos();
    }
    
    public ServerWorld getWorld() {
        return blockPointer.level();
    }
    
    public Block getMarkerBlock() {
        return getWorld().getBlockState(getDispenserPosition().down()).getBlock();
    }
}
