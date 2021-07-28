package com.etomun.mobile.pokeapp.presentation.pokemonlist

import com.etomun.mobile.pokeapp.common.util.rx.RxScheduler
import com.etomun.mobile.pokeapp.domain.usecase.GetPokemonList
import com.etomun.mobile.pokeapp.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PokemonListPresenter<V : PokemonList.View>
@Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    scheduler: RxScheduler,
    private val getPokemonList: GetPokemonList
) : BasePresenter<V>(compositeDisposable, scheduler),
    PokemonList.Presenter<V> {
    override fun getPokemonList() {
        enqueue(getPokemonList.execute(null)
            .compose(scheduler.singleIoUi())
            .doOnSubscribe { view.showMainProgressBar(true) }
            .doAfterTerminate { view.showMainProgressBar(false) }
            .subscribe({
                view.showPokemonList(it)
            }, {
                view.showError(it.toString())
            })
        )
    }
}