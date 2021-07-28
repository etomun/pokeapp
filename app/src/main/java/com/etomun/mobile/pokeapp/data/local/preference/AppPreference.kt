package com.etomun.mobile.pokeapp.data.local.preference

import android.content.Context
import com.etomun.mobile.pokeapp.BuildConfig
import com.etomun.mobile.pokeapp.data.local.base.BasePreference

abstract class AppPreference protected constructor(context: Context) :
    BasePreference(context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)) {

    interface AuthPref {
        fun rememberEmail(email: String)
        fun getRememberEmail(): String
        fun clearRememberedEmail()
    }

    companion object {
        private const val PREF_NAME =
            "hm3WRzK4CUI2RmXo8dw3meo2JviUMH3A" + BuildConfig.FLAVOR + BuildConfig.BUILD_TYPE
    }
}