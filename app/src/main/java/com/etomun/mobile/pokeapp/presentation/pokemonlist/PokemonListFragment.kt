package com.etomun.mobile.pokeapp.presentation.pokemonlist

import android.graphics.drawable.ClipDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.etomun.mobile.pokeapp.databinding.FragmentPokemonListBinding
import com.etomun.mobile.pokeapp.domain.result.PokemonSum
import com.etomun.mobile.pokeapp.presentation.adapter.PokemonAdapter
import com.etomun.mobile.pokeapp.presentation.base.BaseFragment
import timber.log.Timber
import javax.inject.Inject

class PokemonListFragment : BaseFragment<FragmentPokemonListBinding>(), PokemonList.View {
    @Inject
    lateinit var presenter: PokemonList.Presenter<PokemonList.View>

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonListBinding
        get() = FragmentPokemonListBinding::inflate

    override fun setupPresenter() {
        presenter.attachView(this, this.lifecycle)
    }

    override fun showPokemonList(items: List<PokemonSum>) {
        val adapter = PokemonAdapter(items.toMutableList()) {
            findNavController().navigate(PokemonListFragmentDirections.toPokemonInfo(it))
        }
        binding.rvItems.adapter = adapter
    }

    override fun onPresenterAttached() {
        val decor = DividerItemDecoration(requireContext(), ClipDrawable.HORIZONTAL)
        binding.rvItems.addItemDecoration(decor)
        presenter.getPokemonList()
    }

    override fun showMainProgressBar(show: Boolean) {
        binding.shimmerContainer.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        Timber.e(message)
    }

}
