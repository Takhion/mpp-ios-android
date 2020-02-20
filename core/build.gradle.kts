plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("native.cocoapods")
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


    /** Kotlin/iOS build target */
    ios {
        //TODO temporary workaround, see KT-36804
        tasks.getByName("compileTestKotlin" + name.capitalize())
    }
    sourceSets {
//      getByName("iosMain")      { /** Kotlin/iOS <main> sourceSet */ }
//      getByName("iosTest")      { /** Kotlin/iOS <test> sourceSet */ }
//      getByName("iosArm64Main") { /** Kotlin/iOS/device <main> sourceSet */ }
//      getByName("iosArm64Test") { /** Kotlin/iOS/device <test> sourceSet */ }
//      getByName("iosX64Main")   { /** Kotlin/iOS/simulator <main> sourceSet */ }
//      getByName("iosX64Test")   { /** Kotlin/iOS/simulator <test> sourceSet */ }
    }
    cocoapods {
        /** Configure the following fields, as required by CocoaPods. */
        /** The version is obtained from Gradle [Project.getVersion]. */
        summary = "TODO(summary)"
        homepage = "TODO(homepage)"
    }
}
