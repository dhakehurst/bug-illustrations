plugins {
    kotlin("multiplatform")
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
            languageSettings.optIn("kotlin.ExperimentalStdlibApi")
        }
    }
}

dependencies {
    "commonTestImplementation"(kotlin("test"))
    "commonTestImplementation"(kotlin("test-annotations-common"))
}