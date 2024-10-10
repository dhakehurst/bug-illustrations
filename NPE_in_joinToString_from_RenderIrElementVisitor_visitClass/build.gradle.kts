

kotlin {

    js(){//"js", IR) {
        //binaries.library()
        nodejs()
    }

}

dependencies {
    "commonTestImplementation"(kotlin("test"))
    "commonTestImplementation"(kotlin("test-annotations-common"))
}