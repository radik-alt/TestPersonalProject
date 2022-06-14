package com.example.testpersonalproject.adapter.AdapterItem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UI.HomeFragmentDirections
import com.example.testpersonalproject.UiAccount.ModelItem
import com.example.testpersonalproject.UiAccount.ModelSubItem
import com.example.testpersonalproject.adapter.AdapterInsideItem.AdapterSubItem

class AdapterItem : RecyclerView.Adapter<ViewHolderItem>() {

    var itemList : ArrayList<ModelItem> = ArrayList<ModelItem>()
    set(value) {
        field.addAll(value)
    }

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        context = parent.context
        return ViewHolderItem(view)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {

        holder.title.text = itemList[position].nameThemes

        holder.click_expand.setOnClickListener {
            val area = holder.area_lesson
            if (area.visibility == View.VISIBLE){
                area.visibility = View.GONE
            } else {
                area.visibility = View.VISIBLE
            }
        }

        val list = itemList[position].list_lesson
        val subItem = AdapterSubItem()
        subItem.subList = itemList[position].list_lesson as ArrayList<ModelSubItem>
        holder.inside_recycler.adapter = subItem

        if (list.size <= 4) {
            holder.inside_recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        } else {
            holder.inside_recycler.layoutManager = GridLayoutManager(context, 4)
        }

        holder.test_lesson.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTestFragment(itemList[position].listTest)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int = itemList.size
}