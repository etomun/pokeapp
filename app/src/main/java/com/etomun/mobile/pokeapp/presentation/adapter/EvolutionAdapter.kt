package com.etomun.mobile.pokeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etomun.mobile.pokeapp.R
import com.etomun.mobile.pokeapp.databinding.ItemEvolutionBinding
import com.etomun.mobile.pokeapp.domain.result.Evolution


class EvolutionAdapter(private val items: MutableList<Evolution>) :
    RecyclerView.Adapter<EvolutionAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(R.layout.item_evolution, parent, false)
        )

        private val binding = ItemEvolutionBinding.bind(itemView)
        fun bind(item: Evolution) {
            Glide.with(itemView.context)
                .load(item.from.sprite)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.fromType)

            Glide.with(itemView.context)
                .load(item.to.sprite)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.toType)

            binding.fromName.text = item.from.name
            binding.toName.text = item.to.name
//            binding.trigger.text = item.trigger
            val specs = if (item.minLevel != null) "Lv ${item.minLevel}" else ""
            binding.specs.text = specs
        }

    }
}