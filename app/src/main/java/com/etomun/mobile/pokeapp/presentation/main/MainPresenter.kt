package com.etomun.mobile.pokeapp.presentation.main

import com.etomun.mobile.pokeapp.common.util.rx.RxScheduler
import com.etomun.mobile.pokeapp.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : Main.View>
@Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    scheduler: RxScheduler
) : BasePresenter<V>(compositeDisposable, scheduler),
    Main.Presenter<V>