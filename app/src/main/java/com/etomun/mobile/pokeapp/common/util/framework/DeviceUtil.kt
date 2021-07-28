package com.etomun.mobile.pokeapp.common.util.framework

import java.util.*

interface DeviceUtil {
    fun getConfigurationLocale(): Locale?
    fun isOnline(): Boolean
    fun isLocationEnabled(): Boolean
}