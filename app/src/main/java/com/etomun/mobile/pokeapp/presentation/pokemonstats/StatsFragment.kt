package com.etomun.mobile.pokeapp.presentation.pokemonstats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etomun.mobile.pokeapp.databinding.FragmentStatsBinding
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.presentation.adapter.AbilityAdapter
import com.etomun.mobile.pokeapp.presentation.adapter.StatsAdapter
import com.etomun.mobile.pokeapp.presentation.adapter.WeaknessAdapter
import com.etomun.mobile.pokeapp.presentation.base.BaseFragment

class StatsFragment : BaseFragment<FragmentStatsBinding>() {
    private lateinit var detail: PokemonDetail

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStatsBinding
        get() = FragmentStatsBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { detail = it.getParcelable(parcelPokemon)!! }
    }

    override fun setupPresenter() {
        // no presenter, instead this is called after onViewCreated
        val statsAdapter = StatsAdapter(detail.stats.toMutableList())
        binding.stats.adapter = statsAdapter

        val weaknessAdapter = WeaknessAdapter(detail.weaknesses.toMutableList())
        val lm = GridLayoutManager(requireContext(), 3)
        binding.weaknesses.layoutManager = lm
        binding.weaknesses.adapter = weaknessAdapter

        val abilityAdapter = AbilityAdapter(detail.abilities.toMutableList())
        binding.abilities.adapter = abilityAdapter


        detail.eggGroups.map {
            val param = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            param.setMargins(4, 4, 4, 4)
            val tv = TextView(requireContext())
            tv.layoutParams = param
            tv.text = it
            binding.eggGroup.addView(tv)
        }

        "${detail.hatchSteps} Steps".also { binding.hatchSteps.text = it }
        "${detail.hatchCycles} Cycles".also { binding.hatchCycles.text = it }

        "${detail.hatchSteps} Steps".also { binding.hatchSteps.text = it }
        "${detail.hatchCycles} Cycles".also { binding.hatchCycles.text = it }

        "${detail.femalePercent}%".also { binding.female.text = it }
        "${detail.malePercent}%".also { binding.male.text = it }

        binding.habitat.text = detail.habitat
        binding.generation.text = detail.generation

        "${detail.captureRate}%".also { binding.captureRate.text = it }
        binding.progressCapture.progress = detail.captureRate

        Glide.with(this)
            .load(detail.sprite)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.normal)

        Glide.with(this)
            .load(detail.spriteShiny)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.shiny)
    }

    override fun onPresenterAttached() {

    }

    override fun showMainProgressBar(show: Boolean) {

    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val parcelPokemon = "parcelPokemon"

        @JvmStatic
        fun newInstance(pokemonDetail: PokemonDetail) =
            StatsFragment().apply {
                arguments = Bundle().apply { putParcelable(parcelPokemon, pokemonDetail) }
            }
    }

}