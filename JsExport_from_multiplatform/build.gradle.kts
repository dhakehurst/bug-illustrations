plugins {
    kotlin("multiplatform")
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm {
        compilations {

        }
    }
    js {
        binaries.library()
        generateTypeScriptDefinitions()
        compilerOptions {
            target.set("es2015")
        }
        nodejs {
        }
        browser {
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.ExperimentalStdlibApi")
        }
    }

}