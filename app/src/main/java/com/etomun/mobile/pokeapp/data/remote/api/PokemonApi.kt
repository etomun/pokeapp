/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.etomun.mobile.pokeapp.data.remote.api

import com.etomun.mobile.pokeapp.data.remote.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Observable<PokemonResponse>

    @GET("pokemon/{name}")
    fun getPokemonDetail(@Path("name") pokemonName: String): Observable<PokemonDetailResponse>

@GET("pokemon/{name}")
    fun getSpeciesSum(@Path("name") pokemonName: String): Observable<SpeciesSumResponse>

    @GET("pokemon-species/{name}")
    fun getSpeciesDetail(@Path("name") speciesName: String): Observable<SpeciesDetailResponse>

    @GET("ability/{name}")
    fun getAbilityDetail(@Path("name") abilityName: String): Observable<AbilityDetailResponse>

    @GET("type/{name}")
    fun getTypeDamages(@Path("name") typeName: String): Observable<TypeDamageResponse>

    @GET("evolution-chain/{id}")
    fun getEvolutionChain(@Path("id") evolutionChainId: Int): Observable<EvolutionChainResponse>

    @GET("type")
    fun getTypes(): Observable<TypesResponse>
}
