package com.etomun.mobile.pokeapp.common.di.module.data

import com.etomun.mobile.pokeapp.data.repository.PokemonRepoFactory
import com.etomun.mobile.pokeapp.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module

@Module(includes = [LocalDataModule::class, RemoteDataModule::class])
internal abstract class DataModule {
    @Binds
    abstract fun pokemonRepository(pokemonRepoFactory: PokemonRepoFactory): PokemonRepository
}