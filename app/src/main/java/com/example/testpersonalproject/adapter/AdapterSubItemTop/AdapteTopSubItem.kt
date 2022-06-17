package com.example.testpersonalproject.adapter.AdapterSubItemTop

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UI.HomeFragmentDirections
import com.example.testpersonalproject.UiAccount.ModelItem
import com.example.testpersonalproject.adapter.AdapterInsideItem.AdapterSubItem

class AdapteTopSubItem(val topListSub: ArrayList<ModelItem>) : RecyclerView.Adapter<ViewHolderTopSubItem>() {

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTopSubItem {
        context = parent.context
        return ViewHolderTopSubItem(LayoutInflater.from(parent.context).inflate(R.layout.item_sub, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderTopSubItem, position: Int) {

        holder.name.text = topListSub[position].nameThemes
        holder.recycler.adapter = AdapterSubItem(topListSub[position].list_lesson)

        if (topListSub[position].list_lesson.size <= 4) {
            holder.recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        } else {
            holder.recycler.layoutManager = GridLayoutManager(context, 4)
        }

        holder.test.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTestFragment(topListSub[position].listTest)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int = topListSub.size
}