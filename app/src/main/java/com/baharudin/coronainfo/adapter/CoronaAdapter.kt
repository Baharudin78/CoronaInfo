package com.baharudin.coronainfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.coronainfo.databinding.ItemCoronaBinding
import com.baharudin.coronainfo.model.CoronaIndonesiaResponseItem

class CoronaAdapter : RecyclerView.Adapter<CoronaAdapter.CoronaViewHolder>()  {

    inner class CoronaViewHolder(val binding : ItemCoronaBinding) : RecyclerView.ViewHolder(binding.root)

    private var diffUtil = object : DiffUtil.ItemCallback<CoronaIndonesiaResponseItem>() {
        override fun areItemsTheSame(
            oldItem: CoronaIndonesiaResponseItem,
            newItem: CoronaIndonesiaResponseItem
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: CoronaIndonesiaResponseItem,
            newItem: CoronaIndonesiaResponseItem
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffUtil)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoronaAdapter.CoronaViewHolder {
        val inflater = ItemCoronaBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,false
        )
        return CoronaViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: CoronaAdapter.CoronaViewHolder, position: Int) {
        val corona = differ.currentList[position]
        holder.binding.apply {
            tvKasusKonfirmasiIndo.text = corona.positif
            tvDirawat.text = corona.positif
            tvMeninggal.text = corona.meninggal
            tvSembuh.text = corona.sembuh
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}