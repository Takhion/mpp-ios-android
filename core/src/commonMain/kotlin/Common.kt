package com.jetbrains.handson.mpp

expect val platformName: String
expect val platformVersion: String

fun createApplicationScreenMessage() =
    "Kotlin rocks on $platformName $platformVersion!"
