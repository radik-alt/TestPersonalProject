package com.example.testpersonalproject.adapter.AdapterSubItemTop

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R

class ViewHolderTopSubItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name = itemView.findViewById<TextView>(R.id.nameThemes)
    val recycler = itemView.findViewById<RecyclerView>(R.id.inside_recycler_general)
    val test = itemView.findViewById<AppCompatButton>(R.id.test_lesson)

}