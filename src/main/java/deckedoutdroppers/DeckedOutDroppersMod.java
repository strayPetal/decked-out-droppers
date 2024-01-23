package deckedoutdroppers;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Function;

public class DeckedOutDroppersMod {
    public static final String MOD_ID = "decked-out-droppers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static void init() {
    }
    
    public static final Block ALWAYS_ALLOW_MARKER = Blocks.REINFORCED_DEEPSLATE;
    public static final Block NEVER_ALLOW_MARKER = Blocks.PETRIFIED_OAK_SLAB;
    
    public static final DispenseActionConditionalChecker DECKED_OUT_ITEM_CHECKER = new DispenseActionConditionalChecker(List.of(
            List.of(itemIs(Items.IRON_NUGGET),
                    customModelValueIs(1,    // Coin
                                       2,    // Crown
                                       3,    // Frost Ember
                                       201,  // Level 2 Key
                                       203,  // Level 3 Key
                                       209,  // Level 4 Key
                                       208,  // The Bomb
                                       6,    // Victory Tome
                                       42,   // Hood of Aw'Yah
                                       43,   // Axe of the Screamin' Void
                                       17,   // Multi-Grain Waffle
                                       33,   // Shades of the Dog
                                       30,   // Papa's Slippers
                                       28,   // Jar of Speedy Slime
                                       29,   // Tome of the Hills
                                       34,   // Death Loop
                                       32,   // Pearl of Cleansing
                                       13,   // Horn of the G.O.A.T.
                                       12,   // Chisel of the Undead Sculptress
                                       40,   // Butcher's Apron
                                       18,   // Hypnotic Bandana
                                       35,   // Wand of Gorgeousness
                                       41,   // Knight's Helm
                                       20,   // Bionic Eye of Doom
                                       31,   // The Hidden Stache
                                       15,   // Goggles of Symmetry
                                       19,   // Golden Eye
                                       10,   // Pocket Watch of Shreeping
                                       39,   // An Old Friend's Pickaxe
                                       16,   // Gem of Greatness
                                       11,   // CF-135
                                       44,   // Staff of the Pink Shepherd
                                       14,   // The Slab
                                       38,   // The Skadoodler
                                       36,   // Mug of the Dungeon Master
                                       37)), // The Master's Key
            List.of(itemIs(Items.IRON_INGOT),
                    customModelValueIs(2        // Rusty Repair Kit
                    )),
            List.of(itemIs(Items.PUMPKIN),
                    customNameColorIs("dark_purple" // Halloween Pumpkin
                    )),
            List.of(itemIs(Items.COMPASS),
                    customNameColorIs("green",     // 1 Easy
                                      "yellow",    // 1 Medium
                                      "#fed83d",   // 2 Medium
                                      "gold",      // 2 Hard, 3 Hard
                                      "#b02e26",   // 3 Deadly
                                      "dark_red",  // 4 Deadly
                                      "#3ab3da"    // 4 Deepfrost
                    )),
            List.of(itemIs(Items.FILLED_MAP),
                    mapIdIs(976     // In-Game UI Map
                    ))
    ));
    
    public static boolean shouldCostNothing(DispenseAction dispenseAction) {
        Block marker = dispenseAction.getMarkerBlock();
        if (marker == ALWAYS_ALLOW_MARKER)
            return true;
        else if (marker == NEVER_ALLOW_MARKER)
            return false;
        
        return DECKED_OUT_ITEM_CHECKER.evaluate(dispenseAction);
    }
    
    private static <T> boolean isOneOf(T value, T[] list) {
        for (T t : list)
            if (value.equals(t)) return true;
        return false;
    }
    
    private static Function<DispenseAction, Boolean> itemIs(Item itemType) {
        return da -> da.getItemType() == itemType;
    }
    
    private static Function<DispenseAction, Boolean> customModelValueIs(Integer... customModelValues) {
        return da -> isOneOf(da.getItemNbt().getInt("CustomModelData"), customModelValues);
    }
    
    private static Function<DispenseAction, Boolean> customNameColorIs(String... color) {
        return da -> isOneOf(da.getItemNbt().getCompound("NameFormat").getString("color"), color);
    }
    
    private static Function<DispenseAction, Boolean> mapIdIs(Integer... mapIds) {
        return da -> isOneOf(da.getItemNbt().getInt("map"), mapIds);
    }
}
