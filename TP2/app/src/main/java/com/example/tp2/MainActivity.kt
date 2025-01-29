package com.example.tp2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import android.content.Intent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MyScreen(
                    // On doit faire suivre le contexte pour afficher un toast
                    onShowToast = { msg ->
                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                    },
                    onNavigateSecondActivity = { text ->
                        // Lancer la SecondActivity avec le texte
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        intent.putExtra("TEXT_SAISI", text)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen(
    onShowToast: (String) -> Unit,
    onNavigateSecondActivity: (String) -> Unit
) {
    var nom by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // Affiche ce qu'on tape
            Text(
                text = "Vous avez saisi : $nom",
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Champ texte
            OutlinedTextField(
                value = nom,
                onValueChange = { newValue -> nom = newValue },
                label = { Text("Entrez votre nom") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Bouton "Valider"
            Button(onClick = {
                if (nom.isBlank()) {
                    // Si vide, on affiche un toast (erreur)
                    onShowToast("Veuillez saisir un nom avant de valider.")
                } else {
                    // Sinon, on crée un message "Bonjour X !"
                    message = "Bonjour $nom !"
                    // On lance la seconde activité en lui passant nom
                    onNavigateSecondActivity(nom)
                }
            }) {
                Text("Valider")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Affiche le message validé
            Text(
                text = message,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
