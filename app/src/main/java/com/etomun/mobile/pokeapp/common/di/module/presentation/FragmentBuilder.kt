package com.etomun.mobile.pokeapp.common.di.module.presentation

import com.etomun.mobile.pokeapp.presentation.pokemonevolutions.EvolutionsFragment
import com.etomun.mobile.pokeapp.presentation.pokemonevolutions.PokemonEvolutions
import com.etomun.mobile.pokeapp.presentation.pokemonevolutions.PokemonEvolutionsPresenter
import com.etomun.mobile.pokeapp.presentation.pokemoninfo.PokemonInfo
import com.etomun.mobile.pokeapp.presentation.pokemoninfo.PokemonInfoFragment
import com.etomun.mobile.pokeapp.presentation.pokemoninfo.PokemonInfoPresenter
import com.etomun.mobile.pokeapp.presentation.pokemonlist.PokemonList
import com.etomun.mobile.pokeapp.presentation.pokemonlist.PokemonListFragment
import com.etomun.mobile.pokeapp.presentation.pokemonlist.PokemonListPresenter
import com.etomun.mobile.pokeapp.presentation.pokemonstats.StatsFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract fun pokemonListFragment(): PokemonListFragment

    @Binds
    abstract fun pokemonListPresenter(pokemonListPresenter: PokemonListPresenter<PokemonList.View>): PokemonList.Presenter<PokemonList.View>

    @ContributesAndroidInjector
    abstract fun pokemonDetailFragment(): PokemonInfoFragment

    @Binds
    abstract fun pokemonDetailPresenter(pokemonInfoPresenter: PokemonInfoPresenter<PokemonInfo.View>): PokemonInfo.Presenter<PokemonInfo.View>

    @ContributesAndroidInjector
    abstract fun statsFragment(): StatsFragment

    @ContributesAndroidInjector
    abstract fun evolutionsFragment(): EvolutionsFragment

    @Binds
    abstract fun evolutionsPresenter(pokemonEvolutionsPresenter: PokemonEvolutionsPresenter<PokemonEvolutions.View>): PokemonEvolutions.Presenter<PokemonEvolutions.View>


}
