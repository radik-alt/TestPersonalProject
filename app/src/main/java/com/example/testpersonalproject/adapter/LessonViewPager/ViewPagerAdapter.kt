package com.example.testpersonalproject.adapter.LessonViewPager

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R

class ViewPagerAdapter(val listImages: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerHolder>() {

    private lateinit var context: Context
    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple,
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple,
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple,
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple,
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson_image, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.container.setBackgroundResource(colors[position])
//        holder.image.setImageResource(_listImages[position])
//        Glide.with(context).load(_listImages[position]).into(holder.image)
    }

    override fun getItemCount(): Int = colors.size
}