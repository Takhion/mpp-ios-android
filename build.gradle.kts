// Top-level build file where you can add configuration options common to all sub-projects/modules.

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

/**
 * Any plugin used by more than one child project must be pre-loaded on the [buildscript] classpath,
 * or multiple instances of the same plugin risk conflicting with each other (even if identical)!
 */
plugins {
    /** pre-load the Android Gradle plugin (any sub-plugin will do) */
    id("com.android.library") apply false
    /** pre-load the Kotlin Gradle plugin (any sub-plugin will do) */
    kotlin("multiplatform") apply false
}

allprojects {
    group = "com.jetbrains.handson.mpp"

    tasks.withType(Test::class) {
        /** disable skipping up-to-date tests tasks */
        outputs.upToDateWhen { false }

        /** enable logging of tests lifecycle/output */
        testLogging {
            events(*enumValues<TestLogEvent>())
            showExceptions = true
            showCauses = true
            showStackTraces = true
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
}
