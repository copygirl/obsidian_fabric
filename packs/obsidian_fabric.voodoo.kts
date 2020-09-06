title     = "obsidian 1.16 Fabric Modpack"
authors   = listOf("copygirl")
version   = "0.0.1"
icon      = rootFolder.resolve("icon.png")

mcVersion = "1.16.2"
modloader { fabric(Fabric.intermediary.v_1_16_2) }

pack {
    multimc {
        selfupdateUrl = "https://meowface.org/copygirl/obsidian_fabric/obsidian_fabric.json"
    }
}

root<Curse> {
    releaseTypes = setOf(FileType.Release, FileType.Beta, FileType.Alpha)

    // COMMON MODS
    it.list {
        common.validMcVersions   = setOf("1.16", "1.16.1")
        common.invalidMcVersions = setOf("Forge")

        // Libraries
        // TODO: Dependencies currently don't inherit validMcVersions. (Fixed in Voodoo 0.5.20.)
        // +Mod.cotton
        // +Mod.cottonResources
        +Mod.fabricLanguageKotlin

        // Optimization and Fixes
        +Mod.lithium  // General-purpose server optimization
        // TODO: +Mod.phosphor // Optimize the lighting engine

        // Tweaks and Utilities
        +Mod.appleskin              // Displays hunger/saturation information
        +Mod.darkLoadingScreen      // Red is dead!
        +Mod.roughlyEnoughItems     // Like JEI, displays recipes and uses
        +Mod.roughlyEnoughResources // Like JER, displays block and mob drops
        +Mod.shulkerboxtooltip      // Show shulker box contents when hovering over them

        // Gameplay Changes
        +Mod.anvilFix              // Removes the "Too Expensive" limit
        +Mod.chainsLink            // Pistons move connected chain blocks
        +Mod.easiervillagertrading // Trades are only one click away
        +Mod.fabricPassableLeaves  // No more jumping on trees!
        +Mod.fairenchanting        // Pay fairly in XP, rather than levels
        +Mod.grindEnchantments     // Use Grindstone to remove enchantments
        +Mod.stackablepotions      // Stack potions up to 16
        +Mod.suitablyStackableStew // Stews stack up to 16

        // ------------------
        // == CONTENT MODS ==
        // ------------------

        // World Generation
        +Mod.endRebellion               { common.validMcVersions = setOf("1.16.2") }
                                        // Content for the End
        // TODO: +Mod.heartOfTheMachine          // Dimension of abandoned machineries
        +Mod.ohTheBiomesYoullGoFabric   // Over 70 varied biomes
        +Mod.repurposedStructuresFabric // More structures and variants
        // TODO: +Mod.theBumblezoneFabric        // Dimension full of beeeeeees!

        // Decoration
        +Mod.adorn                     // Decorate your home!
        +Mod.bambooTweaks              // Bamboo building blocks
        +Mod.bedspreadsFabric          // Banners on beds
        +Mod.colorfulCut               // Slabs, stairs and walls made of concrete and terracotta
        +Mod.modernGlassDoors          // Adds glass door variants of Vanilla doors
        +Mod.ohHowTheCraftingHasTabled // Crafting Tables made of all the woods
        +Mod.woodsPlus                 // Additional wooden planks variants

        // Various
        // TODO: +Mod.antiqueAtlas           // Map mod in an item
        +Mod.aquarius               // Expanding on Aquatic Update content
        +Mod.campanion              // Camping companion mod adding various things
        +Mod.doubleJumpMod          // Enchantment (level I to III) that adds double-jumps
        +Mod.ducts                  // Expanding on Hoppers
        +Mod.immersivePortalsMod    // See-through portals and seamless travel
        +Mod.linkedStorage          // Basically Ender Storage
        +Mod.modularItemFrameFabric // (Item) frames that can do just about anything
        +Mod.netheriteHorseArmor    // Upgrade diamond horse armor to netherite tier
        +Mod.respawnablePets        // Item that allows your pets to respawn when sleeping
        +Mod.rswires                // RedPower2-like redstones wires and bundled cables
        +Mod.sandwichable           // Make custom sandwiches with many ingredients
        +Mod.theParakeetMod         // More birbs!
        +Mod.towelette              // "Waterlog" most blocks with non-water fluids
        +Mod.wolvesWithArmor        // Adds armor for your (overly vulnerable) wolves
        +Mod.woodcutter             // Like the Stonecutter, but for wood!

        // Technology
        // TODO: +Mod.astromineMain        // Space! (Not compatible with Immersive Portals)
        // TODO: These mods (including Lacrimis) require Cotton Resources.
        // +Mod.biomechanics         // Meat Machines
        // +Mod.mechanizedSteamPower // Basically Flaxbeard's Steam Power

        // Magic
        // TODO: +Mod.lacrimis // Powered by Crying Obsidian

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

            // CLIENT RECOMMENDED MODS
            group {
                optional { selected = true }
            }.list {
                +Mod.controllingForFabric { description = "Improves controls with search, showing conflicts" }
                +Mod.betterEnchantedBooks { description = "Unique looks for different enchantment books" }
                // +Mod.sodium               { description = "Render engine replacement (high FPS boost)" }
            }

            // CLIENT OPTIONAL MODS
            group {
                optional { selected = false }
            }.list {
                +Mod.dynamicSoundFilters { description = "Affects how sounds are played depending on location" }
                +Mod.itemScroller        { description = "Use scroll wheel and other shortcuts to move items" }
                +Mod.presenceFootsteps   { description = "Footstep and shuffling sounds depending on materials" }
            }
        }
    }
}
