plugins {
    kotlin("multiplatform")
    //alias(libs.plugins.exportPublic)
}


repositories {
    gradlePluginPortal()
    mavenCentral()
}

kotlin {

    jvm {}

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
        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}
