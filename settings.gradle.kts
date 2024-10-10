println("===============================================")
println("Gradle: ${GradleVersion.current()}")
println("JVM: ${org.gradle.internal.jvm.Jvm.current()} '${org.gradle.internal.jvm.Jvm.current().javaHome}'")
println("===============================================")

rootProject.name = file(".").name

fileTree(".") {
    include ("**/build.gradle")
    include ("**/build.gradle.kts")
    exclude ("build.gradle") // Exclude the root _build file.
    exclude ("build.gradle.kts") // Exclude the root _build file.
}.forEach {
    val prj = it.parentFile.name
    println( "including $prj at "+relativePath(it.parent))
    include(prj)
    project(":$prj").projectDir = File(relativePath(it.parent))
}