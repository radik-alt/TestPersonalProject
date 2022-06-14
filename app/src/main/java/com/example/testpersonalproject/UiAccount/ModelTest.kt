package com.example.testpersonalproject.UiAccount

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.ArrayList
import kotlin.jvm.Throws

@Parcelize
data class ModelTest(
    val id: Long,
    val nameTest: String,
    val description: String,
    val item_answer: ArrayList<String>,
    val correctAnswer: Int,
    var choose_answer: Int?,
    var isCompleted: Boolean
) : Parcelable
