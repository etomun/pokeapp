package com.etomun.mobile.pokeapp.presentation.pokemonevolutions

import com.etomun.mobile.pokeapp.domain.result.Variety
import com.etomun.mobile.pokeapp.presentation.base.Presentation


interface PokemonEvolutions {
    interface View : Presentation.View {
        fun showVarietySums(spSums: List<Variety>)
    }

    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun getVarietySums(names: List<String>)
    }
}