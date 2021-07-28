package com.etomun.mobile.pokeapp.presentation.pokemonevolutions

import com.etomun.mobile.pokeapp.common.util.rx.RxScheduler
import com.etomun.mobile.pokeapp.domain.usecase.GetSpeciesSumList
import com.etomun.mobile.pokeapp.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PokemonEvolutionsPresenter<V : PokemonEvolutions.View>
@Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    scheduler: RxScheduler,
    private val getSpeciesSumList: GetSpeciesSumList,
) : BasePresenter<V>(compositeDisposable, scheduler),
    PokemonEvolutions.Presenter<V> {

    override fun getSpeciesSums(names: List<String>) {
        enqueue(
            getSpeciesSumList.execute(names)
                .compose(scheduler.singleIoUi())
                .doOnSubscribe { view.showMainProgressBar(true) }
                .doAfterTerminate { view.showMainProgressBar(false) }
                .subscribe({
                    view.fetchSpeciesSums(it)
                }, {
                    view.showError(it.toString())
                })
        )
    }
}