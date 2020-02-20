// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext["kotlin_version"] = "1.3.70-eap-184"
    repositories {
        google()
        jcenter()
        maven { url("https://dl.bintray.com/kotlin/kotlin-eap") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.0-rc03")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url("https://dl.bintray.com/kotlin/kotlin-eap") }
    }
}

task(type: Delete, "clean") {
    delete(rootProject.buildDir)
}
