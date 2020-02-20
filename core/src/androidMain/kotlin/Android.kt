package com.jetbrains.handson.mpp

import android.os.Build

private val baseOS = when {
    Build.VERSION.SDK_INT >= 23 -> Build.VERSION.BASE_OS?.ifEmpty { null }
    else -> null
}

actual val platformName =
    baseOS ?: "Android"

actual val platformVersion =
    Build.VERSION.RELEASE ?: Build.VERSION.SDK_INT.toString()
