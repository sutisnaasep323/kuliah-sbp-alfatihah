package com.abuhammad.alfatihah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abuhammad.alfatihah.databinding.ItemSurahBinding
import com.abuhammad.alfatihah.model.Data

class SurahAdapter(private val dataSurah: List<Data>) :
    RecyclerView.Adapter<SurahAdapter.SurahViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class SurahViewHolder(private val binding: ItemSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) {
            binding.tvNameSurahId.text = data.asma.id.jsonMemberShort
            binding.tvNameSurahArabic.text = data.asma.ar.jsonMemberShort
            binding.tvDescSurah.text = String.format("%s - %s ayat", data.type.id, data.ayahCount)
            binding.tvNumber.text = data.number.toString()

            binding.root.setOnClickListener {
                onItemClickCallback.onItemClicked(dataSurah[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSurahBinding.inflate(inflater, parent, false)
        return SurahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val data = dataSurah[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = dataSurah.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Data)
    }
}
