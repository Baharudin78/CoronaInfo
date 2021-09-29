package com.baharudin.coronainfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.coronainfo.databinding.ItemCountryBinding
import com.baharudin.coronainfo.model.country.CountryResponseItem

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CoutryHolder>() {

    inner class CoutryHolder(val binding : ItemCountryBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<CountryResponseItem>() {
        override fun areItemsTheSame(
            oldItem: CountryResponseItem,
            newItem: CountryResponseItem
        ): Boolean {
            return oldItem.country == newItem.country
        }

        override fun areContentsTheSame(
            oldItem: CountryResponseItem,
            newItem: CountryResponseItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoutryHolder {
        val inflated = ItemCountryBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,false
        )
        return CoutryHolder(inflated)
    }

    override fun onBindViewHolder(holder: CoutryHolder, position: Int) {
        val country = differ.currentList[position]
        holder.binding.tvDirawat.text = country.confirmed.toString()
        holder.binding.tvSembuh.text = country.recovered.toString()
        holder.binding.tvMeninggal.text = country.deaths.toString()
        holder.binding.tvCountry.text = country.country
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}