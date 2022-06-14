package com.example.testpersonalproject.adapter.adapterTest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UiAccount.ModelTest

class AdapterTest(val indexItem: Int, var listTest: ArrayList<ModelTest>): RecyclerView.Adapter<ViewHolderTest>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTest {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quastion_list, parent, false)
        context = parent.context
        return ViewHolderTest(view)
    }

    override fun onBindViewHolder(holder: ViewHolderTest, position: Int) {

        holder.number_question.text = "${listTest[position].id + 1}"

        if (listTest[position].isCompleted){
            holder.number_question.background = ContextCompat.getDrawable(context, R.drawable.item_select_quastion_list)
        }

        if (position == indexItem){
            holder.number_question.background = ContextCompat.getDrawable(context, R.drawable.error_item_selected_question)
        }

    }

    override fun getItemCount(): Int = listTest.size
}