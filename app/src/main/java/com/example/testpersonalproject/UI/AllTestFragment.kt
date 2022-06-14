package com.example.testpersonalproject.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testpersonalproject.R
import com.example.testpersonalproject.databinding.FragmentAllTestBinding
import java.lang.RuntimeException


class AllTestFragment : Fragment() {

    private var _binding: FragmentAllTestBinding? = null
    private val binding : FragmentAllTestBinding
        get() = _binding ?: throw RuntimeException("FragmentAllTestBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllTestBinding.inflate(layoutInflater, container, false)

        

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}