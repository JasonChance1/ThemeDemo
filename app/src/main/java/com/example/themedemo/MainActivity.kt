package com.example.themedemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var sp: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        sp = getSharedPreferences("config", MODE_PRIVATE)
        editor= sp.edit()
        val theme = sp.getInt("theme",R.style.Theme_ThemeDemo)
//        // 设置默认主题
        setTheme(theme);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val normalButton = findViewById<Button>(R.id.normal)
        val blueButton = findViewById<Button>(R.id.blue)

        blueButton.setOnClickListener {
            editor.putInt("theme",R.style.Theme_ThemeDemo_Dark)
            editor.apply()
            recreate()
        }

        normalButton.setOnClickListener {
            editor.putInt("theme",R.style.Theme_ThemeDemo)
            editor.apply()
            recreate()
        }
    }
}