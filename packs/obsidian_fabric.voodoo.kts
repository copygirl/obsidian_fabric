title     = "obsidian 1.16 Fabric Modpack"
authors   = listOf("copygirl")
version   = "0.2.0"
icon      = rootFolder.resolve("icon.png")

mcVersion = "1.16.3"
modloader { fabric(Fabric.intermediary.v_1_16_3) }

pack {
    multimc {
        selfupdateUrl = "https://meowface.org/copygirl/obsidian_fabric/obsidian_fabric.json"
    }
}

root<Curse> {
    releaseTypes = setOf(FileType.Release, FileType.Beta, FileType.Alpha)

    // COMMON MODS
    it.list {
        // Due to 1.16.3 not being available in Twitch Launcher's internal API, we
        // need to specify some file IDs manually to grab the newest version of mods.
        common.validMcVersions   = setOf("1.16.1", "1.16.2", "1.16.3")
        common.invalidMcVersions = setOf("Forge")

        // Libraries
        +Mod.fabricApi { fileID = FileID(3066731) }

        // Optimization and Fixes
        +Mod.lithium { fileID = FileID(3063230) } // General-purpose server optimization
        // TODO: +Mod.phosphor // Optimize the lighting engine

        // Tweaks and Utilities
        +Mod.appleskin              // Displays hunger/saturation information
        +Mod.darkLoadingScreen      // Red is dead!
        +Mod.hwyla                  // Shows what you're looking at
        +Mod.roughlyEnoughItems     // Like JEI, displays recipes and uses
        +Mod.roughlyEnoughResources // Like JER, displays block and mob drops
        +Mod.shulkerboxtooltip      { fileID = FileID(3061113) } // Show shulker box contents when hovering over them

        // Gameplay Changes
        +Mod.anvilFix              // Removes the "Too Expensive" limit
        // TODO: Not compatible with 1.16.3
        // +Mod.chainsLink            // Pistons move connected chain blocks
        +Mod.editSign              { fileID = FileID(3053802) } // Allow editing signs in-place
        +Mod.fairenchanting        // Pay fairly in XP, rather than levels
        +Mod.grindEnchantments     { fileID = FileID(3063879) } // Use Grindstone to remove enchantments
        +Mod.stackablepotions      // Stack potions up to 16
        +Mod.suitablyStackableStew // Stews stack up to 16

        // ------------------
        // == CONTENT MODS ==
        // ------------------

        // World Generation
        +Mod.endRebellion               { common.invalidMcVersions = setOf("1.16.1") } // More content for the End
        +Mod.heartOfTheMachine          // Dimension of abandoned machineries
        +Mod.ohTheBiomesYoullGoFabric   // Over 70 varied biomes
        +Mod.repurposedStructuresFabric // More structures and variants
        +Mod.theBumblezoneFabric        // Dimension full of beeeeeees!

        // Decoration
        +Mod.adorn                     { fileID = FileID(3063751) } // Decorate your home!
        +Mod.bambooTweaksFabric        // Bamboo building blocks
        +Mod.bedspreadsFabric          { fileID = FileID(3068187) } // Banners on beds
        +Mod.colorfulCut               // Slabs, stairs and walls made of concrete and terracotta
        +Mod.modernGlassDoors          // Adds glass door variants of Vanilla doors
        +Mod.ohHowTheCraftingHasTabled // Crafting Tables made of all the woods
        +Mod.woodsPlus                 // Additional wooden planks variants

        // Various
        +Mod.aquarius               // Expanding on Aquatic Update content
        +Mod.campanion              // Camping companion mod adding various things
        +Mod.doubleJumpMod          // Enchantment (level I to III) that adds double-jumps
        // TODO: Needs to be updated to newer Minecraft
        // +Mod.ducts                  // Expanding on Hoppers
        +Mod.immersivePortalsMod    { fileID = FileID(3063779) } // See-through portals and seamless travel
        +Mod.linkedStorage          { fileID = FileID(3061753) } // Basically Ender Storage
        +Mod.netheriteHorseArmor    // Upgrade diamond horse armor to netherite tier
        +Mod.respawnablePets        { fileID = FileID(3057419) } // Item that allows your pets to respawn when sleeping
        +Mod.rswires                // RedPower2-like redstones wires and bundled cables
        +Mod.sandwichable           // Make custom sandwiches with many ingredients
        +Mod.theParakeetMod         // More birbs!
        // TODO: https://github.com/Virtuoel/Towelette/issues/33
        // +Mod.towelette              // "Waterlog" most blocks with non-water fluids
        +Mod.wolvesWithArmor        // Adds armor for your (overly vulnerable) wolves
        +Mod.woodcutter             // Like the Stonecutter, but for wood!

        // Technology
        +Mod.astromineMain        // Space!
        +Mod.reborncore           { fileID = FileID(3060564) } // Library mod for Tech Reborn
        +Mod.techreborn           { fileID = FileID(3060565) } // IndustrialCraft inspired technology mod

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
            +Mod.betterEnchantedBooks { common.invalidMcVersions = setOf("1.16.1") } // Unique looks for different enchantment books
            +Mod.chatHeads            // See players' heads next to their chat messages
            +Mod.controllingForFabric // Improves controls with search, showing conflicts
            +Mod.illuminations        { fileID = FileID(3062304) } // Adds pretty-looking glowing parties
            +Mod.lightOverlay         // Show blocks mobs can spawn by pressing F7
            +Mod.voxelmap             { fileID = FileID(3058801) } // Minimap, world map and waypoints

            // CLIENT RECOMMENDED MODS
            group {
                optional { selected = true }
            }.list {
                +Mod.dynamicSoundFilters { description = "Affects how sounds are played depending on location" }
                +Mod.itemScroller        { description = "Use scroll wheel and other shortcuts to move items" }
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
