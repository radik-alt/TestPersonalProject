package com.example.testpersonalproject.UiAccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testpersonalproject.MainActivity
import com.example.testpersonalproject.databinding.ActivityLogInAccountBinding
import com.example.testpersonalproject.HomeActivity
import com.example.testpersonalproject.UI_Admin.AdminActivity

class LogInAccount : AppCompatActivity() {

    private lateinit var binding: ActivityLogInAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.backLogIN.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.enterLogIN.setOnClickListener {
            val email = binding.nameUser.text.toString()
            val pass = binding.passwrodUser.text.toString()
            val check = binding.checkPolitica.isChecked
            if (valid(email, pass, check)){
                if (email == "admin" && pass == "admin"){
                    startActivity(Intent(this, AdminActivity::class.java))
                } else {
                    startActivity(Intent(this, HomeActivity::class.java))
                }
            }

        }

        binding.register.setOnClickListener {
            startActivity(Intent(this, RegisterAccount::class.java))
        }

    }

    private fun valid(email: String, pass: String, check: Boolean): Boolean {
        if (check) {
            if (email.isNotBlank() and pass.isNotBlank()){
                return true
            }else {
                Toast.makeText(this, "Введите пароль или логин!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        else {
            Toast.makeText(this, "Для продолжения необходимо подтвердить согласие с политикой конфеденциальности!", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}