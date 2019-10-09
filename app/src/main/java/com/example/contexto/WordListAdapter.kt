package com.example.contexto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.size



class WordListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<DoContext>() //cached copy of Wrods

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val contextTextView: TextView = itemView.findViewById(R.id.context)
        val timeTextView: TextView = itemView.findViewById(R.id.timeExpected)
        val checkBoxView: CheckBox = itemView.findViewById(R.id.checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.titleTextView.text = current.title
        holder.contextTextView.text = current.contexto
        holder.timeTextView.text = current.timeExpected
    }

    internal fun setWords(doContexts: List<DoContext>){
        this.words = doContexts
        notifyDataSetChanged()
    }

    /*private fun deleteItem(position: Int) {
        this.words.remove(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, this.words.size())
        holder.itemView.setVisibility(View.GONE)
    }*/

    override fun getItemCount() = words.size
}