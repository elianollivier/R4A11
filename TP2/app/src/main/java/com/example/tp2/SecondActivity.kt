package com.example.tp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tp2.ui.theme.TP2Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nom = intent.getStringExtra("NOM") ?: "Inconnu"
        val annee = intent.getIntExtra("ANNEE", 0)
        val age = if (annee != 0) AgeCalculator.calculateAge(annee) else 0

        setContent {
            TP2Theme {
                SecondScreen(nom = nom, annee = annee, age = age)
            }
        }
    }
}

@Composable
fun SecondScreen(nom: String, annee: Int, age: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $nom, vous êtes né en $annee et vous avez $age ans.",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
