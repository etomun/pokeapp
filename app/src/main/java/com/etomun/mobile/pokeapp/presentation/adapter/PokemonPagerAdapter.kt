package com.etomun.mobile.pokeapp.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.presentation.pokemonevolutions.EvolutionsFragment
import com.etomun.mobile.pokeapp.presentation.pokemonstats.StatsFragment

class PokemonPagerAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle,
    private val count: Int,
    private val pokemonDetail: PokemonDetail
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = count

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StatsFragment.newInstance(pokemonDetail)
            1 -> EvolutionsFragment.newInstance(pokemonDetail)
            else -> StatsFragment()
        }
    }
}