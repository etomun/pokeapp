package com.etomun.mobile.pokeapp.presentation.pokemoninfo

import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.presentation.base.Presentation


interface PokemonInfo {
    interface View : Presentation.View {
        fun showDetail(detail: PokemonDetail)
    }

    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun getPokemonDetail(pokemonName: String, speciesName: String)
    }
}