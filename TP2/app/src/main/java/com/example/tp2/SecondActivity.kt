package com.example.tp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Récupérer le texte transmis en extra depuis l'intent
        val textSaisi = intent.getStringExtra("TEXT_SAISI") ?: ""

        setContent {
            MaterialTheme {
                // Simplement afficher le texte
                Text(text = "Texte saisi: $textSaisi")
            }
        }
    }
}
