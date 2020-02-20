// Top-level build file where you can add configuration options common to all sub-projects/modules.

import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

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
