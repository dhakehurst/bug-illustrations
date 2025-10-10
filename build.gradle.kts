plugins {
    //kotlin("multiplatform") version "2.1.21" apply false
    kotlin("multiplatform") version "2.2.20" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }


    project.layout.buildDirectory = File(rootProject.projectDir, ".gradle-build/${project.name}")
}
