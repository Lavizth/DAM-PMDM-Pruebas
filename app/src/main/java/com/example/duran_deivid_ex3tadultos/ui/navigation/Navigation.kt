package com.example.duran_deivid_ex3tadultos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.duran_deivid_ex3tadultos.MenuScreen
import com.example.duran_deivid_ex3tadultos.ui.ej1.screens.Ej01
import com.example.duran_deivid_ex3tadultos.ui.ej2.screens.Ej02
import com.example.duran_deivid_ex3tadultos.ui.ej3.screens.Ej03

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) { MenuScreen(navController)}
        composable(route = Screens.Ej01.route) {Ej01()}
        composable(route = Screens.Ej02.route) {Ej02()}
        composable(route = Screens.Ej03.route) {Ej03()}
    }
}