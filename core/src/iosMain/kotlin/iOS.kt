package com.jetbrains.handson.mpp

import platform.UIKit.UIDevice

actual val platformName
    get() = UIDevice.currentDevice.systemName

actual val platformVersion
    get() = UIDevice.currentDevice.systemVersion
