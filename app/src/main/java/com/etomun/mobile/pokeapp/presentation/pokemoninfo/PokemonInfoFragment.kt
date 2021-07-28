package com.etomun.mobile.pokeapp.presentation.pokemoninfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etomun.mobile.pokeapp.R
import com.etomun.mobile.pokeapp.common.util.helper.DataConverter
import com.etomun.mobile.pokeapp.databinding.FragmentPokemonInfoBinding
import com.etomun.mobile.pokeapp.domain.result.PokemonDetail
import com.etomun.mobile.pokeapp.presentation.base.BaseFragment
import com.etomun.mobile.pokeapp.presentation.helper.AppBarScrollWatcher
import com.etomun.mobile.pokeapp.presentation.pokemonevolutions.EvolutionsFragment
import com.etomun.mobile.pokeapp.presentation.pokemonstats.StatsFragment
import timber.log.Timber
import javax.inject.Inject


class PokemonInfoFragment : BaseFragment<FragmentPokemonInfoBinding>(), PokemonInfo.View {
    @Inject
    lateinit var presenter: PokemonInfo.Presenter<PokemonInfo.View>
    private lateinit var appBarWatcher: AppBarScrollWatcher

    @Inject
    lateinit var converter: DataConverter

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonInfoBinding
        get() = FragmentPokemonInfoBinding::inflate

    override fun setupPresenter() {
        presenter.attachView(this, this.lifecycle)
    }

    override fun showDetail(detail: PokemonDetail) {
        val fragStats = StatsFragment.newInstance(detail)
        val fragEvolutions = EvolutionsFragment.newInstance(detail)
        binding.tabs.setOnCheckedChangeListener { _, i ->
            val transaction = childFragmentManager.beginTransaction()
            when (i) {
                R.id.bt_stats -> transaction.replace(R.id.fragment, fragStats)
                R.id.bt_evolutions -> transaction.replace(R.id.fragment, fragEvolutions)
            }
            transaction.commit()
        }
        binding.tabs.check(R.id.bt_stats)

        binding.toolbarLayout.setBackgroundResource(getBackground(detail.color))

        Glide.with(this)
            .load(detail.sprite)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivSprite)

        Glide.with(this)
            .load(detail.types[0].tagRes)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.ivType1)

        if (detail.types.size > 1) {
            Glide.with(this)
                .load(detail.types[1].tagRes)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivType2)
            binding.ivType2.visibility = View.VISIBLE
        }

        val name = detail.name.replaceFirstChar { it.uppercaseChar() }
        binding.toolbarTitle.text = name
        binding.tvName.text = name
        binding.tvFlavor.text = detail.flavor.text
    }

    private fun getBackground(color: String): Int {
        var bg = converter.getResourceId("bg_activity_default", R.drawable::class.java)
        try {
            bg = converter.getResourceId("bg_activity_$color", R.drawable::class.java)
        } catch (e: Exception) {
            Timber.e(e.stackTraceToString())
        }
        return bg
    }

    override fun onPresenterAttached() {
        binding.toolbarArrow.setOnClickListener { binding.appBar.setExpanded(true, true) }
        appBarWatcher =
            AppBarScrollWatcher { _, _, argbZeroOnExpanded, _, alphaZeroOnCollapsed, alphaZeroOnExpanded ->
                binding.tabs.background.alpha = argbZeroOnExpanded
                binding.toolbarTitle.alpha = alphaZeroOnExpanded
                binding.toolbarArrow.alpha = alphaZeroOnExpanded
                binding.ivSprite.alpha = alphaZeroOnCollapsed
                binding.types.alpha = alphaZeroOnCollapsed
                binding.tvName.alpha = alphaZeroOnCollapsed
                binding.tvFlavor.alpha = alphaZeroOnCollapsed
                binding.bgExpanded.alpha = alphaZeroOnCollapsed
            }
        binding.appBar.addOnOffsetChangedListener(appBarWatcher)

        val args: PokemonInfoFragmentArgs by navArgs()
        val name = args.pokemonSum.name
        val spName = args.pokemonSum.speciesName
        presenter.getPokemonDetail(name, spName)
    }

    override fun showMainProgressBar(show: Boolean) {
        binding.shimmerContainer.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        Timber.e(message)
    }
}
