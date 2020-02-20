plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

version = "1.0"

kotlin {
    sourceSets {
        commonMain {
            /** Kotlin <main> sourceSet */
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
//      commonTest { /** Kotlin <test> sourceSet */ }
    }


    /** Kotlin/Android build target */
    android()
    sourceSets {
        getByName("androidMain") {
            /** Kotlin/Android <main> source-set */
            dependencies {
                implementation(kotlin("stdlib-jdk7"))
            }

            //TODO temporary workaround, see KT-33809
            dependsOn(commonMain.get())
        }
//      getByName("androidTest")        { /** Kotlin/Android <unit-test> sourceSet */ }
//      getByName("androidAndroidTest") { /** Kotlin/Android <instrumented-test> sourceSet */ }
    }
    /** Android Gradle plugin */
    project.android {
        compileSdkVersion(29)
        buildToolsVersion("29.0.3")
        defaultConfig {
            minSdkVersion(4)
        }
        sourceSets.all {
            /** prefix every source-set root with "android" (ie. `main` -> `androidMain`) */
            val oldSourceSetRoot = name
            val newSourceSetRoot = File("src/android" + oldSourceSetRoot.capitalize())
            setRoot(newSourceSetRoot.path)

            /** allow source files in `kotlin` folders */
            java.srcDir(File(newSourceSetRoot, "kotlin"))
        }
    }
}
