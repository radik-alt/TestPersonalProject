package com.example.testpersonalproject.UI_Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testpersonalproject.R
import com.example.testpersonalproject.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.settingApi.setOnClickListener {
            startActivity(Intent(this, SettingAdminActivity::class.java))
        }
    }
}