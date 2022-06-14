package com.example.testpersonalproject.UiAccount

data class ModelItem (
    var id: Long,
    val nameThemes: String,
    var list_lesson : List<ModelSubItem>,
    val listTest : Array<ModelTest>
)