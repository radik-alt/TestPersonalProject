package com.example.testpersonalproject.adapter.LessonViewPager

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UI.Interface.OnListenerLesson

class ViewPagerAdapter(val listImages: ArrayList<String>, val onListenerLesson: OnListenerLesson) : RecyclerView.Adapter<ViewPagerHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson_image, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        Glide.with(context).load(listImages[position]).into(holder.image)

        if (listImages.size == position){
            onListenerLesson.checkLesson(true)
        }

    }

    override fun getItemCount(): Int = listImages.size
}