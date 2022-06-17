package com.example.testpersonalproject.adapter.AdapterItem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testpersonalproject.R
import com.example.testpersonalproject.adapter.AdapterSubItemTop.AdapteTopSubItem
import com.example.testpesonalproject.UiAccount.ModelHome

class AdapterItem (var itemList : ArrayList<ModelHome>) : RecyclerView.Adapter<ViewHolderItem>() {


    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        context = parent.context
        return ViewHolderItem(view)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {


        holder.click_expand.setOnClickListener {
            val area = holder.area_lesson
            if (area.visibility == View.VISIBLE){
                Glide.with(context).load(R.drawable.ic_up_vector).into(holder.click_expand)
                area.visibility = View.GONE
            } else {
                Glide.with(context).load(R.drawable.ic_downtop).into(holder.click_expand)
                area.visibility = View.VISIBLE
            }
        }

        holder.inside_recycler.adapter = AdapteTopSubItem(itemList[position].itemList)

//        val list = itemList[position].list_lesson
//        val subItem = AdapterSubItem()
//        subItem.subList = itemList[position].list_lesson as ArrayList<ModelSubItem>
//        holder.inside_recycler.adapter = subItem
//
//        if (list.size <= 4) {
//            holder.inside_recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//        } else {
//            holder.inside_recycler.layoutManager = GridLayoutManager(context, 4)
//        }
//
//        holder.test_lesson.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToTestFragment(itemList[position].listTest)
//            Navigation.findNavController(it).navigate(action)
//        }



    }

    override fun getItemCount(): Int = itemList.size
}