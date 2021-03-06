package com.etomun.mobile.pokeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout.LayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etomun.mobile.pokeapp.R
import com.etomun.mobile.pokeapp.databinding.ItemPokemonSumBinding
import com.etomun.mobile.pokeapp.domain.result.PokemonSum


class PokemonAdapter(
    private val items: MutableList<PokemonSum>,
    private val clickItem: (PokemonSum) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.bind(item, clickItem)
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_sum, parent, false)
        )

        private val binding = ItemPokemonSumBinding.bind(itemView)
        fun bind(item: PokemonSum, clickItem: (PokemonSum) -> Unit) {
            val ctx = itemView.context
            itemView.setOnClickListener { clickItem(item) }

            Glide.with(ctx)
                .load(item.sprite)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.avatar)
            binding.tvName.text = item.name
            "#%03d".format(item.id).also { binding.tvId.text = it }

            binding.typesContainer.removeAllViews()
            item.types.forEachIndexed { i, type ->
                val iv = ImageView(ctx)
                iv.layoutParams = LayoutParams(72, 72)
                iv.setImageResource(type.typeRes)
                binding.typesContainer.addView(iv, i)
            }
        }

    }
}