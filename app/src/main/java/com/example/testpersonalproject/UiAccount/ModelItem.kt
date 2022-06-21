package com.example.testpersonalproject.UiAccount

data class ModelItem (
    var id: Long,
    val nameThemes: String,
    var list_lesson : ArrayList<ModelSubItem>,
    val isCompletedTest : Boolean,
    val listTest : ArrayList<ModelTest>
)