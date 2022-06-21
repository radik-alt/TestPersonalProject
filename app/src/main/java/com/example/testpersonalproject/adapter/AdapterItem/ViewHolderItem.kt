package com.example.testpersonalproject.adapter.AdapterItem

import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R

class ViewHolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title = itemView.findViewById<TextView>(R.id.title)
    val percent_item = itemView.findViewById<TextView>(R.id.percent)
    val click_expand = itemView.findViewById<ImageButton>(R.id.click_expand)
    val area_lesson = itemView.findViewById<LinearLayout>(R.id.area_lesson)
    val inside_recycler = itemView.findViewById<RecyclerView>(R.id.general_recycler)
}