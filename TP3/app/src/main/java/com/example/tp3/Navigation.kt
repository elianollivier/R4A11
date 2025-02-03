package com.example.tp3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("form") {
            FormScreen(navController = navController)
        }
        composable(
            route = "display/{name}/{year}",
            arguments = listOf(
                navArgument(name = "name") { defaultValue = "" },
                navArgument(name = "year") { defaultValue = "" }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val year = backStackEntry.arguments?.getString("year") ?: ""
            DisplayScreen(navController = navController, name = name,  year = year)
        }
    }
}

@Composable
fun DisplayScreen(navController: NavController, name: String, year: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenue",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Nom saisi : $name",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Vous avez $year ans",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Retour")
        }
    }
}


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenue dans ma première application compose navigation",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            navController.navigate("form")
        }) {
            Text(text = "Accéder au formulaire")
        }
    }
}

@Composable
fun FormScreen(navController: NavController) {
    var name by remember {mutableStateOf("")}
    var year by remember {mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Page du formulaire.",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = name,
            onValueChange = {newText -> name = newText},
            label = {Text("Entrez votre nom")},
            modifier = Modifier.fillMaxWidth().padding(16.dp)

        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = year,
            onValueChange = {newText -> year = newText},
            label = {Text("Entrez votre age")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(16.dp)

        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("display/$name/$year") }) {
            Text(text = "Valider")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Retour")
        }
    }
}


