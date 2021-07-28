package com.etomun.mobile.pokeapp.common.di.module.data

import com.etomun.mobile.pokeapp.common.di.qualifier.data.LocalData
import com.etomun.mobile.pokeapp.data.local.source.PokemonLocalSource
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class LocalDataSourceModule {
    @Binds
    @LocalData
    abstract fun pokemonDataSource(pokemonLocalSource: PokemonLocalSource): PokemonRepository.DataSource

}