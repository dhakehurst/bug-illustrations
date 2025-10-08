plugins {
    kotlin("multiplatform")
    id("net.akehurst.kotlin.gradle.plugin.exportPublic") version "2.1.21"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}
kotlin {

    jvm { }

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