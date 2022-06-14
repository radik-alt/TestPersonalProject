package com.example.testpersonalproject.UiAccount

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
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
        }
        
        binding.dateSelect.setOnClickListener {
            val date = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                selectCalendar.set(year, month, day)
                binding.dateSelect.setText(convertDate(selectCalendar.time))
            }, Calendar.YEAR, Calendar.MONTH, Calendar.DATE)
            date.show()
        }

    }

    private fun convertDate(date: Date?): String = DateFormat.format("MMMM dd yyyy", date!!.time).toString()

}