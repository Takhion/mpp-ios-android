plugins {
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
}
