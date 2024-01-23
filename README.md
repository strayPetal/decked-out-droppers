# Decked Out Droppers
A simple little Minecraft mod that automatically replenishes (hopefully all of) the droppers in the game, Decked Out 2, designed and built on Hermitcraft S9 by Tango Tek, allowing you to play forever without worrying about the looming prospect of your droppers eventually running out and the dread of having to refill them again.

_I, or this mod, are in no way affiliated with the Hermitcraft SMP, Tango, etc. I'm just some random person who got addicted to Decked Out and doesn't want to and doesn't know how to properly refill those droppers, so made this mod instead._

**Download via GitHub Releases**: [Latest](/../../releases/latest)\

You can grab the Hermitcraft S9 world download from https://hermitcraft.com/ and play Decked Out 2 for yourself too!

Make sure to read the [additional setup instructions](#additional-setup) once you have installed the mod to set up the world properly to work with this mod enabled!

Tango has a very nice explainer video for those who aren't familiar with the game here: [How to Play Decked Out 2!](https://youtu.be/aoVVCwx6k1w)

## Additional Setup
You'll need to run these commands in the Decked Out world download, to set up a few more droppers to correctly work with this mod installed. All of the other droppers are already covered; it's just these few that need a bit of extra setup!

**Make sure to set Carpet's `fillUpdates` to `true` (the default value)!** If you don't know what this is, then you don't have to worry about it.

- For some additional information, placing a _Reinforced Deepslate_ block underneath a dropper signals the mod to keep it replenished, regardless of the item being dispensed, which is useful for items that are not unique to Decked Out, such as porkchops or diamond armour.
- On the other hand, placing a _Petrified Oak Slab_ underneath a dropper tells the mod to never keep it replenished, regardless of the item inside. This is used in any case where we don't want the dropper to replenish itself, which would otherwise be the default behaviour with a Decked Out-specific item inside.

### The commands to run
_For the crown dropper that gives you back any picked up crowns in the dungeon. This isn't supposed to give you infinite amounts, so this will fix it up for you. **Very important!**_

```
/setblock -643 -54 2002 minecraft:petrified_oak_slab
```

_Left row of the ember shop. Some of Tango's redstone is in the way, so we have to fix that up to make room for the marker blocks, which are what the extra commands are for. Shouldn't change the redstone behaviour._

```
/setblock -629 -22 1999 minecraft:redstone_wire
/setblock -631 -21 1991 stone_button
/setblock -630 -22 1992 repeater[facing=north]
/fill -630 -21 1992 -630 -21 2014 minecraft:reinforced_deepslate
```

_Right row of ember shop._

```
/fill -644 -21 1992 -644 -21 2014 minecraft:reinforced_deepslate
```

_Armour for the Suit Up Card._

```
/setblock -629 58 1945 minecraft:reinforced_deepslate
```

_Porkchops from the Pork Chop Power card._

```
/setblock -627 58 1945 minecraft:reinforced_deepslate
```

_Halloween Pumpkin "Shop" (includes porkchops that wouldn't normally be replenished)_

```
/setblock -523 11 2042 minecraft:reinforced_deepslate
```

The rest of the Decked Out items are covered by default by this mod, so don't worry about a thing!