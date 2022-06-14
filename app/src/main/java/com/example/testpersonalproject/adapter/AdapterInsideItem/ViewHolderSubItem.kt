package com.example.testpersonalproject.adapter.AdapterInsideItem

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R

class ViewHolderSubItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val number_lesson = itemView.findViewById<AppCompatButton>(R.id.number_lesson)

}