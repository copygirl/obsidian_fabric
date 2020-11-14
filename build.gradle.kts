plugins {
    // kotlin("jvm") version "1.3.70" // automatically applied
    // idea // automatically applied
    id("voodoo") version "0.5.23-SNAPSHOT"
}

voodoo {
    addTask("build") { build() }
    addTask(name = "changelog") { changelog() }
    addTask(name = "pack_voodoo") { pack().voodoo() }
    addTask(name = "pack_mmc-voodoo") { pack().multimcVoodoo() }
    addTask(name = "pack_mmc-fat") { pack().multimcFat() }
    addTask(name = "pack_server") { pack().server() }
    addTask(name = "test_mmc") { test().multimc() }
    addTask(name = "pack_all") {
        pack().server()
        pack().voodoo()
        pack().multimcVoodoo()
        // pack().multimcFat()
    }

    generatedSourceShared { rootFolder -> rootFolder.resolve("src/main/kotlin") }
    generateFabric("Fabric", stable = true)
    generateCurseforgeMods("Mod", "1.16", "1.16.1", "1.16.2", categories = listOf("Fabric"))
}
