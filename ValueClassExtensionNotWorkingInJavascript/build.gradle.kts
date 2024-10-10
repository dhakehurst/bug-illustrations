plugins {
    alias(libs.plugins.exportPublic)
}

repositories {
    gradlePluginPortal()
}

kotlin {

    jvm {
    }

    js {
        compilerOptions {
            target.set("es2015")
        }
        nodejs()
        binaries.library()
        generateTypeScriptDefinitions()
    }

    applyDefaultHierarchyTemplate()
    sourceSets {
        all {
            //languageSettings.optIn("kotlin.ExperimentalStdlibApi")
        }
    }
}