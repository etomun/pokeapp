package com.etomun.mobile.pokeapp.data.remote.mapper

import com.etomun.mobile.pokeapp.R
import com.etomun.mobile.pokeapp.common.util.helper.DataConverter
import com.etomun.mobile.pokeapp.data.base.DataMapper
import com.etomun.mobile.pokeapp.data.remote.response.*
import com.etomun.mobile.pokeapp.domain.result.*
import com.etomun.mobile.pokeapp.domain.result.Stat
import timber.log.Timber
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

class PokemonDetailResponseMapper @Inject internal constructor(private val converter: DataConverter) :
    DataMapper<PokemonDetailResponsesComposer, PokemonDetail> {

    override fun fromData(data: PokemonDetail): PokemonDetailResponsesComposer {
        throw UnsupportedOperationException()
    }

    override fun toData(source: PokemonDetailResponsesComposer): PokemonDetail {
        val resPokemon = source.pokemon
        val resSpecies = source.species
        val resAbilities = source.abilities
        val resTypeDamages = source.typeDamages
        val resEvolution = source.evolution
        val resTypes = source.types

        val types: ArrayList<Type> = arrayListOf()
        resPokemon.types?.map { types.add(generateType(it.type?.name.orEmpty())) }

        val stats: ArrayList<Stat> = arrayListOf()
        resPokemon.stats?.map { stats.add(Stat(it.stat?.name.orEmpty(), it.baseStat, it.effort)) }


        val eggGroups: ArrayList<String> = arrayListOf()
        resSpecies.eggGroups?.map {
            eggGroups.add(
                it.name.orEmpty().replaceFirstChar { g -> g.uppercaseChar() })
        }

        val fEntry = resSpecies.flavorTextEntries?.findLast { it.language?.name == "en" }
        val flavor = Flavor(fEntry?.flavorText.orEmpty(), fEntry?.language?.name.orEmpty())

        val hatchCycles = resSpecies.hatchCounter
        val hatchSteps = (255 * hatchCycles) + 1

        val femaleRatio = resSpecies.genderRate
        val maleRatio = 8 - femaleRatio
        val femalePercent = roundOffDecimal((femaleRatio * 100 / 8.0))
        val malePercent = roundOffDecimal((maleRatio * 100 / 8.0))

        val habitat = resSpecies.habitat?.name.orEmpty().replaceFirstChar { it.uppercaseChar() }
        var generation =
            resSpecies.generation?.name.orEmpty().replaceFirstChar { it.uppercaseChar() }
        val genId = generation.substringAfter("-").uppercase()
        generation = generation.replaceAfter("-", genId).replace("-", " ")

        val abilities: ArrayList<Ability> = generateAbilities(resPokemon.abilities, resAbilities)
        val weaknesses: ArrayList<Weakness> = generateWeaknesses(resTypeDamages, resTypes)
        val evolutions: ArrayList<Evolution> = generateEvolutions(resEvolution)

        val name = resPokemon.name.orEmpty()
        val default = resPokemon.sprites?.frontDefault.orEmpty()
        val shiny = resPokemon.sprites?.frontShiny.orEmpty()
        val official = resPokemon.sprites?.other?.officialArtwork?.frontDefault.orEmpty()
        val dreamWorld = resPokemon.sprites?.other?.dreamWorld?.frontDefault.orEmpty()
        val sprite = if (official.isEmpty()) default else official
        val spriteShiny =
            if (dreamWorld.isEmpty() || dreamWorld.contains(".svg")) sprite else dreamWorld
        val color = resSpecies.color?.name.orEmpty()

        return PokemonDetail(
            resPokemon.id,
            name,
            sprite,
            spriteShiny,
            types,
            stats,
            abilities,
            weaknesses,
            resSpecies.id,
            resSpecies.name.orEmpty(),
            color,
            flavor,
            eggGroups,
            hatchCycles,
            hatchSteps,
            femaleRatio,
            femalePercent,
            malePercent,
            habitat,
            generation,
            resSpecies.captureRate,
            evolutions
        )
    }

    private fun generateWeaknesses(
        typeDamages: List<TypeDamageResponse>,
        allTypes: TypesResponse
    ): ArrayList<Weakness> {
        val result: ArrayList<Weakness> = arrayListOf()

        // put all types with 1x damage multiplier
        allTypes.results?.mapIndexed { i, t ->
            val type = generateType(t.name.orEmpty())
            if (type.typeRes > 0) {
                result.add(i, Weakness(type, 1.0))
            }
        }

        // multiply with each damage multiplier
        typeDamages.map { response ->
            response.damageRelations?.doubleDamageFrom?.map { doubleType ->
                result.filter { it.type.name == doubleType.name }.map {
                    it.multiplier = it.multiplier * 2.0
                    result.set(result.indexOf(it), it)
                }
            }

            response.damageRelations?.halfDamageFrom?.map { halfType ->
                result.filter { it.type.name == halfType.name }.map {
                    it.multiplier = it.multiplier * 0.5
                    result.set(result.indexOf(it), it)
                }
            }

            response.damageRelations?.noDamageFrom?.map { zeroType ->
                result.filter { it.type.name == zeroType.name }.map {
                    it.multiplier = it.multiplier * 0.0
                    result.set(result.indexOf(it), it)
                }
            }
        }

        return result
    }

    private fun generateAbilities(
        pokeAbilities: List<AbilityResponse>?,
        resAbilities: List<AbilityDetailResponse>
    ): ArrayList<Ability> {
        val result: ArrayList<Ability> = arrayListOf()
        resAbilities.map { ability ->
            val effectEntry = ability.effectEntries?.findLast { it.language?.name == "en" }
            val effect = effectEntry?.effect.orEmpty()
            val shortEffect = effectEntry?.shortEffect.orEmpty()

            val flavor = ability.flavorTextEntries?.findLast { it.language?.name == "en" }
            val flavorText = flavor?.flavorText.orEmpty()

            val abilityResponse = pokeAbilities?.find { it.ability?.name == ability.name }
            val name = ability.name.orEmpty().replaceFirstChar { it.uppercaseChar() }
            val slot = abilityResponse?.slot ?: 0
            val isHidden = abilityResponse?.isHidden ?: false

            result.add(Ability(ability.id, name, effect, shortEffect, flavorText, slot, isHidden))
        }

        return result
    }

    private fun generateEvolutions(chain: EvolutionChainResponse): ArrayList<Evolution> {
        val result: ArrayList<Evolution> = arrayListOf()
        val chains: ArrayList<Chain> = arrayListOf()
        var c = chain.chain
        try {
            while (c != null) {
                chains.add(c)
                c = if (!c.evolvesTo.isNullOrEmpty()) {
                    c.evolvesTo?.get(0)
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            Timber.e(e.stackTraceToString())
        }

        chains.mapIndexed { i, ch ->
            if (i < chains.size - 1) {
                val nextChain = chains[i + 1]
                val from = Species(ch.species?.name.orEmpty(), "")
                val to = Species(nextChain.species?.name.orEmpty(), "")
                val detail = nextChain.evolutionDetails?.get(0)

                val evolution = Evolution(
                    from,
                    to,
                    detail?.trigger?.name.orEmpty(),
                    detail?.turnUpsideDown == true,
                    detail?.gender,
                    detail?.heldItem?.name,
                    detail?.item?.name,
                    detail?.knownMove?.name,
                    detail?.knownMoveType?.name,
                    detail?.location?.name,
                    detail?.minAffection,
                    detail?.minBeauty,
                    detail?.minHappiness,
                    detail?.minLevel,
                    detail?.needsOverworldRain == true,
                    detail?.partySpecies?.name,
                    detail?.partyType?.name,
                    detail?.relativePhysicalStats,
                    detail?.timeOfDay,
                    detail?.tradeSpecies?.name
                )
                result.add(evolution)
            }
        }

        return result
    }

    private fun generateType(typeName: String): Type {
        val result = Type(typeName, -1, -1)
        try {
            val tagRes = converter.getResourceId("${typeName}_tag", R.mipmap::class.java)
            val typeRes = converter.getResourceId("${typeName}_type", R.mipmap::class.java)
            result.tagRes = tagRes
            result.typeRes = typeRes
        } catch (e: Exception) {
            Timber.e(e.stackTraceToString())
        } finally {
            return result
        }
    }

    private fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toDouble()
    }


}