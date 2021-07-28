package com.etomun.mobile.pokeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.etomun.mobile.pokeapp.R
import com.etomun.mobile.pokeapp.databinding.ItemAbilityBinding
import com.etomun.mobile.pokeapp.domain.result.Ability


class AbilityAdapter(private val items: MutableList<Ability>) :
    RecyclerView.Adapter<AbilityAdapter.Holder>() {

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
            LayoutInflater.from(parent.context).inflate(R.layout.item_ability, parent, false)
        )

        private val binding = ItemAbilityBinding.bind(itemView)
        fun bind(item: Ability) {
            binding.name.text = item.name
            binding.flavorText.text = item.flavorText
            val drawable = if (item.isHidden) R.drawable.ic_hidden_20 else 0
            binding.name.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
        }

    }
}