package com.example.testpersonalproject.UiAccount

data class ModelSubItem (
    var id: Long,
    val nameLesson: String,
    val isCompleted : Boolean,
    val listLesson: ArrayList<String>,
)