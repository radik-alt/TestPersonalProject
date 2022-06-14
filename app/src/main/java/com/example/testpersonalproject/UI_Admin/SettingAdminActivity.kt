package com.example.testpersonalproject.UI_Admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testpersonalproject.R
import com.example.testpersonalproject.databinding.ActivitySettingAdminBinding

class SettingAdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}