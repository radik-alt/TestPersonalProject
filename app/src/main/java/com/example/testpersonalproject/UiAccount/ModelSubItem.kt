package com.example.testpersonalproject.UiAccount

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelSubItem (
    var id: Long,
    val nameLesson: String,
    var isCompleted : Boolean,
    val listLesson: ArrayList<String>,
) : Parcelable