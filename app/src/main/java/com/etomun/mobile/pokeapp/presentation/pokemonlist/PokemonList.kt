package com.etomun.mobile.pokeapp.presentation.pokemonlist

import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.presentation.base.Presentation


interface PokemonList {
    interface View : Presentation.View {
        fun showPokemonList(items: List<PokemonSum>)
    }


    interface Presenter<V : View> : Presentation.Presenter<V> {
        fun getPokemonList()
    }
}