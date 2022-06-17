package com.example.testpersonalproject.adapter.AdapterInsideItem

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UI.HomeFragmentDirections
import com.example.testpersonalproject.UiAccount.ModelSubItem
import com.example.testpersonalproject.UiAccount.ModelTest

class AdapterSubItem (var subList: ArrayList<ModelSubItem>): RecyclerView.Adapter<ViewHolderSubItem>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSubItem {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.sub_item_lesson, parent, false)
        context = parent.context
        return ViewHolderSubItem(view)
    }

    override fun onBindViewHolder(holder: ViewHolderSubItem, position: Int) {
        val btn = holder.number_lesson
        btn.text = subList[position].nameLesson


        if (subList[position].isCompleted){
            btn.setBackgroundResource(R.drawable.test_completed)
        }

        btn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToLessonFragment(subList[position])
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int = subList.size
}