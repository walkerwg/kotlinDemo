package com.example.myapplication

import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewAdpter(var items: List<String>, val clickListener: MainActivity) : RecyclerView.Adapter<ListViewAdpter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val textView = TextView(parent.context)
        textView.height = 100
        textView.gravity = Gravity.CENTER
        textView.textSize = 20.0F
        return ListViewHolder(textView)
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

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class  ListViewHolder(var textView: TextView) : RecyclerView.ViewHolder(textView)
}