package com.example.testpersonalproject.adapter.adapterQuestion

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UI.Interface.OnClickAnswer

class AdapterQuestion(list: ArrayList<String>, private val onClickAnswer: OnClickAnswer) : RecyclerView.Adapter<ViewHolderQuestion>() {

    var questionList: ArrayList<String> = ArrayList()
    init {
        questionList = list
    }

    private lateinit var context: Context

    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): ViewHolderQuestion {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_question, parent, false)
        context = parent.context
        return ViewHolderQuestion(view)
    }

    override fun onBindViewHolder (holder: ViewHolderQuestion, position: Int) {
        val answer = holder.btn
        val model = questionList[position]
        answer.text = model

        answer.setOnClickListener {
            answer.background = ContextCompat.getDrawable(context, R.drawable.right_choose_question)
            onClickAnswer.chooseAnswer(position)
        }

    }

    override fun getItemCount(): Int = questionList.size
}