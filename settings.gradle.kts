rootProject.name = "mpp-ios-android"
include(":app-android")

pluginManagement {
    /** default plugin versions */
    plugins {
        listOf(
            kotlin("android"),
            kotlin("android.extensions")
        ).forEach { it version "1.3.70-eap-184" }

        listOf(
            id("com.android.application")
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
                "com.android.application"
                -> useModule("com.android.tools.build:gradle:${target.version ?: requested.version}")
            }
        }
    }
}
