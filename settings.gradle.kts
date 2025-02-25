import java.util.Locale

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
        maven("https://repo.jpenilla.xyz/snapshots")
    }
}

val forkName = "PaperStraw"
val forkNameLowercase = forkName.toLowerCase(Locale.ENGLISH)

rootProject.name = forkNameLowercase

setupSubproject("$forkNameLowercase-api") {
    projectDir = File("$forkName-API")
    buildFileName = "../subprojects/api.gradle.kts"
}
setupSubproject("$forkNameLowercase-server") {
    projectDir = File("$forkName-Server")
    buildFileName = "../subprojects/server.gradle.kts"
}

inline fun setupSubproject(name: String, block: ProjectDescriptor.() -> Unit) {
    include(name)
    project(":$name").apply(block)
}
