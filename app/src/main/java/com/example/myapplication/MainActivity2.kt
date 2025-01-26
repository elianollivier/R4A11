package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMain2Binding
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val textToDisplay = intent.getStringExtra(MainActivity.EXTRA_TEXT) ?: ""


        val textViewDisplay = findViewById<TextView>(R.id.textViewDisplay)
        textViewDisplay.text = textToDisplay

        val buttonPrevious = findViewById<Button>(R.id.button_previous)
        buttonPrevious.setOnClickListener {
            finish()
        }

    }
}
