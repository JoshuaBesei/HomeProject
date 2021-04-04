package com.example.homeproject.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject.R
import com.example.homeproject.fragments.tasks.Tasks

class ItemAdapter (private val context: Context, private val dataset: List<Tasks>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()  {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val textView1: TextView = view.findViewById(R.id.item_description)
        val textView2: TextView = view.findViewById(R.id.item_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  context.resources.getString(item.stringResourceId)
        holder.textView1.text =  context.resources.getString(item.stringResource1Id)
        holder.textView2.text =  context.resources.getString(item.stringResource2Id)
    }

    override fun getItemCount() = dataset.size
}