package com.etomun.mobile.pokeapp.common.di.component

import android.app.Application
import com.etomun.mobile.pokeapp.PokeApp
import com.etomun.mobile.pokeapp.common.di.module.AppModule
import com.etomun.mobile.pokeapp.common.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<PokeApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}