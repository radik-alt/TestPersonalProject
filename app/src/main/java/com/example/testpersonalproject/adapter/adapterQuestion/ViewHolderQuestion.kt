package com.example.testpersonalproject.adapter.adapterQuestion

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R

class ViewHolderQuestion(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val btn = itemView.findViewById<AppCompatButton>(R.id.item_question_answer)

}