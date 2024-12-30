package com.abuhammad.alfatihah.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abuhammad.alfatihah.R
import com.abuhammad.alfatihah.model.SearchResult

class SearchResultsAdapter(
    private var results: List<SearchResult>
) : RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val surahName: TextView = itemView.findViewById(R.id.surahName)
        private val ayahNumber: TextView = itemView.findViewById(R.id.surahNumber)
        private val tafsirText: TextView = itemView.findViewById(R.id.tafsirText)

        fun bind(result: SearchResult) {
            surahName.text = result.surahName
            ayahNumber.text = result.ayahNumber.toString()
            tafsirText.text = result.tafsir
        }
    }
}
