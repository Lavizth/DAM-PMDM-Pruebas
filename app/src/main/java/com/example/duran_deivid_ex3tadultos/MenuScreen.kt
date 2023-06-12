package com.example.duran_deivid_ex3tadultos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.duran_deivid_ex3tadultos.ui.navigation.Screens

@Composable
fun MenuScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate(route = Screens.Ej01.route) }) {
            Text(text = "Ejercicio 1")
        }
        Button(onClick = { navController.navigate(route = Screens.Ej02.route) }) {
            Text(text = "Ejercicio 2")
        }
        Button(onClick = { navController.navigate(route = Screens.Ej03.route) }) {
            Text(text = "Ejercicio 3")
        }
    }
}