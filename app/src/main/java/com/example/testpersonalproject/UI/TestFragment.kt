package com.example.testpersonalproject.UI

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testpersonalproject.UI.Interface.OnClickAnswer
import com.example.testpersonalproject.UI.service.TimerTest
import com.example.testpersonalproject.adapter.adapterQuestion.AdapterQuestion
import com.example.testpersonalproject.adapter.adapterTest.AdapterTest
import com.example.testpersonalproject.UiAccount.ModelTest
import com.example.testpersonalproject.databinding.FragmentTestBinding


class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private val args by navArgs<TestFragmentArgs>()
    private lateinit var listModelTest : ArrayList<ModelTest>

    private var indexTest = 0
    private var answerThis = 0
    private var isCompletedNotFull = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(layoutInflater, container, false)

        listModelTest = args.test.toList() as ArrayList<ModelTest>
        changeAdapter(indexTest)

        binding.nextQuestion.setOnClickListener {
            if (validBorderList(listModelTest, indexTest) && !isCompletedNotFull){
                listModelTest[indexTest].isCompleted = true
                listModelTest[indexTest].choose_answer = answerThis
                indexTest += 1
                changeAdapter(indexTest)
            } else {
                launchNotCompleted()
            }
        }

        binding.skipQuestion.setOnClickListener {
            if (validBorderList(listModelTest, indexTest) && !isCompletedNotFull){
                listModelTest[indexTest].isCompleted = false
                indexTest += 1
                changeAdapter(indexTest)
            } else {
                launchNotCompleted()
            }
        }

        return binding.root
    }

    private fun changeAdapter(indexTest: Int){
        val adapterItemTest = AdapterTest(indexTest, listModelTest)
        binding.columnQuestion.adapter = adapterItemTest
        binding.columnQuestion.layoutManager = GridLayoutManager(requireContext(), 8)

        val nameQuestion = listModelTest[indexTest].nameTest
        val descQuestion = listModelTest[indexTest].description

        val questionList = listModelTest[indexTest].item_answer
        val adapterQuestion = AdapterQuestion(questionList, object : OnClickAnswer{
            override fun chooseAnswer(answer: Int) {
                answerThis = answer
            }
        })

        binding.taskQuestion.text = nameQuestion
        binding.descQuestion.text = descQuestion
        binding.question.adapter = adapterQuestion
    }

    private val receiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, getIntent: Intent) {
            val time = getIntent.getLongExtra(TimerTest.GET_INTENT_SERVICE, 0)

            val seconds = (time / 1000) % 60
            val minutes = ((time / (1000*60)) % 60)
            val convertTimer = makeTimeString(minutes, seconds)
            Log.d("TimeResultGet", convertTimer)
        }
    }

    private fun makeTimeString(minutes: Long, second: Long): String =
        String.format("%02d : %02d", minutes, second)

    private fun validBorderList(list:ArrayList<ModelTest>, index:Int) : Boolean{
        if (index < list.size-1) {
            return true
        }

        return false
    }

    private fun launchFinishTest(){
        val arr : Array<ModelTest> = Array(listModelTest.size) { listModelTest[0] }
        for (i in listModelTest.indices){
            arr[i] = listModelTest[i]
            Log.d("MyArrayFragment", "$i ${listModelTest[i]}")
        }

        val action = TestFragmentDirections.actionTestFragmentToFinalFragment(arr)
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun launchNotCompleted(){
        isCompletedNotFull = true
        val valid = checkNotCompleted()

        if (valid != -1){
            indexTest = valid
            listModelTest[indexTest].isCompleted = true
            listModelTest[indexTest].choose_answer = answerThis
            changeAdapter(valid)
        } else {
            launchFinishTest()
        }
    }

    private fun checkNotCompleted():Int{
        for (i in listModelTest){
            if (!i.isCompleted) return i.id.toInt()
        }
        return -1
    }

}