package com.example.duran_deivid_ex3tadultos.ui.ej2.data.model

data class User(
    val email: String,
    val password: String
)

fun getFakeUsers() =
    List(5) { i -> User("email${i+1}@email.com", "1234")}
