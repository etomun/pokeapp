package com.etomun.mobile.pokeapp.presentation.pokemonevolutions

import com.etomun.mobile.pokeapp.domain.result.Species
import com.etomun.mobile.pokeapp.presentation.base.Presentation


interface PokemonEvolutions {
    interface View : Presentation.View {
        fun fetchSpeciesSums(spSums: List<Species>)
    }

    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun getSpeciesSums(names: List<String>)
    }
}