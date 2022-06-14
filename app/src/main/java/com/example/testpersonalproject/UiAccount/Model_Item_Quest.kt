package com.example.testpersonalproject.UiAccount

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Model_Item_Quest (
    val id: Long,
    val list_question: ArrayList<String>
):Parcelable