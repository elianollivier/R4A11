package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LayoutPrincipal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layoutPrincipal: ConstraintLayout = findViewById(R.id.LayoutPrincipal)

        val editText: EditText = findViewById(R.id.editTextText)

        val buttonStart: Button = findViewById(R.id.button_start)

        buttonStart.setOnClickListener {
            val userInput = editText.text.toString().trim()

            if (userInput == "afficher nouveau textView") {
                val deuxiemeTextView = TextView(this).apply {
                    text = userInput
                    textSize = 18f
                }

                layoutPrincipal.addView(deuxiemeTextView)

                Toast.makeText(this, "Nouveau TextView créé !", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bouton cliqué !", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonNext = findViewById<Button>(R.id.button_next)

        buttonNext.setOnClickListener {
            val userText = editText.text.toString().trim()

            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra(EXTRA_TEXT, userText)

            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_TEXT = "text_to_display"
    }
}
