package com.example.testpersonalproject.adapter.LessonViewPager

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R

class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val container = itemView.findViewById<LinearLayout>(R.id.container)
    val image = itemView.findViewById<ImageView>(R.id.slide)
}