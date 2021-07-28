package com.etomun.mobile.pokeapp.common.di.module.util

import com.etomun.mobile.pokeapp.common.di.scope.ApplicationScope
import com.etomun.mobile.pokeapp.common.util.framework.DeviceUtil
import com.etomun.mobile.pokeapp.common.util.framework.DeviceUtilFactory
import com.etomun.mobile.pokeapp.common.util.helper.DataConverter
import com.etomun.mobile.pokeapp.common.util.helper.DataConverterFactory
import com.etomun.mobile.pokeapp.common.util.rx.RxScheduler
import com.etomun.mobile.pokeapp.common.util.rx.RxSchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
internal abstract class UtilModule {
    @ApplicationScope
    @Binds
    abstract fun dataConverter(dataConverterFactory: DataConverterFactory): DataConverter

    @ApplicationScope
    @Binds
    abstract fun rxScheduler(rxSchedulerProvider: RxSchedulerProvider): RxScheduler

    @ApplicationScope
    @Binds
    abstract fun deviceUtil(deviceUtilFactory: DeviceUtilFactory): DeviceUtil

    companion object {
        @Provides
        fun compositeDisposable(): CompositeDisposable = CompositeDisposable()

    }
}