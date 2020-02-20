rootProject.name = "mpp-ios-android"
include(":core")
include(":app-android")

pluginManagement {
    /** default plugin versions */
    plugins {
        listOf(
            kotlin("multiplatform"),
            kotlin("android"),
            kotlin("android.extensions")
        ).forEach { it version "1.3.70-eap-184" }

        listOf(
            id("com.android.application"),
            id("com.android.library")
        ).forEach { it version "3.6.0-rc03" }
    }
    /** custom plugin repositories */
    repositories {
        maven("https://kotlin.bintray.com/kotlin-dev")
        maven("https://kotlin.bintray.com/kotlin-eap")
        maven("https://kotlin.bintray.com/kotlinx")
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
    }
    /** custom mapping from plugin id to module/artifact */
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.library"
                -> useModule("com.android.tools.build:gradle:${target.version ?: requested.version}")
            }
        }
    }
}

/** add the plugins repositories to every project */
gradle.beforeProject {
    settings.pluginManagement.repositories.all {
        project.repositories.add(this)
    }
}
