package com.etomun.mobile.pokeapp.common.di.module.presentation

import com.etomun.mobile.pokeapp.presentation.main.Main
import com.etomun.mobile.pokeapp.presentation.main.MainActivity
import com.etomun.mobile.pokeapp.presentation.main.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @Binds
    abstract fun mainPresenter(mainPresenter: MainPresenter<Main.View>): Main.Presenter<Main.View>
}