package com.abuhammad.alfatihah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abuhammad.alfatihah.databinding.ItemContentBinding
import com.abuhammad.alfatihah.model.MenuItem

class ContentAdapter(
    private val menuItems: List<MenuItem>,
    private val onItemClick: (MenuItem) -> Unit // Lambda untuk menangani klik item
) : RecyclerView.Adapter<ContentAdapter.MenuViewHolder>() {

    // ViewHolder menggunakan Binding
    inner class MenuViewHolder(private val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MenuItem) {
            with(binding) {
                titleContent.text = item.tittle
                descContent.text = item.desc
                imgContent.setImageResource(item.image)

                // Klik item CardView
                root.setOnClickListener {
                    onItemClick(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemContentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuItems[position])
    }

    override fun getItemCount(): Int = menuItems.size
}