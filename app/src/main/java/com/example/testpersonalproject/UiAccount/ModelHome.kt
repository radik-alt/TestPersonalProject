package com.example.testpesonalproject.UiAccount

import com.example.testpersonalproject.UiAccount.ModelItem
import java.io.Serializable


data class ModelHome(
    val id: Long,
    val itemList: ArrayList<ModelItem>
) : Serializable