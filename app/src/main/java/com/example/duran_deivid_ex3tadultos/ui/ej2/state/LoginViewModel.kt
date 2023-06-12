package com.example.duran_deivid_ex3tadultos.ui.ej2.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.duran_deivid_ex3tadultos.ui.ej2.data.model.getFakeUsers

enum class DialogError { ERROR_PASSWORD, CORRECT, ERROR_EMAIL }

class LoginViewModel: ViewModel() {

    private val _userList = getFakeUsers().toMutableStateList()
    val userList get() = _userList.toList()

    private var _emailNotExists by mutableStateOf(false)
    val emailNotExists get() = _emailNotExists
    fun clearEmailNotExists(){
        _emailNotExists = false
    }

    private var _passwordNotCorrect by mutableStateOf(false)
    val passwordNotCorrect get() = _passwordNotCorrect
    fun clearPasswordNotCorrect(){
        _passwordNotCorrect = false
    }

    private var _dialogError: DialogError? by mutableStateOf(null)
    val dialogError get() = _dialogError
    fun clearDialogError() {
        _dialogError = null
    }

    /*
    email [X]                        > alertDialog = Email no encontrado
    email [0] > email-contraseña [0] > alertDialog = Log in correcto
    email [0] > email-contraseña [x] > alertDialog = Error en la contraseña
    */
    fun signIn(email: String, password: String){
       _userList.find { it.email == email }?.let {
           _userList.find { it.email == email && it.password == password }?.let {
               _dialogError = DialogError.CORRECT
           } ?: {
               _dialogError = DialogError.ERROR_PASSWORD
               _passwordNotCorrect = true
           }
       } ?: {
           _emailNotExists = true
           _dialogError = DialogError.ERROR_EMAIL
        }
    }
}