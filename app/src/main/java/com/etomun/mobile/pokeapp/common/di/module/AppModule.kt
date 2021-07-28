package com.etomun.mobile.pokeapp.common.di.module

import android.app.Application
import android.content.Context
import com.etomun.mobile.pokeapp.common.di.module.data.DataModule
import com.etomun.mobile.pokeapp.common.di.module.presentation.ActivityBuilder
import com.etomun.mobile.pokeapp.common.di.module.presentation.FragmentBuilder
import com.etomun.mobile.pokeapp.common.di.module.receiver.BroadcastReceiverBuilder
import com.etomun.mobile.pokeapp.common.di.module.service.ServiceBuilder
import com.etomun.mobile.pokeapp.common.di.module.util.UtilModule
import com.etomun.mobile.pokeapp.common.di.qualifier.android.ApplicationContext
import com.etomun.mobile.pokeapp.common.di.scope.ApplicationScope
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class,
        BroadcastReceiverBuilder::class,
        ServiceBuilder::class,
        UtilModule::class
    ]
)
abstract class AppModule {
    @ApplicationScope
    @ApplicationContext
    @Binds
    abstract fun context(application: Application): Context
}