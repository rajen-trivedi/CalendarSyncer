package com.rajen.calendarsyncer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.rajen.calendarsyncer.databinding.ActivityMainBinding
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var upcomingAdapter: UpcomingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.initView()
    }

    private fun ActivityMainBinding.initView() {
        upcomingAdapter = UpcomingAdapter(mutableListOf())
        rvCalendarList.adapter = upcomingAdapter
        loadJsonData()
    }

    private fun loadJsonData() {
        val inputStream = resources.openRawResource(R.raw.appointments)
        val reader = InputStreamReader(inputStream)
        val jsonData = Gson().fromJson(reader, AppointmentResponse::class.java)
        reader.close()

        upcomingAdapter.updateData(jsonData.results)
    }
}