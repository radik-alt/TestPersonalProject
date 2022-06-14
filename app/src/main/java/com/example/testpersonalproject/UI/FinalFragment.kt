package com.example.testpersonalproject.UI

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UiAccount.ModelTest
import com.example.testpersonalproject.databinding.FragmentFinalBinding


class FinalFragment : Fragment() {

    private lateinit var binding: FragmentFinalBinding
    private val args by navArgs<FinalFragmentArgs>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFinalBinding.inflate(layoutInflater, container, false)

        val listFinish = args.finalTest.toList() as ArrayList<ModelTest>

        for (i in listFinish){
            Log.d("MyTagFinishResult", "$i")
        }

        var countCorrectAnswer = 0
        for (i in listFinish){
            if (i.choose_answer == i.correctAnswer){
                countCorrectAnswer++
            }
        }

        val allCountAnswer = listFinish.size
        val percent : Int = (countCorrectAnswer * 100) / allCountAnswer

        binding.countAllAnswer.text = "/ $allCountAnswer"
        binding.countCorrectAnswer.text = "$countCorrectAnswer"
        binding.percentCountAnswer.text = "$percent %"

        val winColor = resources.getColor(R.color.important_color)
        val imageWin = R.drawable.ic_sucess_test
        val loseColor = Color.RED
        val imageLose = R.drawable.ic_lose_result_finish

        if (winner(percent)){
            binding.countAllAnswer.setTextColor(winColor)
            binding.countCorrectAnswer.setTextColor(winColor)
            binding.percentCountAnswer.setTextColor(winColor)
            binding.resultTest.text = "Тест пройден"
            binding.imageFinal.setImageResource(imageWin)
            binding.ToHomeFragment.text = "Повторить попытку"
        } else {
            binding.countAllAnswer.setTextColor(loseColor)
            binding.countCorrectAnswer.setTextColor(loseColor)
            binding.percentCountAnswer.setTextColor(loseColor)
            binding.resultTest.text = "Тест не пройден"
            binding.ToHomeFragment.text = "Продолжить обучение"
            binding.imageFinal.setImageResource(imageLose)
        }

        binding.resultTest.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_finalFragment_to_allTestFragment)
        }

        binding.ToHomeFragment.setOnClickListener {
            if (winner(percent)){
                Navigation.findNavController(requireView()).navigate(R.id.action_finalFragment_to_homeFragment)
            } else{
                Navigation.findNavController(requireView()).navigate(R.id.action_finalFragment_to_homeFragment)
            }
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun winner(percent:Int):Boolean{
        if (percent < 60) return false
        return true
    }

}