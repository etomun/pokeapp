package com.etomun.mobile.pokeapp.common.di.module.data

import com.etomun.mobile.pokeapp.common.di.qualifier.data.RemoteData
import com.etomun.mobile.pokeapp.data.remote.source.PokemonRemoteSource
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class RemoteDataSourceModule {
    @Binds
    @RemoteData
    abstract fun pokemonDataSource(remoteAuthSource: PokemonRemoteSource): PokemonRepository.DataSource
}