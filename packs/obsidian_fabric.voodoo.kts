title     = "obsidian 1.16 Fabric Modpack"
authors   = listOf("copygirl")
version   = "0.3.3"
icon      = rootFolder.resolve("icon.png")

mcVersion = "1.16.4"
modloader { fabric(Fabric.intermediary.v_1_16_4) }

pack {
    multimc {
        selfupdateUrl = "https://meowface.org/copygirl/obsidian_fabric/obsidian_fabric.json"
    }
}

root<Curse> {
    releaseTypes = setOf(FileType.Release, FileType.Beta, FileType.Alpha)

    // COMMON MODS
    it.list {
        common.validMcVersions   = setOf("1.16.2", "1.16.3")
        common.invalidMcVersions = setOf("Forge")

        // Libraries
        +Mod.dataLoader { common.validMcVersions = setOf("1.16.1") }
                        // Allows loading datapacks from `config/datapacks/`

        // Optimization and Fixes
        +Mod.lithium // General-purpose server optimization
        // TODO: +Mod.phosphor // Optimize the lighting engine

        // Tweaks and Utilities
        +Mod.appleskin              // Displays hunger/saturation information
        +Mod.darkLoadingScreen      // Red is dead!
        +Mod.drogtor                // Nicknames and colored names
        +Mod.hwyla                  // Shows what you're looking at
        +Mod.roughlyEnoughItems     // Like JEI, displays recipes and uses
        +Mod.roughlyEnoughResources // Like JER, displays block and mob drops
        +Mod.shulkerboxtooltip      // Show shulker box contents when hovering over them

        // Gameplay Changes
        +Mod.chainsLink            // Pistons move connected chain blocks
        +Mod.editSign              // Allow editing signs in-place
        +Mod.fabrication           // Collection of different gameplay tweaks
        +Mod.fairenchanting        // Pay fairly in XP, rather than levels
        +Mod.grindEnchantments     // Use Grindstone to disenchant onto books
        +Mod.overpoweredMending    // Repairs all mending items in inventory
        +Mod.stackablepotions      // Stack potions up to 16
        +Mod.suitablyStackableStew // Stews stack up to 16

        // ------------------
        // == CONTENT MODS ==
        // ------------------

        // World Generation
        +Mod.endRebellion               // More content for the End
        +Mod.heartOfTheMachine          // Dimension of abandoned machineries
        +Mod.ohTheBiomesYoullGoFabric   // Over 70 varied biomes
        +Mod.repurposedStructuresFabric // More structures and variants

        // Decoration
        +Mod.adorn                     // Decorate your home!
        +Mod.bambooTweaksFabric        { common.validMcVersions = setOf("1.16.1") }
                                       // Bamboo building blocks
        +Mod.bedspreadsFabric          // Banners on beds
        +Mod.betterSlabs               // Verticalness for ALL THE SLABS!
        +Mod.colorfulCut               // Slabs, stairs and walls made of concrete and terracotta
        +Mod.modernGlassDoors          // Adds glass door variants of Vanilla doors
        +Mod.ohHowTheCraftingHasTabled // Crafting Tables made of all the woods
        +Mod.woodsPlus                 // Additional wooden planks variants

        // Various
        +Mod.aquarius            { common.validMcVersions = setOf("1.16.1") }
                                 // Expanding on Aquatic Update content
        +Mod.campanion           // Camping companion mod adding various things
        +Mod.doubleJumpMod       // Enchantment (level I to III) that adds double-jumps
        +Mod.ducts               // Hopper-like blocks to move items around more efficiently
        +Mod.immersivePortalsMod // See-through portals and seamless travel
        +Mod.linkedStorage       // Basically Ender Storage
        +Mod.mooblooms           // Mooshrooms, but with flowers
        +Mod.netheriteHorseArmor // Upgrade diamond horse armor to netherite tier
        +Mod.respawnablePets     // Item that allows your pets to respawn when sleeping
        +Mod.rswires             // RedPower2-like redstones wires and bundled cables
        +Mod.sandwichable        // Make custom sandwiches with many ingredients
        +Mod.theParakeetMod      // More birbs!
        // TODO: https://github.com/Virtuoel/Towelette/issues/33
        // +Mod.towelette           // "Waterlog" most blocks with non-water fluids
        +Mod.wolvesWithArmor     // Adds armor for your (overly vulnerable) wolves
        +Mod.woodcutter          { common.validMcVersions = setOf("1.16.1") }
                                 // Like the Stonecutter, but for wood!

        withTypeClass(Direct::class) {  }.list {
            // Pouches that can store farmables and plant / feed in a 3x3
            +"pocketbags" { url = "https://github.com/copygirl/PocketBags/releases/download/v1.1.0-rc.1/PocketBags-1.16.3-1.1.0-rc.1.jar" }
        }

        // Technology
        +Mod.astromineMain // Space!
        +Mod.techreborn    // IndustrialCraft inspired technology mod

        // SERVER OPTIONAL MODS
        group {
            side = Side.SERVER
            optional { selected = false }
        }.list {
            // +Mod.btfuContinuousRsyncIncrementalBackup { name = "BTFU"; description = "Best backup mod in existence! (setup required)" }
        }

        // CLIENT MODS
        group {
            side = Side.CLIENT
        }.list {
            // CLIENT REQUIRED MODS
            +Mod.modmenu
            +Mod.betterEnchantedBooks // Unique looks for different enchantment books
            +Mod.chatHeads            // See players' heads next to their chat messages
            +Mod.clickthrough         // Click through signs and item frames on containers
            +Mod.controllingForFabric // Improves controls with search, showing conflicts
            +Mod.illuminations        // Adds pretty-looking glowing parties
            +Mod.lightOverlay         // Show blocks mobs can spawn by pressing F7
            +Mod.voxelmap             // Minimap, world map and waypoints

            // CLIENT RECOMMENDED MODS
            group {
                optional { selected = true }
            }.list {
                +Mod.dynamicSoundFilters { description = "Affects how sounds are played depending on location" }
                +Mod.itemScroller        { description = "Use scroll wheel and other shortcuts to move items" }
                +Mod.notEnoughCrashes    { description = "Keep playing on a crash & better crash reports" }
                +Mod.presenceFootsteps   { description = "Footstep and shuffling sounds depending on materials" }
                // TODO: Immersive Portals not supported (yet?)
                // +Mod.sodium              { description = "Render engine replacement (high FPS boost)" }
            }

            // CLIENT OPTIONAL MODS
            group {
                optional { selected = false }
            }.list {
                +Mod.dynamicFps { description = "Reduce FPS when window is in background" }
            }
        }
    }
}
