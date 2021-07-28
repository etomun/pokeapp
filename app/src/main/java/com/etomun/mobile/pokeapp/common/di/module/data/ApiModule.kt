package com.etomun.mobile.pokeapp.common.di.module.data


import com.etomun.mobile.pokeapp.common.di.scope.ApplicationScope
import com.etomun.mobile.pokeapp.data.remote.api.PokemonApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {
    @ApplicationScope
    @Provides
    fun pokemonApi(retrofit: Retrofit): PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }

}