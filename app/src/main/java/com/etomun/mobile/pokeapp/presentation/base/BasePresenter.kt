package com.etomun.mobile.pokeapp.presentation.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.etomun.mobile.pokeapp.common.util.rx.RxScheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : Presentation.View> internal constructor(
    private val compositeDisposable: CompositeDisposable,
    protected val scheduler: RxScheduler,
) : Presentation.Presenter<V>, LifecycleObserver {

    protected lateinit var view: V
    private var viewLifecycle: Lifecycle? = null
    override fun enqueue(disposable: Disposable) {
        this.compositeDisposable.add(disposable)
    }

    override fun attachView(view: V, lifecycle: Lifecycle) {
        this.view = view
        viewLifecycle = lifecycle
        viewLifecycle!!.addObserver(this)
        view.onPresenterAttached()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detachView() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
        viewLifecycle!!.removeObserver(this)
        viewLifecycle = null
    }

    private fun subscribeHttpEvent() {

    }
}
