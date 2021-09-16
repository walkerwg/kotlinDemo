package com.example.myapplication

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewAdpter(var items: List<String>, val clickListener: MainActivity) : RecyclerView.Adapter<ListViewAdpter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        return ListViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.textView.text = items.get(position)
        clickListener?.let {
            holder?.itemView?.setOnClickListener {
                clickListener.onItemClick(holder?.itemView,position)
            }
        }
    }

    override fun getItemCount(): Int {

        return  items.count()
    }

    class  ListViewHolder(var textView: TextView) : RecyclerView.ViewHolder(textView)
}