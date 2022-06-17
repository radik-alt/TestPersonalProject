package com.example.testpersonalproject.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UI.Interface.OnListenerLesson
import com.example.testpersonalproject.adapter.LessonViewPager.ViewPagerAdapter
import com.example.testpersonalproject.databinding.FragmentLessonBinding
import java.lang.RuntimeException

class LessonFragment : Fragment() {

    private var _binding: FragmentLessonBinding?=null
    private val binding: FragmentLessonBinding
        get() = _binding ?: throw RuntimeException("FragmentLessonBinding == null")

    private val args by navArgs<LessonFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLessonBinding.inflate(layoutInflater, container, false)

        val getList = args.itemLesson

        val listLesson : ArrayList<String> = ArrayList()
        listLesson.addAll(getList.listLesson)

        val viewPager = binding.imageSlide
        viewPager.adapter = ViewPagerAdapter(listLesson, object : OnListenerLesson{
            override fun checkLesson(lesson: Boolean) {
                getList.isCompleted = lesson
            }
        })
        binding.indicator.setViewPager(viewPager)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}