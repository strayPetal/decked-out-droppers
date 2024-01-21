package deckedoutdroppers;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.function.Function;

import static java.util.Map.entry;

public class DeckedOutDroppersMod {
    public static final String MOD_ID = "decked-out-droppers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static void init() {
    }
    
    public static final ItemStackAttributeChecker DECKED_OUT_ITEM_CHECKER = new ItemStackAttributeChecker(Map.ofEntries(
            entry(Items.IRON_NUGGET, customModelValueIs(1,      // Coin
                                                        2,      // Crown
                                                        3,      // Frost Ember
                                                        201,    // Level 2 Key
                                                        203,    // Level 3 Key
                                                        209,    // Level 4 Key
                                                        208,    // The Bomb
                                                        6,      // Victory Tome
                                                        42,     // Hood of Aw'Yah
                                                        43,     // Axe of the Screamin' Void
                                                        17,     // Multi-Grain Waffle
                                                        33,     // Shades of the Dog
                                                        30,     // Papa's Slippers
                                                        28,     // Jar of Speedy Slime
                                                        29,     // Tome of the Hills
                                                        34,     // Death Loop
                                                        32,     // Pearl of Cleansing
                                                        13,     // Horn of the G.O.A.T.
                                                        12,     // Chisel of the Undead Sculptress
                                                        40,     // Butcher's Apron
                                                        18,     // Hypnotic Bandana
                                                        35,     // Wand of Gorgeousness
                                                        41,     // Knight's Helm
                                                        20,     // Bionic Eye of Doom
                                                        31,     // The Hidden Stache
                                                        15,     // Goggles of Symmetry
                                                        19,     // Golden Eye
                                                        10,     // Pocket Watch of Shreeping
                                                        39,     // An Old Friend's Pickaxe
                                                        16,     // Gem of Greatness
                                                        11,     // CF-135
                                                        44,     // Staff of the Pink Shepherd
                                                        14,     // The Slab
                                                        38,     // The Skadoodler
                                                        36,     // Mug of the Dungeon Master
                                                        37      // The Master's Key
            )),
            entry(Items.IRON_INGOT, customModelValueIs(2   // Rusty Repair Kit
            )),
            entry(Items.PUMPKIN, customNameColorIs("dark_purple"    // Halloween Pumpkin
            )),
            entry(Items.COMPASS, customNameColorIs("green",     // 1 Easy
                                                   "yellow",    // 1 Medium
                                                   "#fed83d",   // 2 Medium
                                                   "gold",      // 2 Hard, 3 Hard
                                                   "#b02e26",   // 3 Deadly
                                                   "dark_red",  // 4 Deadly
                                                   "#3ab3da"    // 4 Deepfrost
            )),
            entry(Items.FILLED_MAP, mapIdIs(976     // In-Game UI Map
            ))
    ));
    
    public static boolean isItemForDeckedOut(ItemStack itemStack) {
        return DECKED_OUT_ITEM_CHECKER.evaluate(itemStack);
    }
    
    private static <T> boolean isOneOf(T value, T[] list) {
        for (T t : list)
            if (value.equals(t)) return true;
        return false;
    }
    
    private static Function<NbtCompound, Boolean> customModelValueIs(Integer... customModelValues) {
        return nbt -> isOneOf(nbt.getInt("CustomModelData"), customModelValues);
    }
    
    private static Function<NbtCompound, Boolean> customNameColorIs(String... color) {
        return nbt -> isOneOf(nbt.getCompound("NameFormat").getString("color"), color);
    }
    
    private static Function<NbtCompound, Boolean> mapIdIs(Integer... mapIds) {
        return nbt -> isOneOf(nbt.getInt("map"), mapIds);
    }
}
