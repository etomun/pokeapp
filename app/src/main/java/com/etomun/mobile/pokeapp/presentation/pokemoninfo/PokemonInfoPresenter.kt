package com.etomun.mobile.pokeapp.presentation.pokemoninfo

import com.etomun.mobile.pokeapp.common.util.rx.RxScheduler
import com.etomun.mobile.pokeapp.domain.param.PokemonDetailParam
import com.etomun.mobile.pokeapp.domain.usecase.GetPokemonDetail
import com.etomun.mobile.pokeapp.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PokemonInfoPresenter<V : PokemonInfo.View>
@Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    scheduler: RxScheduler,
    private val getPokemonDetail: GetPokemonDetail,
) : BasePresenter<V>(compositeDisposable, scheduler),
    PokemonInfo.Presenter<V> {

    override fun getPokemonDetail(pokemonName: String, speciesName: String) {
        enqueue(getPokemonDetail.execute(PokemonDetailParam(pokemonName, speciesName))
            .compose(scheduler.observableIoUi())
            .doOnSubscribe { view.showMainProgressBar(true) }
            .doAfterTerminate { view.showMainProgressBar(false) }
            .subscribe({
                view.showDetail(it)
            }, {
                view.showError(it.toString())
            })
        )
    }
}