package com.etomun.mobile.pokeapp.common.di.module.receiver

import com.etomun.mobile.pokeapp.common.util.framework.ConnectivityReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BroadcastReceiverBuilder {
    @ContributesAndroidInjector
    abstract fun connectivityReceiver(): ConnectivityReceiver?
}