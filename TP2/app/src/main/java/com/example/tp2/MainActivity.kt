package com.example.tp2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import android.content.Intent
import com.example.tp2.ui.theme.TP2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP2Theme {
                MyScreen(
                    onShowToast = { msg ->
                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                    },
                    onNavigateSecondActivity = { nom, annee ->
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        intent.putExtra("NOM", nom)
                        intent.putExtra("ANNEE", annee)
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
    onNavigateSecondActivity: (String, Int) -> Unit
) {
    var nom by remember { mutableStateOf("") }
    var anneeTexte by remember { mutableStateOf("") }

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
            Text(
                text = "Vous avez saisi : $nom",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = nom,
                onValueChange = { newValue -> nom = newValue },
                label = { Text("Entrez votre nom") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = anneeTexte,
                onValueChange = { newValue -> anneeTexte = newValue },
                label = { Text("Entrez votre année de naissance") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                if (nom.isBlank() || anneeTexte.isBlank()) {
                    onShowToast("Veuillez saisir votre nom et votre année de naissance.")
                } else {
                    val annee = anneeTexte.toIntOrNull()
                    if (annee == null) {
                        onShowToast("L'année doit être un nombre valide.")
                    } else {
                        onNavigateSecondActivity(nom, annee)
                    }
                }
            }) {
                Text("Valider")
            }
        }
    }
}
