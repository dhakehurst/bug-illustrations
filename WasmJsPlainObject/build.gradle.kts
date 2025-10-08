plugins {
    kotlin("multiplatform")
    kotlin("plugin.js-plain-objects") version "2.2.0"
}

kotlin {
    wasmJs {
        binaries.executable()
        browser()
    }

    sourceSets {
        wasmJsMain {
            dependencies {
                //implementation("org.jetbrains.kotlin-wrappers:kotlin-js:2025.9.8")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-browser:2025.9.8")
            }
        }
    }
}

dependencies {
    "commonTestImplementation"(kotlin("test"))
    "commonTestImplementation"(kotlin("test-annotations-common"))
}