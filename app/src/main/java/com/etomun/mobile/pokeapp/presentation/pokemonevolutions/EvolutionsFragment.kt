package com.etomun.mobile.pokeapp.presentation.pokemonevolutions

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.etomun.mobile.pokeapp.databinding.FragmentEvolutionsBinding
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.domain.result.Species
import com.etomun.mobile.pokeapp.presentation.adapter.EvolutionAdapter
import com.etomun.mobile.pokeapp.presentation.base.BaseFragment
import javax.inject.Inject

class EvolutionsFragment : BaseFragment<FragmentEvolutionsBinding>(), PokemonEvolutions.View {
    @Inject
    lateinit var presenter: PokemonEvolutions.Presenter<PokemonEvolutions.View>
    private lateinit var detail: PokemonDetail

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentEvolutionsBinding
        get() = FragmentEvolutionsBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { detail = it.getParcelable(parcelPokemon)!! }
    }

    override fun setupPresenter() {
        presenter.attachView(this, this.lifecycle)
    }

    override fun fetchSpeciesSums(spSums: List<Species>) {
        detail.evolutions.mapIndexed { i, evo ->
            val from = spSums.find { it.name == evo.from.name }
            if (from != null) {
                detail.evolutions[i].from.sprite = from.sprite
            }

            val to = spSums.find { it.name == evo.to.name }
            if (to != null) {
                detail.evolutions[i].to.sprite = to.sprite
            }
        }

        val decor = DividerItemDecoration(requireContext(), ClipDrawable.HORIZONTAL)
        binding.evolutions.addItemDecoration(decor)
        binding.evolutions.adapter = EvolutionAdapter(detail.evolutions.toMutableList())
    }

    override fun onPresenterAttached() {
        val names: ArrayList<String> = arrayListOf()
        detail.evolutions.map {
            names.add(it.from.name)
            names.add(it.to.name)
        }
        names.distinct()
        presenter.getSpeciesSums(names)
    }

    override fun showMainProgressBar(show: Boolean) {
        binding.shimmerContainer.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val parcelPokemon = "parcelPokemon"

        @JvmStatic
        fun newInstance(pokemonDetail: PokemonDetail) =
            EvolutionsFragment().apply {
                arguments = Bundle().apply { putParcelable(parcelPokemon, pokemonDetail) }
            }
    }

}