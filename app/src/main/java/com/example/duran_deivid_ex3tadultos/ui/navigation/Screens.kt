package com.example.duran_deivid_ex3tadultos.ui.navigation

sealed class Screens(val route: String) {
    object MainScreen: Screens("initian_screen")
    object Ej01: Screens("ej1")
    object Ej02: Screens("ej2")
    object Ej03: Screens("ej3")
}