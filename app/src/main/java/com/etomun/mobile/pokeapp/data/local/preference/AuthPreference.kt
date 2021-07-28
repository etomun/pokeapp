package com.etomun.mobile.pokeapp.data.local.preference

import android.content.Context
import com.etomun.mobile.pokeapp.common.di.qualifier.android.ApplicationContext
import com.etomun.mobile.pokeapp.common.di.scope.ApplicationScope
import com.etomun.mobile.pokeapp.data.local.preference.AppPreference.AuthPref
import javax.inject.Inject

@ApplicationScope
class AuthPreference @Inject internal constructor(@ApplicationContext context: Context) :
    AppPreference(context), AuthPref {

    override fun rememberEmail(email: String) {
        set(REMEMBERED_EMAIL, email)
    }

    override fun getRememberEmail(): String {
        return get(REMEMBERED_EMAIL, "")
    }

    override fun clearRememberedEmail() {
        set(REMEMBERED_EMAIL, "")
    }

    companion object {
        private const val REMEMBERED_EMAIL = "dkRaO3T1Hc8ykRtLNy0z50JBxtAqhFqC"
    }
}