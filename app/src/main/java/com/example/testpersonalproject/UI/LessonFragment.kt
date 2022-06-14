package com.example.testpersonalproject.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testpersonalproject.R
import com.example.testpersonalproject.adapter.LessonViewPager.ViewPagerAdapter
import com.example.testpersonalproject.databinding.FragmentLessonBinding
import java.lang.RuntimeException

class LessonFragment : Fragment() {

    private var _binding: FragmentLessonBinding?=null
    private val binding: FragmentLessonBinding
        get() = _binding ?: throw RuntimeException("FragmentLessonBinding == null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLessonBinding.inflate(layoutInflater, container, false)

        val listLesson : ArrayList<String> = ArrayList()
        listLesson.add("https://avatars.mds.yandex.net/get-zen_doc/1581245/pub_5ff74f3ef906b16872346899_5ff74f67f906b1687234a757/scale_1200")
        listLesson.add("https://avatars.mds.yandex.net/get-zen_doc/1581245/pub_5ff74f3ef906b16872346899_5ff74f67f906b1687234a757/scale_1200")
        listLesson.add("https://avatars.mds.yandex.net/get-zen_doc/1581245/pub_5ff74f3ef906b16872346899_5ff74f67f906b1687234a757/scale_1200")
        listLesson.add("https://avatars.mds.yandex.net/get-zen_doc/1581245/pub_5ff74f3ef906b16872346899_5ff74f67f906b1687234a757/scale_1200")
        listLesson.add("https://avatars.mds.yandex.net/get-zen_doc/1581245/pub_5ff74f3ef906b16872346899_5ff74f67f906b1687234a757/scale_1200")

        val listTemp : ArrayList<Int> = ArrayList()
        listTemp.add(R.mipmap.ic_launcher_round)
        listTemp.add(R.mipmap.ic_launcher_round)
        listTemp.add(R.mipmap.ic_launcher_round)
        listTemp.add(R.mipmap.ic_launcher_round)
        listTemp.add(R.mipmap.ic_launcher_round)


        val viewPager = binding.imageSlide
        viewPager.adapter = ViewPagerAdapter(listTemp)
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