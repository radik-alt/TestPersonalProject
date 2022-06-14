package com.example.testpersonalproject.adapter.adapterTest

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R

class ViewHolderTest(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val number_question = itemView.findViewById<AppCompatButton>(R.id.number_question)

}