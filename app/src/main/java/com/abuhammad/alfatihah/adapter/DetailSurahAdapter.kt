package com.abuhammad.alfatihah.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abuhammad.alfatihah.R
import com.abuhammad.alfatihah.databinding.ItemDetailSurahBinding
import com.abuhammad.alfatihah.model.AyahsItem

class DetailSurahAdapter : RecyclerView.Adapter<DetailSurahAdapter.ViewHolder>() {
    private val listSurah = ArrayList<AyahsItem>()
    private var expandedPosition: Int = -1

    fun setData(items: List<AyahsItem>) {
        listSurah.clear()
        listSurah.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemDetailSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.downButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    isAnyItemExpanded(position)
                    notifyDataSetChanged()
                }
            }

            binding.tvTitleTafsir.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    isAnyItemExpanded(position)
                    notifyDataSetChanged()
                }
            }
        }

        fun bind(data: AyahsItem, isExpanded: Boolean) {
            binding.apply {
                tvDetailNumber.text = data.number.insurah.toString()
                tvDetailArab.text = data.text.ar
                tvDetailIndo.text = data.translation.id
                tvTafsir.text = data.tafsir.id

                tvTafsir.visibility = if (isExpanded) View.VISIBLE else View.GONE
                viewLine.visibility = if (isExpanded) View.VISIBLE else View.GONE
                downButton.setImageResource(
                    if (isExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetailSurahBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listSurah[position]
        val isExpanded = position == expandedPosition
        holder.bind(data, isExpanded)
    }

    override fun getItemCount() = listSurah.size

    private fun isAnyItemExpanded(position: Int) {
        if (expandedPosition != position) {
            expandedPosition = position
        } else {
            expandedPosition = -1
        }
    }
}

