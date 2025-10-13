plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.9.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.2.20"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google() // for compose
}

kotlin {
    js {
        binaries.executable()
        browser()
    }
    wasmJs {
        binaries.executable()
        browser()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-js:2025.10.7")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-browser:2025.10.7")
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material3)
            }
        }
        wasmJsMain {
            dependencies {

            }
        }
    }
}

dependencies {
    "commonTestImplementation"(kotlin("test"))
    "commonTestImplementation"(kotlin("test-annotations-common"))
}