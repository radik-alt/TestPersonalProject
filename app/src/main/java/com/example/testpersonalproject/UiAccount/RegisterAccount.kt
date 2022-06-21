package com.example.testpersonalproject.UiAccount

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Toast
import com.example.testpersonalproject.HomeActivity
import com.example.testpersonalproject.databinding.ActivityRegisterAccountBinding
import java.util.*

class RegisterAccount : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterAccountBinding
    private var selectCalendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.backLogIN.setOnClickListener {
            startActivity(Intent(this, LogInAccount::class.java))
            finish()
        }
        
        binding.dateSelect.setOnClickListener {
            val date = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                selectCalendar.set(year, month, day)
                binding.dateSelect.setText(convertDate(selectCalendar.time))
            }, Calendar.YEAR, Calendar.MONTH, Calendar.DATE)
            date.show()
        }

        binding.register.setOnClickListener {
            if (valid()){
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }

    }

    private fun convertDate(date: Date?): String = DateFormat.format("MMMM dd yyyy", date!!.time).toString()

    private fun valid() : Boolean{

        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val patronymic = binding.patronymic.text.toString()
        val position = binding.positionJob.text.toString()
        val division = binding.division.text.toString()
        val date = binding.dateSelect.text.toString()
        val number = binding.numberPhone.text.toString()

        if (firstName.isNotBlank() && lastName.isNotBlank() && patronymic.isNotBlank()){
            return if (position.isNotBlank() && division.isNotBlank() && date.isNotBlank()){
                if (number.isNotBlank()){
                    true
                } else {
                    Toast.makeText(this, "Введите корректно номер телефона!", Toast.LENGTH_SHORT).show()
                    false
                }
            } else {
                Toast.makeText(this, "Введите все данные!", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(this, "Введите ФИО!", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}