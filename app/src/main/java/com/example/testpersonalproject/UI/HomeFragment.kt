package com.example.testpersonalproject.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testpersonalproject.R
import com.example.testpersonalproject.UiAccount.*
import com.example.testpersonalproject.adapter.AdapterItem.AdapterItem
import com.example.testpersonalproject.adapter.AdapterSubItemTop.AdapteTopSubItem
import com.example.testpersonalproject.databinding.FragmentHomeBinding
import com.example.testpersonalproject.statObject
import com.example.testpesonalproject.UiAccount.ModelHome


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var modelHome: ArrayList<ModelHome>

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val statObject = statObject.Companion
        statObject.adapter()
        modelHome = statObject.modelHome

        adapter()


        binding.allResult.setOnClickListener {
//            HomeFragmentDirections.actionHomeFragmentToAllTestFragment(modelHome.toArray() as Array<ModelHome>)
            findNavController().navigate(R.id.action_homeFragment_to_allTestFragment)
        }

        return binding.root
    }

    private fun adapter(){

        binding.recyclerTest.adapter = AdapterItem(modelHome)
    }
}