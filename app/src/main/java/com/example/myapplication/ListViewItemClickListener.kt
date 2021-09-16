package com.example.myapplication

import android.view.View

interface ListViewItemClickListener {

    fun onItemClick(view: View, index: Int)
}