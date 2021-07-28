package com.etomun.mobile.pokeapp.presentation.base

import androidx.lifecycle.Lifecycle
import io.reactivex.disposables.Disposable

interface Presentation {
    interface View {
        fun onPresenterAttached()
        fun showMainProgressBar(show: Boolean)
        fun showError(message: String?)
    }

    interface Presenter<V : View> {
        fun attachView(view: V, lifecycle: Lifecycle)
        fun detachView()
        fun enqueue(disposable: Disposable)
    }
}