package com.example.myapplication

import android.content.SharedPreferences
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class splash_screen : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)

        Handler().postDelayed({

            val intent = if (isFirstRun) {
                // Если не первый запуск, открываем основное меню
                Intent(this, menu::class.java)
            } else {
                Intent(this, menu::class.java)
            }
            startActivity(intent)
            // Завершить активность
            finish()
        }, SPLASH_TIME_OUT)
    }
}


