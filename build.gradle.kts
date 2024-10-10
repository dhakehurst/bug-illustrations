plugins {
    alias(libs.plugins.kotlin) apply false
}

allprojects {
    repositories {
        mavenCentral()
    }

    group = rootProject.name
    version = rootProject.libs.versions.project.get()

    project.layout.buildDirectory = File(rootProject.projectDir, ".gradle-build/${project.name}")
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.multiplatform")

    dependencies {
        "commonTestImplementation"(kotlin("test"))
        "commonTestImplementation"(kotlin("test-annotations-common"))
    }
}