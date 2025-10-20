plugins {
    kotlin("multiplatform")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

kotlin {

    jvm {
    }

    js {
        compilerOptions {
            target.set("es2015")
        }
        nodejs()
        browser()
        binaries.library()
        generateTypeScriptDefinitions()
    }
    applyDefaultHierarchyTemplate()
}

dependencies {
    "commonTestImplementation"(kotlin("test"))
    "commonTestImplementation"(kotlin("test-annotations-common"))
}